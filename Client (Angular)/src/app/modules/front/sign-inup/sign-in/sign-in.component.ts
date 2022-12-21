import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../../services/user/user.service";
import {TokenStorageService} from "../../../../services/user/token-storage.service";
import {AuthenticationRequest} from "../../../../common/user/AuthenticationRequest";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(private service:UserService,private token:TokenStorageService,private route:Router) { }
  auth:AuthenticationRequest={
    username:"xx.ppp77@gmail.com",
    password:"123"
  }
  errorHandler!:string
  loginError:boolean=false;

  ngOnInit(): void {

  }
  Login(form:AuthenticationRequest)
  {
    this.service.signIn(form).subscribe(
      (response:any)=>
      {
        //console.log(response.data);
        this.token.saveToken(response.data);
        //console.log(this.token.getUser())

        this.service.loadUser(this.auth.username).subscribe(data=>
          {
            console.log("test")
            console.log(data)
            this.token.saveUser(data)
          }
        )
      },
      (error)=>
      {
        console.log(error)
/*
        switch (error.status)
        {
          case 404:
            this.loginError=true;
            this.errorHandler="user not found";
            console.log(this.loginError,this.errorHandler);
        }*/
      }
      ,
      ()=>{
        this.route.navigateByUrl('/front/home')
      }
    );

  }

}
