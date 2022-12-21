import { Injectable } from '@angular/core';
import {SignINUPModule} from "../../modules/front/sign-inup/sign-inup.module";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {RegistrationRequest} from "../../common/user/RegistrationRequest";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {AuthenticationRequest} from "../../common/user/AuthenticationRequest";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl=environment.baseUrl;
  constructor(private http:HttpClient) { }

  signup(Request:RegistrationRequest):Observable<RegistrationRequest>
  {
    return this.http.post<RegistrationRequest>(this.baseUrl+'/registration',Request,{ responseType: 'text' as 'json' });
  }

  signIn(Request:AuthenticationRequest):Observable<AuthenticationRequest>
  {
    return this.http.post<AuthenticationRequest>(this.baseUrl+'/authenticate',Request);
  }

   loadUser(email:String):Observable<any>
   {
     return this.http.get(this.baseUrl+'/user/userByEmail?email='+email);
   }
}
