import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../../services/user/user.service";
import {RegistrationRequest} from "../../../../common/user/RegistrationRequest";
import {Profession} from "../../../../common/user/Profession";
import {Router} from "@angular/router";


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {


  constructor(private service:UserService,private router:Router) { }
  confirm!:string;
  request:RegistrationRequest={
    firstName:'',
  lastName:'',
  email:'',
  dateNaissance:new Date(''),
  password:"",
  profession:Profession.AUTRE,
  }


  ngOnInit(): void {

  }
  success:boolean=false;
  register(form:any):void
  {
    //console.log(form);
    //console.log(this.request);
    this.service.signup(this.request).subscribe(
      (data)=>console.log(data),
      (e)=>console.log(e),
      ()=>
      {
        console.log('complete');
        this.success=true;
        this.router.navigateByUrl('/front/home');
      },
      )


  }

}
