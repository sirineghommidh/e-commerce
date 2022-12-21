import { Component,Input, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import {ReclamationsService} from "../../../../services/reclamations.service";
import {reclamation} from "../../../../common/reclamation";
import {categorieReclamation} from "../../../../common/categorieReclamation";

@Component({
  selector: 'app-reclamation-form',
  templateUrl: './reclamation-form.component.html',
  styleUrls: ['./reclamation-form.component.css']
})
export class ReclamationFormComponent implements OnInit {

  addReclamation=this.fb.group({
   sujetField: ['',[Validators.required,Validators.pattern('[a-zA-Z ]+'),Validators.minLength(5)]],
   contenuField: ['',[Validators.required,Validators.pattern('[a-zA-Z ]+'),Validators.minLength(10)]],
   catNomField:[],
})

  constructor(private fb: FormBuilder, private reclamationService:ReclamationsService) { }
  subj!:String;
  cont!:String;
  catName!:String;
  testReclamation!:reclamation;

  cat!:categorieReclamation;
  @Input() reclamation!:reclamation;
  categories:categorieReclamation[]=[];
  display=false;
  displayAutre=false;
  ngOnInit(): void {
    this.listCatRec();
    console.log(this.categories);
  }

  get sujetField(){
    return this.addReclamation.get('sujetField');
  }

  get contenuField(){
    return this.addReclamation.get('contenuField');
  }

  get catNomField(){
    return this.addReclamation.get('catNomField');
  }

  GetobjAndShow(c:categorieReclamation)
  {
    this.takeObj(c);
    this.showForm();
  }

  showAndSend()
  {
    this.showForm();
    this.showAutre();
  }

  showAutre()
  {
    this.displayAutre=!this.displayAutre;
  }

  takeObj(c:categorieReclamation)
  {
    this.cat=c;
  }

  showForm()
  {
    this.display=!this.display;
  }

  getFormData()
  {
    this.subj=this.addReclamation.controls['sujetField'].value;
    this.cont=this.addReclamation.controls['contenuField'].value;
    this.catName=this.addReclamation.controls['catNomField'].value;


    this.sendData();
  }

  listCatRec()
  {
    this.reclamationService.getCategoryList().subscribe(
      (data)=>{this.categories=data;}
    )
  }

  sendData()
  {
    if (this.catName==null)
    {
      let rec1 = new reclamation();
      rec1.sujet=this.subj;
      rec1.contenu=this.cont;
      rec1.etat=0;
      rec1.category=this.cat;
      console.log(rec1);

      this.reclamationService.addReclamation(rec1).subscribe(
        (data)=>{this.testReclamation=data;console.log(this.testReclamation)},
        (error) =>{console.log(error);}
      )
    }

    else
    {
      let rec2 = new reclamation();
      rec2.sujet=this.subj;
      rec2.contenu=this.cont;
      rec2.etat=0;
      let newcat= new categorieReclamation();
      newcat.categoryName=this.catName;


      newcat.status=0;

      this.reclamationService.addCategory(newcat).subscribe(
        (data)=>{

          this.reclamationService.getidCatMax().subscribe(

            (data)=>{

              this.reclamationService.getCategoryById(data).subscribe(
                (data)=>{rec2.category=data; this.reclamationService.addReclamation(rec2).subscribe(
                  (data)=>{this.testReclamation=data;console.log(this.testReclamation)}
                )}
              )
            }
          )

        }
     )




    }
  }


}


