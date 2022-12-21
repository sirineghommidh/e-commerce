import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignUpComponent} from "./sign-up/sign-up.component";
import {SignInComponent} from "./sign-in/sign-in.component";
import {ProfileComponent} from "./profile/profile.component";
import {NotFound404Component} from "../../../not-found404/not-found404.component";

const routes: Routes = [
  {path:'',redirectTo:'profile',pathMatch:'full'},
  {path:'registration',component:SignUpComponent},
  {path:'login',component:SignInComponent},
  {path:'profile',component:ProfileComponent},



  {path:'**',component:NotFound404Component}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SignINUPRoutingModule { }
