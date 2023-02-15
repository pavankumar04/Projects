import { BookingStatus } from './app.component';

export class Booking {
  bookingId!: number;
  guestId!: number;
  roomId!: number;
  hotelId!: number;
  bookingDate!: Date;
  checkInDate!: Date;
  checkOutDate!: Date;
  bookingStatus!: BookingStatus;
  totalDays!: number;
  totalAmount!: number;
}
