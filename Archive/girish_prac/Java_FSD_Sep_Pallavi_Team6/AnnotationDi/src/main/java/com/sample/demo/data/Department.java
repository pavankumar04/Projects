package com.sample.demo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Department {

    private Employee employee;
    
    //constructor - based DI
    //@Autowired
    public Department(Employee employee) {
        this.employee = employee;
    }
    
    public void showEmployeeData() {
        employee.showEmployeeData();
    }
    
    //setter based DI
    @Autowired
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public void printMessage(String msg) {
        employee.printMessage(msg);
    }
}
