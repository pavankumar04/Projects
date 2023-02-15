import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bhome',
  templateUrl: './bhome.component.html',
  styleUrls: ['./bhome.component.css'],
})
export class BhomeComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  userHome() {
    console.log('hello');
    this.router.navigate(['/bhome/user']);
  }

  admin() {
    this.router.navigate(['/bhome/admin']);
  }
}
