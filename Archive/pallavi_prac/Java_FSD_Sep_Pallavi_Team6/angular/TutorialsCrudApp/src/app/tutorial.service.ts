import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tutorial } from './tutorial.model';

const baseUrl: string = "http://localhost:8080/api/tutorials";

@Injectable({
  providedIn: 'root'
})
export class TutorialService {

  constructor(private http: HttpClient) { }

  listAllTutorials(): Observable<Tutorial[]> {
    return this.http.get<Tutorial[]>(baseUrl);
  }

  listTutorialDetails(id: number): Observable<Tutorial> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  listByTitle(title: string): Observable<Tutorial[]> {
    return this.http.get<Tutorial[]>(`${baseUrl}/title/${title}`);
  }
}
