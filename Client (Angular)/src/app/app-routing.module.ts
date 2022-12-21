import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditFournisseurComponent } from './modules/back/fournisseur/edit-fournisseur/edit-fournisseur.component';
import {NotFound404Component} from "./not-found404/not-found404.component";

const routes: Routes = [
  {path:'',redirectTo:'front',pathMatch:'full'},
  { path: 'front', loadChildren: () => import('./modules/front/front.module').then(m => m.FrontModule) },
  { path: 'back', loadChildren: () => import('./modules/back/back.module').then(m => m.BackModule) },
  {path : "updateFournisseur/:id", component: EditFournisseurComponent},
  {path:'**',component:NotFound404Component}




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
