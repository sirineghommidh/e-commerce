import {Component, Input, OnInit} from '@angular/core';
import {ProduitService} from "../../../../../../services/produit.service";
import {Commentaire} from "../../../../../../common/commentaire";
import {Produit} from "../../../../../../common/produit";

@Component({
  selector: 'app-produit-commentaire',
  templateUrl: './produit-commentaire.component.html',
  styleUrls: ['./produit-commentaire.component.css']
})
export class ProduitCommentaireComponent implements OnInit {

  constructor(private produitservice : ProduitService) { }

  edit=false;
  c2 !: Commentaire;
  bad=false;
  str!: string;
  j!:number;

  @Input() produit !: Produit;

  ngOnInit(): void {

  }

  eventEdit(i:number){
    this.edit=true;
    this.j=i;

  }

  deleteCom(c:Commentaire){

    this.produitservice.deleteCom(c.idCommentaire).subscribe(
      (data) =>{this.getProdById(this.produit.idProduit);},
      (error) =>{}
    );
    this.edit=false;

  }

  likeModifyCom(c : Commentaire,prod :Produit){
    this.bad=false;
    c.likes=c.likes+1;
    this.produitservice.getByIDCom(c.idCommentaire).subscribe(
      (data) =>{this.c2=data; this.c2.likes=c.likes;this.c2.produit=prod;
        this.produitservice.modifyCom(this.c2).subscribe(
          (data) =>{},
          (error) =>{}

        )
      }
    );

    this.edit=false;

  }

  modifyCom(c : Commentaire,prod :Produit){
    this.bad=false;
    this.produitservice.getByIDCom(c.idCommentaire).subscribe(
      (data) =>{this.c2=data;this.c2.comment=c.comment;this.c2.produit=prod;
        this.produitservice.modifyCom(this.c2).subscribe(
          (data) =>{},
          (error) =>{if(error.status==406){alert("bad Word")}}

        )
      }
    );

    this.edit=false;

  }

  addCom(prod:Produit){
    let c3 = new Commentaire();
    c3.idClient=2;
    //aModifier
    c3.comment=this.str;
    c3.likes=0;
    c3.produit=prod;
this.bad=false;

    this.produitservice.addCom(c3).subscribe(
      (data) =>{this.getProdById(prod.idProduit);},
      (error) =>{if(error.status==500){
        alert("Empty  Comment");
      }else if (error.status==406){alert("Bad  Word")}
      else if (error.status==404){
        alert("Duplicated");
      }
      },
      () =>{}
    );

    this.edit=false;
    this.str='';

  }

  getProdById(id:any) {
    this.produitservice.getProdById(id).subscribe(
      (data) => {
        this.produit = data;
      }
    )
  }


}
