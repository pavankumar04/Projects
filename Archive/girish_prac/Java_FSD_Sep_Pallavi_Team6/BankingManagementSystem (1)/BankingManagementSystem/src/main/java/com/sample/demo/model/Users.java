package com.sample.demo.model;

public class Users {
	private String firstName;
	private String lastName;
	private String email;
	private int phoneNumber;
	private int panNumber;
	private int aadharNumber;
	private String address;
	private String city;
	
	public Users () {
	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(int panNumber) {
		this.panNumber = panNumber;
	}

	public int getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(int aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Users(String firstName, String lastName, String email, int phoneNumber, int panNumber, int aadharNumber,
			String address, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.address = address;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber + ", address=" + address
				+ ", city=" + city + "]";
	}
	
	
	

}
