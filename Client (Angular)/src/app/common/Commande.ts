import {RegistrationRequest} from "./user/RegistrationRequest";
import {Facture} from "./Facture";


export class Commande {

  idCommande!:number ;

  montantRemise!: number ;
  montantPanier!: number ;

  etat!: boolean;
  pays!: string;
  u!:RegistrationRequest;
  facture !: Facture;
  numeroDeSuivi !:String
  modifiedAt!: Date;
  createdAt !: Date;




}
