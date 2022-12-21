import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListLivraisonComponent} from "./list-livraison/list-livraison.component";
import {ListAddressesComponent} from "./list-addresses/list-addresses.component";

const routes: Routes = [
  {path: 'listLivraisons', component:ListLivraisonComponent },
  {path: 'listAddresses', component:ListAddressesComponent },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LivraisonRoutingModule { }
