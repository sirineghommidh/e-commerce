import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { CategorieProduit } from 'src/app/common/categorieProduit';
import { DetailProduit } from 'src/app/common/detailProduit';
import { Produit } from 'src/app/common/produit';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html',
  styleUrls: ['./add-produit.component.css']
})
export class AddProduitComponent implements OnInit {

  categories: CategorieProduit[] = [];



  addprod=this.fb.group({
    codeProduit: ['',[Validators.required,Validators.minLength(4)]],
    libelleProduit: ['',[Validators.required,Validators.minLength(2)]],
    prixUnitaire: ['',[Validators.required,Validators.pattern('[0-9]+[.]{0,1}[0-9]{0,4}')]],
    imageUrl: ['',[Validators.required,Validators.pattern('http[s]?://.*')]]


  })
  addDetail=this.fb.group({
    cate: [''],
    descrip: ['',[Validators.required,Validators.minLength(15),Validators.maxLength(1000)]]

  })

  constructor(private fb: FormBuilder, private produitservice: ProduitService) {
  }

  ngOnInit(): void {
    this.listcategProduit();

  }


  listcategProduit() {

    this.produitservice.getCategoriesList().subscribe(
      (data) => {
        this.categories = data;
        console.log(this.categories);

      }
    )
  }
addPro(){
    let cp:number=1;
  let p= new Produit();
  let d= new DetailProduit();
   p.libelleProduit=this.addprod.controls['libelleProduit'].value;
  p.codeProduit=this.addprod.controls['codeProduit'].value;
    p.prixUnitaire=this.addprod.controls['prixUnitaire'].value;
      p.imageUrl=this.addprod.controls['imageUrl'].value;
p.etat=1;

  for(let categ of this.categories){
    if(categ.categorie==this.addDetail.controls['cate'].value){
      cp=categ.idCategorieProduit;
    }
  }
      d.description=this.addDetail.controls['descrip'].value;

  this.produitservice.addDetailProduit(d).subscribe(


    (data) =>{

      this.produitservice.getidmax().subscribe((data) =>{
        d.idDetailProduit=data;
        console.log(data);
        p.detailProduit=d;

        this.produitservice.addProduit(p).subscribe(


          (data) =>{
            this.produitservice.getidprodmax().subscribe(
              (data)=>{
                p.idProduit=data;
                this.produitservice.affectdetToprod(p.idProduit,d.idDetailProduit).subscribe(


                  (data) =>{
                    this.produitservice.affectdetTocateg(d.idDetailProduit,cp).subscribe(

                      (data)=>{

                      }
                    )

                  },
                  (error) =>{console.log(error);},
                  () =>{})


              });




          },
          (error) =>{console.log(error);},
          () =>{}
        );

      });


    },
    (error) =>{console.log(error);},
    () =>{}
  );


}








  get libelleProduit(){
    return this.addprod.get('libelleProduit');
  }
  get codeProduit(){
    return this.addprod.get('codeProduit');
  }
  get imageUrl(){
    return this.addprod.get('imageUrl');
  }
  get prixUnitaire(){
    return this.addprod.get('prixUnitaire');
  }
  get cate(){
    return this.addDetail.get('cate');
  }
  get descrip(){
    return this.addDetail.get('descrip');
  }





}
