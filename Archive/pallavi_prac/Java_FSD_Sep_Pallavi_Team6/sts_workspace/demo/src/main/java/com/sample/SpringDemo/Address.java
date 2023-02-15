package com.sample.SpringDemo;

public class Address {
	private int doorNo;
	private String street;
	private String city;

	public Address() {}
	
	public Address(int doorNo, String street, String city) {
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", city=" + city + "]";
	}
	
	public int getDoorNo() {
		return doorNo;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
}
