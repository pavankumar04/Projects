import { AddstoreComponent } from './addstore/addstore.component';
import { AddbookComponent } from './addbook/addbook.component';
import { StoreslistComponent } from './storeslist/storeslist.component';
import { EditbookComponent } from './editbook/editbook.component';
import { AdminprofileComponent } from './adminprofile/adminprofile.component';
import { OrdersComponent } from './orders/orders.component';
import { CartComponent } from './cart/cart.component';
import { CustomerdetailsComponent } from './customerdetails/customerdetails.component';
import { BookdetailsComponent } from './bookdetails/bookdetails.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CustomerdashComponent } from './customerdash/customerdash.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login/:id', component: LoginComponent},
  {path: 'cDash/:id', component: CustomerdashComponent},
  {path: 'adminDash/:id', component: AdmindashComponent},
  {path: 'details/:id/:val', component: BookdetailsComponent},
  {path: 'cDetails/:id', component: CustomerdetailsComponent},
  {path: 'cart/:id/:val', component: CartComponent},
  {path: 'orders/:id', component: OrdersComponent},
  {path: 'profile/:id', component: AdminprofileComponent},
  {path: 'editbook/:id/:val', component: EditbookComponent},
  {path: 'stores/:id', component: StoreslistComponent},
  {path: 'addbook/:id', component: AddbookComponent},
  {path: 'addstore/:id', component: AddstoreComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
]

@NgModule({
  declarations:[],
  imports:[
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})

export class AppRoutingModule { }
