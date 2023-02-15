import { Stores } from './../models/stores.model';
import { StoresService } from './../services/stores.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Country, State, City } from 'country-state-city';

@Component({
  selector: 'app-addstore',
  templateUrl: './addstore.component.html',
  styleUrls: ['./addstore.component.css']
})
export class AddstoreComponent implements OnInit {

  cities = new Array();
  states = new Array();

  id = 0;
  store: Stores = {
    storeId: 0,
    storeName: '',
    city: '',
    state: ''
  };

  title = '';
  stateId = '';
  cityName = '';

  stateName = {
    countryCode: '',
    isoCode: '',
    latitude: '',
    longitude: '',
    name: ''
  };

  constructor(private storeService: StoresService, private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.states = State.getStatesOfCountry('IN');
    // this.cities = City.getCitiesOfState('IN', this.stateId);
  }

  goToDash() {
    this.router.navigate(['/adminDash', this.id]);
  }

  showProfileDetails() {
    this.router.navigate(['/profile', this.id]);
  }

  showAllStores() {
    this.router.navigate(['/stores', this.id]);
  }

  loadCities() {
    this.cities = City.getCitiesOfState('IN', this.stateId);
    console.log(this.cities);

    this.stateName = this.states.find((obj) => {
      return obj.isoCode === this.stateId;
    })
    console.log(this.stateName.name);
  }

  uploadStoreDetails() {
    this.store.storeName = this.title.toUpperCase();
    this.store.city = this.cityName;
    this.store.state = this.stateName.name;

    this.storeService.uploadStoreDetails(this.store)
    .subscribe(data => {
      console.log(data);
      if(data != null) {
        alert("New Store Details Uploaded");
      } else {
        alert("Unable to upload store details! Try later!");
      }
      window.location.reload();
    })
  }

}
