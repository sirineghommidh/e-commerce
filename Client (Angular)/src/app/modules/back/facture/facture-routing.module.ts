import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListAddressesComponent} from "../livraison/list-addresses/list-addresses.component";
import {ListFacturesComponent} from "./list-factures/list-factures.component";

const routes: Routes = [
  {path: 'listfacture', component:ListFacturesComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FactureRoutingModule { }
