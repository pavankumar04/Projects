import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Stores } from '../models/stores.model';

const baseUrl = 'http://localhost:8080/api/stores';

@Injectable({
  providedIn: 'root'
})
export class StoresService {

  constructor(private http: HttpClient) { }

  listAllStores(): Observable<Stores[]> {
    return this.http.get<Stores[]>(baseUrl);
  }

  showStoreDetails(id: number): Observable<Stores> {
    return this.http.get<Stores>(`${baseUrl}/${id}`);
  }

  listByCity(city: string): Observable<Stores[]> {
    return this.http.get<Stores[]>(`${baseUrl}/city/${city}`);
  }

  listByState(state: string): Observable<Stores[]> {
    return this.http.get<Stores[]>(`${baseUrl}/state/${state}`);
  }

  uploadStoreDetails(store: Stores): Observable<Stores> {
    return this.http.post<Stores>(baseUrl, store);
  }

  deleteStore(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}/remove/${id}`,
    {headers: {'content-type': 'application/json'}, observe: 'response', responseType: 'text'})
      .pipe(map(data => {
        console.log(data.body);
        return data.body;
      }));
  }
}
