import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CartDetailsComponent} from "./cart-details/cart-details.component";

const routes: Routes = [
  {path:"cart-details",component:CartDetailsComponent},
  {path:"",redirectTo:"CartDetailsComponent",pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartRoutingModule { }
