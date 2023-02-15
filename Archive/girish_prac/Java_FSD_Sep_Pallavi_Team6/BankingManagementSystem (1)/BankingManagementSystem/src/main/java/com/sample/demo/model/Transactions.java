package com.sample.demo.model;

import java.time.LocalDate;

public class Transactions {
	
	private int transactionId;
	private int accountNumber;
	private String transactionType;
	private String transactionStatus;
	private int secondAccount;
	private LocalDate transactionDate;
	
	public Transactions() {
		
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public int getSecondAccount() {
		return secondAccount;
	}

	public void setSecondAccount(int secondAccount) {
		this.secondAccount = secondAccount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	

	public Transactions(int transactionId, int accountNumber, String transactionType,String transactionStatus, int secondAccount,
			LocalDate transactionDate) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.secondAccount = secondAccount;
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", transactionType=" + transactionType + ", transactionStatus=" + transactionStatus
				+ ", secondAccount=" + secondAccount + ", transactionDate=" + transactionDate + "]";
	}

	
	
	
	

}
