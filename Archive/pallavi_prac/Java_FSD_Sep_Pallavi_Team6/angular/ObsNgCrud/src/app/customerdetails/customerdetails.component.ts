import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from './../services/customer.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../models/customer.model';

@Component({
  selector: 'app-customerdetails',
  templateUrl: './customerdetails.component.html',
  styleUrls: ['./customerdetails.component.css']
})
export class CustomerdetailsComponent implements OnInit {

  customer: Customer = {
    customerId: 0,
    firstName: 'Unknown',
    lastName: 'Doe',
    address: '',
    phone: '',
    email: '',
    wallet: 0.0,
    passcode: '',
    coupon: ''
  }

  id = 0;

  curPass = '';
  newPass = '';
  confirmPass = '';

  isVisible = false;

  constructor(private customerService: CustomerService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.loadDetails();
  }

  loadDetails() {
    this.customerService.getCustomerDetailsById(this.id)
    .subscribe(data => {
      console.log(data);
      this.customer = data;
    }, error => console.log(error));
  }

  updateCustomerAddress() {
    this.customerService.updateAddress(this.customer)
    .subscribe(data => {
      console.log(data);
      alert(data);
    }, error => console.log(error));
  }

  updateCustomerPhone() {
    this.customerService.updatePhone(this.customer)
    .subscribe(data => {
      console.log(data);
      alert(data);
    }, error => console.log(error));
  }

  updatePassword() {
    if(this.curPass == this.customer.passcode && this.newPass == this.confirmPass) {
      this.customerService.updatePassword(this.customer)
      .subscribe(data => {
        console.log(data);
        alert(data);
        this.loadDetails();
      }, error => console.log(error));
    } else {
      alert("Password Mismatch! Try Again!");
      this.loadDetails();
    }


  }

  updateWalletAmount() {
    this.customerService.updateWallet(this.customer)
    .subscribe(data => {
      console.log(data);
      alert(data);
    }, error => console.log(error));
  }

  goToDash() {
    this.router.navigate(['/cDash', this.id]);
  }

  goToCart(bId: number){
    this.router.navigate(['/cart', bId, this.id]);
  }

  logout() {
    this.id = 0;
    this.router.navigate(['/home']);
  }

  goToOrders() {
    this.router.navigate(['/orders', this.id])
  }

  toggleShow() {
    this.isVisible = !this.isVisible;
  }
}
