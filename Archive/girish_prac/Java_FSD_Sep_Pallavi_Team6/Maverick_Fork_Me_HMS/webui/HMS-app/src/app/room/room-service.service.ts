import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from './Room';
@Injectable({
  providedIn: 'root'
})
export class RoomServiceService {

  constructor(private httpClient: HttpClient) { }
  getRoom() : Observable<Room[]> {
    let url = "http://localhost:8080/MLPXX/api/room"
    return this.httpClient.get<Room[]>(url);
  }
}
 
