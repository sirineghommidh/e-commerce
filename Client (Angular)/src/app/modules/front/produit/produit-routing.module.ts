import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProduitGridComponent} from "./produit-grid/produit-grid.component";
import {ProduitDetailComponent} from "./produit-grid/produit-detail/produit-detail.component";
import {HomeComponent} from "../home/home.component";

const routes: Routes = [

  {path: 'produits', component:ProduitGridComponent },
  {path: 'produits/produitdetail/:id', component: ProduitDetailComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProduitRoutingModule { }
