import {Profession} from "./Profession";

export class RegistrationRequest
{
  firstName!:string;
  lastName!:string;
  email!:string;
  dateNaissance!:Date;
  password!:string;
  profession!:Profession;
}
