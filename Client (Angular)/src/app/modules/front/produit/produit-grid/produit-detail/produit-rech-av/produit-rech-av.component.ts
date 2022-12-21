import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {ProduitService} from "../../../../../../services/produit.service";
import {CategorieProduit} from "../../../../../../common/categorieProduit";
import {Produit} from "../../../../../../common/produit";

@Component({
  selector: 'app-produit-rech-av',
  templateUrl: './produit-rech-av.component.html',
  styleUrls: ['./produit-rech-av.component.css']
})
export class ProduitRechAvComponent implements OnInit {
  @Output() pr= new EventEmitter <Produit[]>();
  produits:Produit[]=[];
  categories  : CategorieProduit[]=[];
 cat !: string;
 lib !: string;
 minprix!:string;
 maxprix!:string;
 staar!:string;
  rechav=this.fb.group({
    cat: [''],
    productName: ['',[Validators.pattern('[a-zA-Z]+')]],
    prixmin: ['',[Validators.pattern('[0-9]+[.]{0,1}[0-9]{0,4}')]],
    prixmax: ['',[Validators.pattern('[0-9]+[.]{0,1}[0-9]{0,4}')]],
    staar: ['']

  })
  constructor( private fb:FormBuilder,private produitservice : ProduitService) {

  }
  $endNotif(){
    this.staar=this.rechav.controls['staar'].value;
    this.lib=this.rechav.controls['productName'].value;
    this.cat=this.rechav.controls['cat'].value;
    this.minprix=this.rechav.controls['prixmin'].value;
    this.maxprix=this.rechav.controls['prixmax'].value;
if(this.staar=='--Aucune--'||this.staar===''){
  this.staar="-1";console.log(this.staar);
}
if(this.minprix==''){
  this.minprix="-1";
}
    if(this.maxprix==''){
      this.maxprix="-1";
    }
    console.log(this.cat);
    if(this.cat=='--Aucune--'||this.cat==''){
      this.cat="-1";
    }
    if(this.lib===''){
      this.lib="-1";
    }


    this.produitservice.getrechavProdList(this.cat,this.lib,this.minprix,this.maxprix,this.staar).subscribe(
      (data)=>{this.produits=data;console.log(this.produits);this.pr.emit(this.produits);}
    )

  }

  ngOnInit(): void {
    this.listcategProduit();
  }

  get productName(){
    return this.rechav.get('productName');
  }
  get prixmin(){
    return this.rechav.get('prixmin');
  }
  get prixmax(){
    return this.rechav.get('prixmax');
  }

  listcategProduit(){

    this.produitservice.getCategoriesList().subscribe(
      (data)=>{this.categories=data;console.log(this.categories);

      }

    )

  }



}
