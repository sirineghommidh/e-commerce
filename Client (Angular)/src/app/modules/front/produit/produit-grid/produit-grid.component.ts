import {Component, OnChanges, OnInit} from '@angular/core';
import {Commentaire} from "../../../../common/commentaire";
import {Produit} from "../../../../common/produit";
import {ProduitService} from "../../../../services/produit.service";
import {ActivatedRoute, NavigationEnd, NavigationError, NavigationStart, Router} from "@angular/router";
import {CartServiceService} from "../../../../services/cart-service.service";
import {CartItem} from "../../../../common/cart-item";

@Component({
  selector: 'app-produit-grid',
  templateUrl: './produit-grid.component.html',
  styleUrls: ['./produit-grid.component.css']
})
export class ProduitGridComponent implements OnInit,OnChanges {

  edit=false;
  c2 !: Commentaire;

  str!: string;
  j!:number;
  categ!:string | null;

  produits : Produit[]=[];

  constructor(private produitservice : ProduitService,private activateRouter:ActivatedRoute,private cartService: CartServiceService, private router: Router) {
    this.router.events.subscribe((complete) => {
      if (complete instanceof NavigationStart) {

      }

      if (complete instanceof NavigationEnd) {

        this.activateRouter.paramMap.subscribe((params) => {
          this.categ=params.get('categorie');})

        if (this.categ!=='home'){
          this.prodParCateg(this.categ);
        }
        if (this.categ==='home'){
          this.listProduit();
        }
      }

      if (complete instanceof NavigationError) {


      }
    });
  }

  ngOnInit(): void {
    if (this.categ==='home'){
      this.listProduit();
    }


  }

  ngOnChanges(){

  }

  eventEdit(i:number){
    this.edit=true;
    this.j=i;

  }

  rechAvProd(prods:Produit[]){
    this.produits=prods;
  }

  deleteCom(c:Commentaire){

    this.produitservice.deleteCom(c.idCommentaire).subscribe(
      (data) =>{},
      (error) =>{}
    );
    this.edit=false;
    this.listProduit();
  }

  likeModifyCom(c : Commentaire){
    c.likes=c.likes+1;
    this.produitservice.getByIDCom(c.idCommentaire).subscribe(
      (data) =>{this.c2=data; this.c2.likes=c.likes;
        this.produitservice.modifyCom(this.c2).subscribe(
          (data) =>{this.listProduit();},
          (error) =>{}

        )
      }
    );

    this.edit=false;
    this.listProduit();
  }

  modifyCom(c : Commentaire){

    this.produitservice.getByIDCom(c.idCommentaire).subscribe(
      (data) =>{this.c2=data; this.c2.comment=c.comment;
        this.produitservice.modifyCom(this.c2).subscribe(
          (data) =>{this.listProduit();},
          (error) =>{}

        )
      }
    );

    this.edit=false;

  }

  addCom(prod:Produit){
    let c3 = new Commentaire();

    c3.idClient=2;//aModifier
    c3.comment=this.str;
    c3.likes=0;
    c3.produit=prod;


    this.produitservice.addCom(c3).subscribe(
      (data) =>{},
      (error) =>{},
      () =>{this.listProduit();}
    );

    this.edit=false;

  }

  listProduit(){

    this.produitservice.getProductsList().subscribe(
      (data)=>{this.produits=data;
      /*  for( let pro  of this.produits){
          pro.commentaire.sort();
        };*/


      }

    )

  }
  prodParCateg(categ :string | null){


      this.produitservice.getcategProdList(categ).subscribe(
        (data)=>{this.produits=data;

        }

      )

  }

  /*mta3 si riadh*/
  addToCart(tempProduct: Produit) {
    console.log('Adding to cart :'+tempProduct.libelleProduit + '   price :'+tempProduct.prixUnitaire);

    const  theCartItem= new CartItem(tempProduct);
    this.cartService.addToCart(theCartItem);

  }



}
