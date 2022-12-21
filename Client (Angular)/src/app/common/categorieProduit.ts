import {DetailProduit} from "./detailProduit";

export class CategorieProduit {


  idCategorieProduit !: number;


  categorie !: string;



  detailproduit !: Set<DetailProduit>;

}
