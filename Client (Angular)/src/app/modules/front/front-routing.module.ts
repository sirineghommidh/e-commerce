import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FrontComponent } from './front.component';
import {HomeComponent} from "./home/home.component";
import {ProduitGridComponent} from "./produit/produit-grid/produit-grid.component";
import {ProduitDetailComponent} from "./produit/produit-grid/produit-detail/produit-detail.component";
import {ReclamationFormComponent} from "./reclamations/reclamation-form/reclamation-form.component";
import {NotFound404Component} from "../../not-found404/not-found404.component";



const routes: Routes = [
  { path: '', component: FrontComponent ,
    children: [
      {path: 'home', component:ProduitGridComponent },
      {path:'',redirectTo:'home',pathMatch:'full'},
      {path: 'ReclamationForm',component:ReclamationFormComponent},
      { path: 'cart', loadChildren: () => import('./cart/cart.module').then(m => m.CartModule) },
      { path: ':categorie', loadChildren: () => import('./produit/produit.module').then(m => m.ProduitModule) },
      {path:'user',loadChildren:()=>import('./sign-inup/sign-inup.module').then(m=>m.SignINUPModule)},


      //el path heda lezmou ykoun fellekher
      {path:'**',component:NotFound404Component}
      ]


  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FrontRoutingModule { }
