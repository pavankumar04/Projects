import { DatePipe, formatDate } from '@angular/common';
import { Orders } from './../models/orders.model';
import { BooksService } from './../services/books.service';
import { ActivatedRoute, Router } from '@angular/router';
import { OrdersService } from './../services/orders.service';
import { Component, OnInit } from '@angular/core';
import { Books } from '../models/books.model';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  id = 0;
  val = 0;
  qty = 1;

  book: Books =
    {
      bookId: 1,
      title: 'Test Title',
      author: 'Unknown',
      storeId: 1,
      category: 'test',
      price: 23.00,
      no_copies: 10,
      availability: true
    };

  order: Orders = new Orders();
  datePipe!: DatePipe;

  constructor(private orderService: OrdersService, private route: ActivatedRoute,
    private router: Router, private bookService: BooksService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.val = this.route.snapshot.params['val'];
    this.loadData();
  }

  goHome() {
    if(this.val == 0) {
      this.router.navigate(['/home']);
    } else {
      this.router.navigate(['/cDash', this.val]);
    }
  }

  loadData() {
    this.bookService.getBookById(this.id)
    .subscribe(data => {
      console.log(data);
      this.book = data;
    }, error => console.log(error));
  }

  placeOrder() {
    if (this.val == 0) {
      alert('Please Login or Register to Continue');
      this.router.navigate(['/login', this.id]);
    } else {
      this.order.orderId = 0;
      let today = new Date();
      this.order.orderDate = today;
      let delDate = this.addDays(new Date(), 5);
      this.order.deliveryDate = delDate;
      this.order.amount = (this.book.price * this.qty) - (this.book.price * this.qty * 0.1);
      this.order.customerId = this.val;
      this.order.bookId = this.id;
      this.order.orderStatus = 'PENDING';
      this.order.quantity = this.qty;
      console.log(today);
      console.log(delDate);

      this.orderService.uploadNewOrderDetails(this.order)
      .subscribe(ele => {
        console.log(ele);
        alert(ele);
        this.router.navigate(['/cDash', this.val]);
      }, error => console.log(error));
      //this.router.navigate(['/cDash', this.val]);
    }
  }

  addDays(date: Date, days: number): Date {
    date.setDate(date.getDate() + days);
    return date;
  }

  logout() {
    this.id = 0;
    this.router.navigate(['/home']);
  }

  showProfileDetails() {
    this.router.navigate(['/cDetails', this.val]);
  }
}
