import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router'
import { Fournisseur } from 'src/app/common/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-edit-fournisseur',
  templateUrl: './edit-fournisseur.component.html',
  styleUrls: ['./edit-fournisseur.component.css']
})
export class EditFournisseurComponent implements OnInit {

  EditFournisseur = new Fournisseur();
  EditForm : FormGroup;
  



  constructor(private fb: FormBuilder, private fournisseurservice: FournisseurService,private activatedRoute: ActivatedRoute,private router: Router) {
  }

   
    

/*
  get libelle_fournisseur(){
    return this.addfour.get('libelle_fournisseur');
  }
  get code_fornisseur(){
    return this.addfour.get('code_fornisseur');
  }
  get numero_Tel(){
    return this.addfour.get('numero_Tel');
  }
  get categorie(){
    return this.addfour.get('categorie');
  }*/

  ngOnInit(): void {
  
    this.fournisseurservice.getFournisseurByID(this.activatedRoute.snapshot.params.id).subscribe((four)=>{
      this.EditFournisseur=four;
      this.EditForm=this.fb.group({
        idfournisseur: [{"value" : this.EditFournisseur.idfournisseur, "disabled":true}],
        libelle_fournisseur: [this.EditFournisseur.libelle_fournisseur],
        code_fornisseur: [this.EditFournisseur.code_fornisseur],
        numero_Tel: [this.EditFournisseur.numero_Tel],
        categorie:[this.EditFournisseur.categorie]
      })
      
      console.log(four);
      console.log(this.EditFournisseur);


    } ) ;
 
 
  }
  EditFournisseurr(){
    console.log(this.EditForm.getRawValue());
    this.fournisseurservice.modifyFournisseur(this.EditForm.getRawValue()).subscribe();
    this.router.navigate(['back/fournisseur']);
    }

  

}
