import {Produit} from "./produit";
import {CategorieProduit} from "./categorieProduit";

export class DetailProduit {


  idDetailProduit!: number;

  dateCreation !: Date;


  dateDernierModification !: Date;

  description !: string;

  categorieProduit !: CategorieProduit;



  produit !: Produit;


}
