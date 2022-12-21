import { Component, OnInit } from '@angular/core';
import {ProduitService} from "../../../services/produit.service";
import {CategorieProduit} from "../../../common/categorieProduit";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  categories: CategorieProduit[] = [];

  constructor(private produitservice: ProduitService) {
  }

  ngOnInit(): void {
    this.listcategProduit();

  }

  listcategProduit() {

    this.produitservice.getCategoriesList().subscribe(
      (data) => {
        this.categories = data;
        console.log(this.categories);

      }
    )

  }
}
