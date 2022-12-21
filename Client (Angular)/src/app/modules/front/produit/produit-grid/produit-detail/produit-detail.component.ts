import { Input,SimpleChange,Component, OnInit,OnChanges } from '@angular/core';
import {Produit} from "../../../../../common/produit";
import {ProduitService} from "../../../../../services/produit.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.css']
})
export class ProduitDetailComponent implements OnInit {

   produit= new Produit();

   sttr:string='0';

  constructor(private produitservice : ProduitService, private activatedroute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedroute.paramMap.subscribe((params) => {
      this.getProdById(params.get('id'));})
    


  }
  getProdById(id:any){
    this.produitservice.getProdById(id).subscribe(
      (data) =>{this.produit=data;}

    )
  }

  addetoile(){
    
    this.produitservice.etoile(this.produit.idProduit,5,this.sttr).subscribe(
      (data)=>{this.getProdById(this.produit.idProduit)

      }

    );

  }


}
