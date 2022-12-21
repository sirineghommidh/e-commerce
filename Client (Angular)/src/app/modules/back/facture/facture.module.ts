import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FactureRoutingModule } from './facture-routing.module';
import { ListFacturesComponent } from './list-factures/list-factures.component';


@NgModule({
  declarations: [
    ListFacturesComponent
  ],
  imports: [
    CommonModule,
    FactureRoutingModule
  ]
})
export class FactureModule { }
