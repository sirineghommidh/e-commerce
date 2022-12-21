import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FrontRoutingModule } from './front-routing.module';
import { FrontComponent } from './front.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { PreloaderComponent } from './preloader/preloader.component';
import { CartStatusComponent } from './cart-status/cart-status.component';
import { ReclamationFormComponent } from './reclamations/reclamation-form/reclamation-form.component';
import {NotFound404Component} from "../../not-found404/not-found404.component";




@NgModule({
  declarations: [
    FrontComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    HomeComponent,
    PreloaderComponent,
    CartStatusComponent,
    NotFound404Component
  ],
  imports: [
    CommonModule,
    FrontRoutingModule
  ]
})
export class FrontModule { }
