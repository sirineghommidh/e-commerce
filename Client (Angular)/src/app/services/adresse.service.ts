import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Fournisseur} from "../common/fournisseur";
import {environment} from "../../environments/environment";
import {Adresse} from "../common/Adresse";
const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};

@Injectable({
  providedIn: 'root'
})


export class AdresseService {
  apiURL: string = environment.baseUrl+"/addresse";
  observer = new Subject();
  public subscriber$ = this.observer.asObservable();

  constructor(private httpClient: HttpClient) {
  }
  listAddresse(): Observable<Adresse[]>{
    return this.httpClient.get<Adresse[]>(this.apiURL+"/retrieve_all_adresses");
  }
}
