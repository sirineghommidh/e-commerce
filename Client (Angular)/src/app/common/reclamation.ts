import {categorieReclamation} from "./categorieReclamation"

export class reclamation
{
  idReclamation !:number ;
  sujet!:String ;
  contenu!:String;
  CreatedAt!:Date;
  EditedAt!:Date;
  etat!:number;
  // User client;
  category!:categorieReclamation ;
}
