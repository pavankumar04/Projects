import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Details } from '../details.model';

@Component({
  selector: 'app-buserhome',
  templateUrl: './buserhome.component.html',
  styleUrls: ['./buserhome.component.css'],
})
export class BuserhomeComponent implements OnInit {
  details = new Details();

  constructor(private router: Router) {}

  ngOnInit(): void {}

  returnHome() {
    this.router.navigate(['/bhome']);
  }

  goToCart() {
    console.log(
      'enterted gotocart method',
      this.details.guestId,
      this.details.hotelId,
      this.details.roomId,
      this.details.cost
    );
    this.router.navigate([
      '/cart',
      this.details.guestId,
      this.details.hotelId,
      this.details.roomId,
      this.details.cost,
    ]);
  }
}
