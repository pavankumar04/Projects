import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee.model';

const baseUrl = "http://localhost:8080/api/employees";
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getEmployeeByEmail(email: string): Observable<Employee> {
    return this.http.get<Employee>(`${baseUrl}/email/${email}`);
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${baseUrl}/${id}`);
  }

}
