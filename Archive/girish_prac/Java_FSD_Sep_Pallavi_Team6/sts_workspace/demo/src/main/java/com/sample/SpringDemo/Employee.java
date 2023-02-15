package com.sample.SpringDemo;

public class Employee {
	private int empId;
	private String empName;
	
	private Address address; //aggregation
	
	public Employee() {
		
	}
	
	public Employee(int id) {
		this.empId = id;
	}
	
	public Employee(int id, String name, Address addr) {
		this.empId = id;
		this.empName = name;
		this.address = addr;
	}
	
	public void displayData() {
		System.out.println("Id: " + this.empId + ", Name: " + this.empName);
		System.out.println(address.toString());
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
