import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from './customer.model';

const baseUrl = "http://localhost:8080/api/customers";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  showAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(baseUrl);
  }

  getCustomerDetailsByEmail(email: string): Observable<Customer> {
    return this.http.get<Customer>(`${baseUrl}/email/${email}`);
  }

  getCustomerById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${baseUrl}/${id}`);
  }
}
