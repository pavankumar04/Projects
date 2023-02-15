package com.sample.demo.data;

public class EmployeeImpl implements Employee {
	@Override
	public void showEmployeeData() {
		System.out.println("Employee Data here");
	}
	
	@Override
	public void printMessage(String msg) {
		System.out.println(msg);
	}
}
