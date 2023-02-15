import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bdetails, BookingStatus } from '../app.component';
import { Booking } from '../booking.model';
import { BookingService } from '../booking.service';
import { Details } from '../details.model';
DatePipe;

@Component({
  selector: 'app-buseraddbooking',
  templateUrl: './buseraddbooking.component.html',
  styleUrls: ['./buseraddbooking.component.css'],
})
export class BuseraddbookingComponent implements OnInit {
  booking: Booking = {
    bookingId: 0,
    guestId: 0,
    roomId: 0,
    hotelId: 0,
    bookingDate: new Date(),
    checkInDate: new Date(),
    checkOutDate: new Date(),
    bookingStatus: BookingStatus.PLACED,
    totalDays: 0,
    totalAmount: 0,
  };

  bdetails = new Bdetails();
  details = new Details();

  bookings: Booking[] = [];
  actualSet: any[] = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private bookingService: BookingService
  ) {}

  ngOnInit(): void {
    this.details.guestId = this.route.snapshot.params['gid'];
    this.details.hotelId = this.route.snapshot.params['hid'];
    this.details.roomId = this.route.snapshot.params['rid'];
    this.details.cost = this.route.snapshot.params['cost'];
    this.loadBookings();
  }

  goToList() {
    this.router.navigate(['/bhome/user/home', this.details.guestId]);
  }

  addNewBooking() {
    this.booking.guestId = this.details.guestId;
    this.booking.hotelId = this.details.hotelId;
    this.booking.roomId = this.details.roomId;
    this.booking.checkInDate = this.bdetails.checkInDate;
    this.booking.checkOutDate = this.bdetails.checkOutDate;
    let time =
      new Date(this.bdetails.checkOutDate).getTime() -
      new Date(this.bdetails.checkInDate).getTime();
    let days = Math.ceil(time / (1000 * 60 * 60 * 24));
    this.booking.totalDays = days;

    this.booking.totalAmount = this.booking.totalDays * this.details.cost;

    console.log(this.booking.totalDays);
    this.bookingService.addNewBooking(this.booking).subscribe(
      (data) => {
        console.log(data);
        alert(data);
        if ((data = 'booking added successfully')) {
          this.goToList();
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }

  loadBookings(): void {
    this.bookingService.getAllBookings().subscribe(
      (data) => {
        console.log(data);
        this.bookings = data;
        this.actualSet = this.splitData(this.bookings, 3);
        console.log('Actual: ', this.actualSet);
      },
      (error) => console.log(error)
    );
  }

  splitData(arr: any, size: number) {
    let newArr: Booking[] = [];
    for (let i = 0; i < arr.length; i += size) {
      newArr.push(arr.slice(i, i + size));
      console.log(newArr);
    }
    return newArr;
  }

  returnUhome() {
    this.router.navigate(['/bhome/user']);
  }
}
