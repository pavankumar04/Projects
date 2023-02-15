import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminbookingdetailsComponent } from './adminbookingdetails/adminbookingdetails.component';
import { BadminComponent } from './badmin/badmin.component';
import { BhomeComponent } from './bhome/bhome.component';
import { BookingdetailsComponent } from './bookingdetails/bookingdetails.component';
import { BuseraddbookingComponent } from './buseraddbooking/buseraddbooking.component';
import { BuserhomeComponent } from './buserhome/buserhome.component';
import { BuserhomeafterbookingComponent } from './buserhomeafterbooking/buserhomeafterbooking.component';

const routes: Routes = [
  { path: 'bhome/admin/:bid', component: AdminbookingdetailsComponent },
  { path: 'bhome/admin', component: BadminComponent },
  {
    path: 'bhome/user/home/details/:gid/:bid',
    component: BookingdetailsComponent,
  },
  { path: 'bhome/user/home/:gid', component: BuserhomeafterbookingComponent },
  { path: 'bhome/user/home', component: BuserhomeafterbookingComponent },
  { path: 'cart/:gid/:hid/:rid/:cost', component: BuseraddbookingComponent },
  { path: 'bhome/user', component: BuserhomeComponent },
  { path: 'bhome', component: BhomeComponent },
  { path: '', redirectTo: 'bhome', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
