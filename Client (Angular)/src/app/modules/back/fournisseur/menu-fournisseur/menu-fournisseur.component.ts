import { Component, OnInit } from '@angular/core';
import {Fournisseur} from "../../../../common/fournisseur";
import {FournisseurService} from "../../../../services/fournisseur.service";

@Component({
  selector: 'app-menu-fournisseur',
  templateUrl: './menu-fournisseur.component.html',
  styleUrls: ['./menu-fournisseur.component.css']
})
export class MenuFournisseurComponent implements OnInit {
  
  fournisseurs: Fournisseur[]=[];



  constructor(private FournisseurService: FournisseurService) { }

  ngOnInit(): void { 
    this.FournisseurService.listeFournisseur().subscribe(fourns => {
      console.log(fourns);
      this.fournisseurs = fourns;
      });

  }

  deleteProvider(i: number, j: number) {
    this.fournisseurs.splice(j, 1);
    this.FournisseurService.deleteFournisseur(i).subscribe();
  }

}
