import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Fournisseur } from 'src/app/common/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.css']
})
export class FournisseurComponent implements OnInit {

  newFournisseur= new Fournisseur();

  

  addfour=this.fb.group({
    libelle_fournisseur: ['',[Validators.required,Validators.pattern('[a-zA-Z]+'),Validators.minLength(3)]],
    code_fornisseur: ['',[Validators.required,Validators.pattern('[0-9]+'),Validators.minLength(3)]],
    numero_Tel: ['',[Validators.required,Validators.pattern('[0-9]{8}$')]],
    categorie:['']
  })

  constructor(private fb: FormBuilder, private fournisseurservice: FournisseurService,private router: Router) {
  }

  addFournisseur(){
    console.log(this.addfour.getRawValue());
    this.fournisseurservice.ajouterFournisseur(this.addfour.getRawValue()).subscribe();
    this.router.navigate(['back/fournisseur']);
    }
   
    

  ngOnInit(): void {
  }

  get libelle_fournisseur(){
    return this.addfour.get('libelle_fournisseur');
  }
  get code_fornisseur(){
    return this.addfour.get('code_fornisseur');
  }
  get numero_Tel(){
    return this.addfour.get('numero_Tel');
  }
  get categorie(){
    return this.addfour.get('categorie');
  }

}
