import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LivraisonRoutingModule } from './livraison-routing.module';
import { ListLivraisonComponent } from './list-livraison/list-livraison.component';
import { ListAddressesComponent } from './list-addresses/list-addresses.component';


@NgModule({
  declarations: [
    ListLivraisonComponent,
    ListAddressesComponent
  ],
  imports: [
    CommonModule,
    LivraisonRoutingModule
  ]
})
export class LivraisonModule { }
