import { Component, OnInit } from '@angular/core';
import {Adresse} from "../../../../common/Adresse";
import {Livraison} from "../../../../common/Livraison";
import {AdresseService} from "../../../../services/adresse.service";
import {LivraisonService} from "../../../../services/livraison.service";

@Component({
  selector: 'app-list-livraison',
  templateUrl: './list-livraison.component.html',
  styleUrls: ['./list-livraison.component.css']
})
export class ListLivraisonComponent implements OnInit {
  livraisons: Livraison[]=[];

  constructor(private livraisonservice: LivraisonService) { }

  ngOnInit(): void {
    this.livraisonservice.listlivraison().subscribe(livraisons => {
      console.log(livraisons);
      this.livraisons = livraisons;
    });
  }

}
