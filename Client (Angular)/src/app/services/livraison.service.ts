import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Adresse} from "../common/Adresse";
import {environment} from "../../environments/environment";
import {Livraison} from "../common/Livraison";
const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};
@Injectable({
  providedIn: 'root'
})
export class LivraisonService {
  apiURL: string = environment.baseUrl+"/livraison";
  observer = new Subject();
  public subscriber$ = this.observer.asObservable();


  constructor(private httpClient: HttpClient) {
  }
  listlivraison(): Observable<Livraison[]>{
    return this.httpClient.get<Livraison[]>(this.apiURL+"/retrieve_all_livraisons");
  }
}
