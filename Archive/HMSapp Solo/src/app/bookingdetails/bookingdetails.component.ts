import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingStatus } from '../app.component';
import { Booking } from '../booking.model';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-bookingdetails',
  templateUrl: './bookingdetails.component.html',
  styleUrls: ['./bookingdetails.component.css'],
})
export class BookingdetailsComponent implements OnInit {
  booking!: Booking;
  bookingId!: number;
  guestId!: number;
  constructor(
    private bookingService: BookingService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.guestId = this.route.snapshot.params['gid'];
  }

  ngOnInit(): void {
    this.bookingId = this.route.snapshot.params['bid'];
    this.showBookingDetails(this.bookingId);
  }

  showBookingDetails(val: number) {
    this.bookingService.getBookingDetails(val).subscribe((data) => {
      console.log(data);
      this.booking = data;
    });
  }

  deleteBooking(bid: number) {
    this.bookingService.deleteBooking(bid).subscribe(
      (data) => {
        console.log(data);
        alert(data);
        this.returnUhome();
      },
      (error) => console.log(error)
    );
  }

  cancelBooking() {
    this.booking.bookingStatus = BookingStatus['CANCELLED'];
    this.bookingService.updateStatus(this.booking).subscribe(
      (data) => {
        console.log(data);
        alert(data);
      },
      (error) => console.log(error)
    );
  }

  returnUhome() {
    console.log('guestid is : ', this.guestId);
    this.router.navigate(['/bhome/user/home', this.guestId]);
  }

  returnHome() {
    this.router.navigate(['/bhome']);
  }
}
