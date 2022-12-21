import {Livraison} from "./Livraison";
import {Commande} from "./Commande";


export class Facture {

  idFacture!:number ;

  montantFacture!: number ;

  active!: boolean;

  matricule_Fiscal!:string;

  pays!: string;

  Adressetype !: string;
  livraison !: Livraison;
  commande !:Commande
  modifiedAt!: Date;
  createdAt !: Date;




}
