import {Facture} from "./Facture";
import {Adresse} from "./Adresse";


export class Livraison {

  idLivraison!:number ;

  adresse !: Adresse;
  adresseMagasin !:Adresse;
  facture !:Facture;
  distance !:number;
  dureeitineraire !:number;
  prixLivraison!: number;
  dateCreation !: Date;
  dateArrivage !: Date;
  modifiedAt!: Date;



}
