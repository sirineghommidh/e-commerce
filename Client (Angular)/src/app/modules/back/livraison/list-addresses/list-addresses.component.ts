import { Component, OnInit } from '@angular/core';
import {Fournisseur} from "../../../../common/fournisseur";
import {Adresse} from "../../../../common/Adresse";
import {AdresseService} from "../../../../services/adresse.service";

@Component({
  selector: 'app-list-addresses',
  templateUrl: './list-addresses.component.html',
  styleUrls: ['./list-addresses.component.css']
})
export class ListAddressesComponent implements OnInit {
  addresses: Adresse[]=[];

  constructor(private adresseService: AdresseService) { }

  ngOnInit(): void {
    this.adresseService.listAddresse().subscribe(adresses => {
      console.log(adresses);
      this.addresses = adresses;
    });

  }

}
