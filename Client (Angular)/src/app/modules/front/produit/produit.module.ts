import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProduitRoutingModule } from './produit-routing.module';
import { ProduitGridComponent } from './produit-grid/produit-grid.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ProduitService} from "../../../services/produit.service";
import { ProduitDetailComponent } from './produit-grid/produit-detail/produit-detail.component';
import {ProduitCommentaireComponent} from "./produit-grid/produit-detail/produit-commentaire/produit-commentaire.component";
import { ProduitRechAvComponent } from './produit-grid/produit-detail/produit-rech-av/produit-rech-av.component';



@NgModule({
  declarations: [
    ProduitGridComponent,
    ProduitDetailComponent,
    ProduitCommentaireComponent,
    ProduitRechAvComponent
  ],
  imports: [
    CommonModule,
    ProduitRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ProduitRoutingModule
  ],
  providers: [ProduitService]
})
export class ProduitModule { }
