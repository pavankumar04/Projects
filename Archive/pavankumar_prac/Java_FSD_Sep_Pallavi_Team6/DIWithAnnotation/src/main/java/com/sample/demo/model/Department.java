package com.sample.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Department {

	private Employee employee;
		
	@Autowired
	public Department(Employee employee) {
		this.employee = employee;
	}
	
	public void showDetails() {
		employee.showDetails();
	}
}
