package com.sample.demo.model;

public class Recepient {
	private String name;
	private int phoneNumber;
	private int accountNumber;
	
	public Recepient() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Recepient(String name, int phoneNumber, int accountNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Recipient [name=" + name + ", phoneNumber=" + phoneNumber + ", accountNumber=" + accountNumber + "]";
	}
	
	

}
