import { Component, OnInit } from '@angular/core';
import {Facture} from "../../../../common/Facture";
import {FactureService} from "../../../../services/facture.service";

@Component({
  selector: 'app-list-factures',
  templateUrl: './list-factures.component.html',
  styleUrls: ['./list-factures.component.css']
})
export class ListFacturesComponent implements OnInit {

  factures: Facture[]=[];

  constructor(private factureservice: FactureService) { }

  ngOnInit(): void {
    this.factureservice.listfacture().subscribe(f => {
      console.log(f);
      this.factures = f;
    });
  }
}
