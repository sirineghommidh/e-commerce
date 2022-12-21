import {Commentaire} from "./commentaire";
import {DetailProduit} from "./detailProduit";

export class Produit {

  idProduit!:number ;

  codeProduit!: string ;

  libelleProduit!:string;

  prixUnitaire!: number;

  etat!:number;

  etoile!: number;

  imageUrl !: string;

  clientEtoile!: Map<number,number>;

  stock !: number;//stock

  rayon!: number;//rayon

  detailFacture !: Set<any> ;

  detailProduit !:DetailProduit; //detprod

  fournisseurs !: Set<any>; //Fournis


  commentaire !: Array<Commentaire>;



  dateCreated !: Date;

  lastUpdated !: Date;


  // to complete if you have other fields for the Produit model

}
