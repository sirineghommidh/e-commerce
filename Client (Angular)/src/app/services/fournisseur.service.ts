import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Fournisseur} from "../common/fournisseur";
import {Observable, Subject} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
  };

@Injectable({
  providedIn: 'root'
})

export class FournisseurService {

  apiURL: string = 'http://localhost:8081/fournisseur/retrieve_all_fournisseurs';
  observer = new Subject();
  public subscriber$ = this.observer.asObservable();

  constructor(private httpClient: HttpClient) {
  }

  listeFournisseur(): Observable<Fournisseur[]>{
    return this.httpClient.get<Fournisseur[]>(this.apiURL);
    }

    ajouterFournisseur( four: Fournisseur):Observable<Fournisseur>{
      return this.httpClient.post<Fournisseur>('http://localhost:8081/fournisseur/add_fournisseur', four, httpOptions);
      }



  getFournisseurByID(idfournisseur: number): Observable<Fournisseur> {
    return this.httpClient.get<Fournisseur>('http://localhost:8081/fournisseur/retrieve_fournisseur/' + idfournisseur);
  }

  getFournisseursList(): Observable<Fournisseur[]> {
    return this.httpClient.get<Fournisseur[]>('http://localhost:8081/springMVC/servlet/fournisseur/retrieve_all_fournisseurs');
  }

  addFournisseur(f: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.post<Fournisseur>('http://localhost:8081/springMVC/servlet/fournisseur/add_fournisseur', f);
  }

  modifyFournisseur(f: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.put<Fournisseur>('http://localhost:8081/fournisseur/modify_fournisseur', f);
  }

  deleteFournisseur(idfournisseur: number) {
    return this.httpClient.delete<Fournisseur>('http://localhost:8081/fournisseur/remove-fournisseur/' + idfournisseur)
  }

}
