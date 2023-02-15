import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../booking.model';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-buserhomeafterbooking',
  templateUrl: './buserhomeafterbooking.component.html',
  styleUrls: ['./buserhomeafterbooking.component.css'],
})
export class BuserhomeafterbookingComponent implements OnInit {
  booking!: Booking[];
  // books: Books[] = [];
  bookings: Booking[] = [];
  actualSet: any[] = [];
  guestId = 0;
  constructor(
    private bookingService: BookingService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.guestId = this.route.snapshot.params['gid'];
    this.loadBookings();
  }

  loadBookings(): void {
    this.bookingService.findByGuestId(this.guestId).subscribe(
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

  showDetails(gid: number, bid: number) {
    this.router.navigate(['/bhome/user/home/details', gid, bid]);
  }

  addBooking() {
    this.router.navigate(['/admin/add']);
  }

  addBookingByUser() {
    this.router.navigate(['/user/add']);
  }

  filterBookings(status: string) {
    this.bookingService.getByBookingStatus(status).subscribe(
      (data) => {
        console.log(data);
        this.bookings = data;
        this.actualSet = this.splitData(this.bookings, 3);
      },
      (error) => console.log(error)
    );
  }

  deleteBooking(id: number) {
    this.bookingService.deleteBooking(id).subscribe(
      (data) => {
        console.log(data);
        alert(data);
        this.returnHome();
      },
      (error) => console.log(error)
    );
  }

  returnHome() {
    this.router.navigate(['/bhome']);
  }

  returnUhome() {
    this.router.navigate(['/bhome/user']);
  }

  goToList() {
    this.router.navigate(['/bhome/user/home', this.guestId]);
  }
}
