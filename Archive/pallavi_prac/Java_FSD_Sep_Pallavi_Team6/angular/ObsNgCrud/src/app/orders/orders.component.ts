import { BooksService } from './../services/books.service';
import { Orders } from './../models/orders.model';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomerService } from './../services/customer.service';
import { OrdersService } from './../services/orders.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  id = 0;

  orders: Orders[] = [];

  titles: string[] = [];

  constructor(private orderService: OrdersService, private customerService: CustomerService,
    private router: Router, private route: ActivatedRoute, private bookService: BooksService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.loadOrders();
  }

  loadOrders() {
    this.orderService.listAllCustomerOrders(this.id)
    .subscribe(data => {
      console.log(data);
      this.orders = data;
      for(let i = 0; i < data.length; i++) {
        this.bookService.getBookById(data[i].bookId)
        .subscribe(ele => {
          console.log(ele);
          this.titles.push(ele.title);
        });
      }
    }, error => console.log(error));
  }

  filterByStatus(status: string) {
    this.titles.splice(0, this.titles.length);
    this.orderService.showAllCustomerOrdersByStatus(status, this.id)
    .subscribe(data => {
      console.log(data);
      this.orders = data;
      for(let i = 0; i < data.length; i++) {
        this.bookService.getBookById(data[i].bookId)
        .subscribe(ele => {
          console.log(ele);
          this.titles.push(ele.title);
        });
      }
    }, error => console.log(error));
  }

  loadCurrentOrders() {

  }
}
