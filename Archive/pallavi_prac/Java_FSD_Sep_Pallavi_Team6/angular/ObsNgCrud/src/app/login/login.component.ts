import { Customer } from './../models/customer.model';
import { Employee } from '../models/employee.model'
import { EmployeeService } from '../services/employee.service';
import { CustomerService } from '../services/customer.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string = '';
  pass: string = '';
  employee!: Employee;
  confirm: string = '';
  val = 0;
  customer: Customer = {
    customerId: 0,
    firstName: '',
    lastName: '',
    address: '',
    phone: '',
    email: '',
    wallet: 0.0,
    passcode: '',
    coupon: ''
  };

  constructor(private customerService: CustomerService,
    private employeeService: EmployeeService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.val = this.route.snapshot.params['id'];
  }

  login(): void {
    if(this.username.includes('pageage')) {
      this.employeeService.getEmployeeByEmail(this.username)
        .subscribe(data => {
          console.log(data);
          this.employee = data;
          if (this.employee.passcode == this.pass) {
            console.log(this.pass);
            let id = this.employee.employeeId;
            this.router.navigate(['/adminDash', id]);
          } else {
            alert("Username or Password wrong!");
          }
        }, error => console.log(error));
    } else {
      this.customerService.getCustomerByEmail(this.username)
        .subscribe(data => {
          console.log(data);
          this.customer = data;
          if (this.customer.passcode == this.pass) {
            console.log(this.pass);
            let id = this.customer.customerId;
            if (this.val == 0) {
              this.router.navigate(['/cDash', id]);
            } else {
              this.router.navigate(['/cart', this.val, id]);
            }

          } else {
            alert("Username or Password wrong!");
          }
        }, error => console.log(error));
    }
  }

  registerCustomer() {
    if (this.confirm == this.customer.passcode) {
      this.customerService.uploadCustomerDetails(this.customer)
      .subscribe(data => {
        console.log(data);
        if (data != null) {
          alert("Registration Successful");
          window.location.reload();
        }
      }, error => console.log(error))
    } else {
      alert("Please re - enter the data");
    }
  }

  goHome() {
    this.router.navigate(['/home']);
  }
}
