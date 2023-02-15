import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BhomeComponent } from './bhome/bhome.component';
import { BuserhomeComponent } from './buserhome/buserhome.component';
import { BuseraddbookingComponent } from './buseraddbooking/buseraddbooking.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BuserhomeafterbookingComponent } from './buserhomeafterbooking/buserhomeafterbooking.component';
import { BadminComponent } from './badmin/badmin.component';
import { BookingdetailsComponent } from './bookingdetails/bookingdetails.component';
import { AdminbookingdetailsComponent } from './adminbookingdetails/adminbookingdetails.component';

@NgModule({
  declarations: [
    AppComponent,
    BhomeComponent,
    BuserhomeComponent,
    BuseraddbookingComponent,
    BuserhomeafterbookingComponent,
    BadminComponent,
    BookingdetailsComponent,
    AdminbookingdetailsComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
