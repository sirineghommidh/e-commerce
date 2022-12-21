import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Produit} from "../common/produit";
import {Commentaire} from "../common/commentaire";
import {Observable, Subject} from "rxjs";
import {CategorieProduit} from "../common/categorieProduit";
import { DetailProduit } from '../common/detailProduit';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  observer = new Subject();
  public subscriber$ = this.observer.asObservable();

  constructor(private httpClient: HttpClient) {
  }


  getByIDCom(idc: number): Observable<Commentaire> {
    return this.httpClient.get<Commentaire>('http://localhost:8081/retrieve-commentaire/' + idc);
  }

  getProdById(idp: any): Observable<Produit> {
    return this.httpClient.get<Produit>('http://localhost:8081/retrieve-produit/' + idp);

  }

  getProductsList(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>('http://localhost:8081/retrieve-all-produits');
  }

  addCom(c: Commentaire): Observable<Commentaire> {

    return this.httpClient.post<Commentaire>('http://localhost:8081/add-commentaire', c);
  }

  modifyCom(c: Commentaire): Observable<Commentaire> {

    /*const httpOptions = {
      headers: new HttpHeaders(
        { 'Content-Type': 'application/json' }
      )
    };
    //console.log(c.comment);
    let userJSON = JSON.stringify(c);
    //console.log(userJSON.toString());
    */
    return this.httpClient.put<Commentaire>('http://localhost:8081/modify-commentaire', c);
  }

  deleteCom(id: any) {
    return this.httpClient.delete<Commentaire>('http://localhost:8081/remove-client/' + id)
  }

  getCategoriesList(): Observable<CategorieProduit[]> {
    return this.httpClient.get<CategorieProduit[]>('http://localhost:8081/retrieve_all_categorieProduit');
  }

  getrechavProdList(cat : string,lib : string,minprix:string,maxprix:string,staar:string): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>('http://localhost:8081/ret/'+cat+'/'+minprix+'/'+maxprix+'/'+lib+'/'+staar);
  }
  getcategProdList(cat : string | null): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>('http://localhost:8081/ret/'+cat+'/-1/-1/-1/-1');
  }

  addProduit(p: Produit): Observable<Produit> {
    return this.httpClient.post<Produit>('http://localhost:8081/add-produit', p);
  }
  getidprodmax(): Observable<number> {
    return this.httpClient.get<number>('http://localhost:8081/idmax');
  }
  getidmax(): Observable<number> {
    return this.httpClient.get<number>('http://localhost:8081/idmaxdet');
  }
  addDetailProduit(d: DetailProduit): Observable<DetailProduit> {
    return this.httpClient.post<DetailProduit>('http://localhost:8081/add_detailProduit', d);
  }

  affectdetToprod(idpro:number,iddet:number): Observable<Produit>{
  return this.httpClient.get<Produit>('http://localhost:8081/affectedetailProduitToProduit/'+idpro+'/'+iddet);
  }

  affectdetTocateg(iddetpro:number,idcat:number): Observable<DetailProduit>{
    return this.httpClient.get<DetailProduit>('http://localhost:8081/affectedetaildetaiProduitTocateg/'+iddetpro+'/'+idcat);
  }

  etoile(prodid:number,clientid:number,rev:string): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8081/add-etoile/'+prodid+'/'+clientid+'/'+rev);
  }
}
