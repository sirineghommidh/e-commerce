import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReclamationsRoutingModule } from './reclamations-routing.module';
import { ReclamationFormComponent } from './reclamation-form/reclamation-form.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ReclamationsService} from "../../../services/reclamations.service";


@NgModule({
  declarations: [
    ReclamationFormComponent
  ],
  imports: [
    CommonModule,
    ReclamationsRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers:[ReclamationsService]
})
export class ReclamationsModule { }
