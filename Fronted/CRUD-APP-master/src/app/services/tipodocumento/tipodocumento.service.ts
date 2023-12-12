import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'; 

@Injectable({
  providedIn: 'root'
})
export class TipodocumentoService {

  private API_SERVER = "http://localhost:8080/tipodocumento/";

  constructor(
    private HttpClient: HttpClient
  ) { }

  public getAllTipodocumento(): Observable<any>{
    return this.HttpClient.get(this.API_SERVER);
  }

}
