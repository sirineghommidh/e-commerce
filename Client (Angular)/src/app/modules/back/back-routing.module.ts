import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BackComponent } from './back.component';
import {DashboardComponent} from "./dashboard/dashboard.component";
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { MenuFournisseurComponent } from './fournisseur/menu-fournisseur/menu-fournisseur.component';
import { MenuComponent } from './menu/menu.component';
import { AddProduitComponent } from './produit/add-produit/add-produit.component';


const routes: Routes = [
  { path: '', component: BackComponent,
    children: [
      {path: 'home', component: DashboardComponent},
      {path:'',redirectTo:'home',pathMatch:'full'},
      {path: 'add', component: AddProduitComponent},
      {path: 'fournisseur/add', component: FournisseurComponent},
      {path: 'fournisseur', component: MenuFournisseurComponent},
      {path: 'livraison', loadChildren: () => import('./livraison/livraison.module').then(m => m.LivraisonModule) },
      {path: 'facture', loadChildren: () => import('./facture/facture.module').then(m => m.FactureModule) },

    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BackRoutingModule { }
