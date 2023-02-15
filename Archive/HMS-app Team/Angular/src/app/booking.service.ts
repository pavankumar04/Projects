import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Booking } from './booking.model';
import { map } from 'rxjs/operators';

const baseUrl = 'http://localhost:8080/api/booking';
@Injectable({
  providedIn: 'root',
})
export class BookingService {
  booking!:Booking;
  constructor(private http: HttpClient) {}

  getAllBookings(): Observable<any> {
    return this.http.get<Booking[]>(baseUrl);
  }

  findByGuestId(gid:number): Observable<any> {
    return this.http.get<Booking[]>(`${baseUrl}/guest/${gid}`);
  }

  // updateStatus(bid:number,status:string): Observable<any> {
  //   return this.http.get<Booking[]>(`${baseUrl}/status/${bid}/${status}`);
  // }


  updateStatus(booking:Booking): Observable<any> {
    return this.http
      .put(
        `${baseUrl}/status/${booking.bookingId}/${booking.bookingStatus}`,booking,
        {
          headers: { 'content-type': 'application/json' },
          observe: 'response',
          responseType: 'text',
        }
      )
      .pipe(
        map((data) => {
          console.log(data.body);
          return data.body;
        })
      );
  }



  getBookingDetails(id: number): Observable<Booking> {
    return this.http.get<Booking>(`${baseUrl}/${id}`);
  }

  addNewBooking(booking: Booking): Observable<any> {
    const header = { 'content-type': 'application/json' };
    return this.http
      .post(`${baseUrl}`, booking, {
        headers: header,
        observe: 'response',
        responseType: 'text',
      })
      .pipe(
        map((data) => {
          console.log(data.body);
          return data.body;
        })
      );
  }

  getByBookingStatus(status: string): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${baseUrl}/status/${status}`);
  }

  deleteBooking(bid: number): Observable<any> {
    return this.http
      .delete(`${baseUrl}/delete/${bid}`, {
        headers: { 'content-type': 'application/json' },
        observe: 'response',
        responseType: 'text',
      })
      .pipe(
        map((data) => {
          console.log(data.body);
          return data.body;
        })
      );
  }
}
