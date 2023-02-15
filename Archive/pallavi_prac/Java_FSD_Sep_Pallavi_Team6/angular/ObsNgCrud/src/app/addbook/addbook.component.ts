import { BooksService } from './../services/books.service';
import { Books } from './../models/books.model';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {
  id = 0;

  book: Books = {
    bookId: 0,
    title: '',
    author: '',
    availability: true,
    no_copies: 0,
    category: '',
    price: 0,
    storeId: 0
  };

  constructor(private employeeService: EmployeeService, private router: Router,
    private route: ActivatedRoute, private bookService: BooksService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
  }

  goToDash() {
    this.router.navigate(['/adminDash', this.id]);
  }

  showAllStores() {
    this.router.navigate(['/stores', this.id]);
  }

  showProfileDetails() {
    this.router.navigate(['/profile', this.id]);
  }

  uploadBookDetails() {
    //console.log(this.book);
    this.bookService.uploadNewBook(this.book)
    .subscribe(data => {
      console.log(data);
      if (data != null) {
        alert("New Book Details Uploaded");
        window.location.reload();
      } else {
        alert ("Unable to Upload Details");
      }
    })
  }
}
