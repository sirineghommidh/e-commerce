import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './modules/back/header/header.component';
import { MenuComponent } from './modules/back/menu/menu.component';
import { FooterComponent } from './modules/back/footer/footer.component';
import { DashboardComponent } from './modules/back/dashboard/dashboard.component';
import { PreloaderComponent } from './modules/back/preloader/preloader.component';
import {BackModule} from "./modules/back/back.module";
import {FrontModule} from "./modules/front/front.module";
import { ProduitModule } from './modules/front/produit/produit.module';
import {HttpClientModule} from "@angular/common/http";
import {ProduitService} from "./services/produit.service";
import { FournisseurService } from './services/fournisseur.service';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {ProduitGridComponent} from "./modules/front/produit/produit-grid/produit-grid.component";
import { ReclamationsModule } from './modules/front/reclamations/reclamations.module';
import { ReclamationModule } from './modules/back/reclamation/reclamation.module';
import { FactureModule } from './modules/back/facture/facture.module';
import { LivraisonModule } from './modules/back/livraison/livraison.module';




@NgModule({
  declarations: [
    AppComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BackModule,
    FrontModule,
    ProduitModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ReclamationsModule,
    FactureModule,
    LivraisonModule,

    ReclamationsModule,
    ReclamationModule
  ],
  providers: [ProduitService,FournisseurService],
  bootstrap: [AppComponent]
})
export class AppModule { }
