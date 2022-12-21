import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SignINUPRoutingModule } from './sign-inup-routing.module';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ProfileComponent } from './profile/profile.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    SignUpComponent,
    SignInComponent,
    ProfileComponent,

  ],
    imports: [
        CommonModule,
        SignINUPRoutingModule,
        FormsModule
    ]
})
export class SignINUPModule { }
