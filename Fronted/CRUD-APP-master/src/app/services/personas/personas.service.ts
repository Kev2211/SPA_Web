import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'; 


@Injectable({
  providedIn: 'root'
})
export class PersonasService {

  private API_SERVER = "http://localhost:8080/persona/";

  constructor(private HttpClient: HttpClient) { }

  public getAllPersona(): Observable<any>{
    return this.HttpClient.get(this.API_SERVER);
  }

  public savePersona (persona:any): Observable<any>{
    return this.HttpClient.post(this.API_SERVER, persona);
  }

  public deletePersona(id): Observable<any>{
    return this.HttpClient.delete(this.API_SERVER + "delete/"+id);
  }
}
