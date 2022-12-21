import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {environment} from "../../environments/environment";
import {Livraison} from "../common/Livraison";
import {Facture} from "../common/Facture";
const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};
@Injectable({
  providedIn: 'root'
})
export class FactureService {
  apiURL: string = environment.baseUrl+"/facture";
  observer = new Subject();
  public subscriber$ = this.observer.asObservable();

  constructor(private httpClient: HttpClient) {
  }
  listfacture(): Observable<Facture[]>{
    return this.httpClient.get<Facture[]>(this.apiURL+"/retrieve_all_Factures");
  }
}
