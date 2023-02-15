import { Employee } from './../models/employee.model';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeService } from './../services/employee.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminprofile',
  templateUrl: './adminprofile.component.html',
  styleUrls: ['./adminprofile.component.css']
})
export class AdminprofileComponent implements OnInit {

  id = 0;
  employee: Employee = new Employee();
  curPass = '';
  newPass = '';
  confirmPass = '';

  isVisible = false;

  constructor(private employeeService: EmployeeService, private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.loadProfile();
  }

  loadProfile() {
    this.isVisible = false;
    this.employeeService.getEmployeeById(this.id)
    .subscribe(data => {
      console.log(data);
      this.employee = data;
    }, error => console.log(error))
  }

  goToDash() {
    this.router.navigate(['/adminDash', this.id]);
  }

  showAllStores() {
    this.router.navigate(['/stores', this.id]);
  }

  addNewBookDetails() {
    this.router.navigate(['/addbook', this.id]);
  }

  toggleShow() {
    this.isVisible = !this.isVisible;
  }

  updatePassword() {
    if (this.curPass == this.employee.passcode && this.newPass == this.confirmPass) {
      this.employee.employeeId = this.id;
      this.employee.passcode = this.newPass;
      this.employeeService.updatePassword(this.employee)
      .subscribe(data => {
        console.log(data);
        alert(data);
        this.loadProfile();
      }, error => console.log(error));
    } else {
      alert("Password Mismatch! Try Again!");
      this.loadProfile();
    }
  }
}
