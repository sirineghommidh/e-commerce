import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BackRoutingModule } from './back-routing.module';
import { BackComponent } from './back.component';
import {DashboardComponent} from "./dashboard/dashboard.component";
import {FooterComponent} from "./footer/footer.component";
import {HeaderComponent} from "./header/header.component";
import {MenuComponent} from "./menu/menu.component";
import {PreloaderComponent} from "./preloader/preloader.component";
import { AddProduitComponent } from './produit/add-produit/add-produit.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { MenuFournisseurComponent } from './fournisseur/menu-fournisseur/menu-fournisseur.component';
import { EditFournisseurComponent } from './fournisseur/edit-fournisseur/edit-fournisseur.component';


@NgModule({
  declarations: [
    BackComponent,
    DashboardComponent,
    FooterComponent,
    HeaderComponent,
    MenuComponent,
    PreloaderComponent,
    AddProduitComponent,
    FournisseurComponent,
    MenuFournisseurComponent,
    EditFournisseurComponent
  ],
  imports: [
    CommonModule,
    BackRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class BackModule { }
