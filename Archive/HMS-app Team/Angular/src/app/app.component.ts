import { Component } from '@angular/core';

export enum BookingStatus {
  PLACED = 'PLACED',
  BOOKED = 'BOOKED',
  REJECTED = 'REJECTED',
  CANCELLED = 'CANCELLED',
}

export class Bdetails {
  checkInDate!: Date;
  checkOutDate!: Date;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'HMS-app';
}
