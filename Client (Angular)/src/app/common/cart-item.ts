import {Produit} from "./produit";

export class CartItem {

  id !: number;
  name !:string;
  imageUrl !:string;
  unitPrice !: number;
  quantity!:number;

  constructor(produit : Produit) {
    this.id=produit.idProduit;
    this.name=produit.libelleProduit;
    this.imageUrl=produit.imageUrl;
    this.unitPrice=produit.prixUnitaire;
    this.quantity=1;

  }
}
