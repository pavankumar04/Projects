import { BooksService } from './../services/books.service';
import { Router, ActivatedRoute } from '@angular/router';
import { StoresService } from './../services/stores.service';
import { Stores } from './../models/stores.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-storeslist',
  templateUrl: './storeslist.component.html',
  styleUrls: ['./storeslist.component.css']
})
export class StoreslistComponent implements OnInit {

  stores: Stores[] = [];
  id = 0;

  constructor(private storesService: StoresService, private router: Router,
    private route: ActivatedRoute, private bookService: BooksService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.loadData();
  }

  loadData() {
    this.storesService.listAllStores()
    .subscribe(data => {
      console.log(data);
      this.stores = data;
    }, error => console.log(error));
  }

  goToDash() {
    this.router.navigate(['/adminDash', this.id]);
  }

  deleteStore(val: number) {
    alert('to be completed');
    // this.storesService.deleteStore(val)
    // .subscribe(data => {
    //   console.log(data);
    //   alert(data);
    // }, error => console.log(error));
  }

  showProfilePage() {
    this.router.navigate(['/profile', this.id]);
  }
}
