import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingStatus } from '../app.component';
import { Booking } from '../booking.model';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-adminbookingdetails',
  templateUrl: './adminbookingdetails.component.html',
  styleUrls: ['./adminbookingdetails.component.css'],
})
export class AdminbookingdetailsComponent implements OnInit {
  booking!: Booking;
  bookingId!: number;
  guestId!: number;
  constructor(
    private bookingService: BookingService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.bookingId = this.route.snapshot.params['bid'];
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
        this.returnAhome();
      },
      (error) => console.log(error)
    );
  }

  cancelled() {
    this.booking.bookingStatus = BookingStatus['CANCELLED'];
    this.bookingService.updateStatus(this.booking).subscribe(
      (data) => {
        console.log(data);
        alert(data);
      },
      (error) => console.log(error)
    );
  }
  placed() {
    this.booking.bookingStatus = BookingStatus['PLACED'];
    this.bookingService.updateStatus(this.booking).subscribe(
      (data) => {
        console.log(data);
        alert(data);
      },
      (error) => console.log(error)
    );
  }
  booked() {
    this.booking.bookingStatus = BookingStatus['BOOKED'];
    this.bookingService.updateStatus(this.booking).subscribe(
      (data) => {
        console.log(data);
        alert(data);
      },
      (error) => console.log(error)
    );
  }
  rejected() {
    this.booking.bookingStatus = BookingStatus['REJECTED'];
    this.bookingService.updateStatus(this.booking).subscribe(
      (data) => {
        console.log(data);
        alert(data);
      },
      (error) => console.log(error)
    );
  }

  returnAhome() {
    this.router.navigate(['/bhome/admin']);
  }

  returnHome() {
    this.router.navigate(['/bhome']);
  }
}
