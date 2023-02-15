import { InlineEditComponent } from './inline-edit/inline-edit.component';
import { CustomDatePipe } from './custom.datepipe';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CustomerdashComponent } from './customerdash/customerdash.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { BookdetailsComponent } from './bookdetails/bookdetails.component';
import { CustomerdetailsComponent } from './customerdetails/customerdetails.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CartComponent } from './cart/cart.component';
import { OrdersComponent } from './orders/orders.component';
import { AdminprofileComponent } from './adminprofile/adminprofile.component';
import { StoreslistComponent } from './storeslist/storeslist.component';
import { AddbookComponent } from './addbook/addbook.component';
import { AddstoreComponent } from './addstore/addstore.component';
import { EditbookComponent } from './editbook/editbook.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CustomerdashComponent,
    AdmindashComponent,
    BookdetailsComponent,
    CustomDatePipe,
    CustomerdetailsComponent,
    InlineEditComponent,
    CartComponent,
    OrdersComponent,
    AdminprofileComponent,
    StoreslistComponent,
    AddbookComponent,
    AddstoreComponent,
    EditbookComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
