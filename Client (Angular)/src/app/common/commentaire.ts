import {Produit} from "./produit";

export class Commentaire {


  idCommentaire !: number ;

  idClient !: number;

  comment !: string;

  likes !: number;

  produit !: Produit;


  dateCreated!: Date;


  lastUpdated!: Date;





}
