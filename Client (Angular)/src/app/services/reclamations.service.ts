import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {categorieReclamation} from "../common/categorieReclamation";
import {reclamation} from "../common/reclamation";

@Injectable({
  providedIn: 'root'
})
export class ReclamationsService {
  observer = new Subject();
  public subscriber$ = this.observer.asObservable();

  constructor(private httpClient: HttpClient) { }

  getCategoryList():Observable<categorieReclamation[]>
  {
    return this.httpClient.get<categorieReclamation[]>('http://localhost:8081/categorieReclamation/retrieve-all-categories');
  }

  addCategory(cat:categorieReclamation):Observable<categorieReclamation>
  {
    return this.httpClient.post<categorieReclamation>('http://localhost:8081/categorieReclamation/client/add-category',cat);
  }

  addReclamation(rec:reclamation):Observable<reclamation>
  {
    return this.httpClient.post<reclamation>('http://localhost:8081/reclamation/client/add-reclamation',rec);
  }

  getidCatMax(): Observable<number> {
    return this.httpClient.get<number>('http://localhost:8081/categorieReclamation/idmax');
  }

  getCategoryById(idc:any):Observable<categorieReclamation>
  {
    return this.httpClient.get<categorieReclamation>('http://localhost:8081/categorieReclamation/admin/get-one-category/'+ idc);
  }
}
