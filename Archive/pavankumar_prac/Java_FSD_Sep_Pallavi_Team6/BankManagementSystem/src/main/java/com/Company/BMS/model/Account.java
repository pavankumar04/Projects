package com.Company.BMS.model;

import com.Company.BMS.util.AcctType;

public class Account {
	private long acctNo;
	private AcctType acctType;
	private int userId;
	private double balance;
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param acctNo
	 * @param acctType
	 * @param userId
	 * @param balance
	 */
	public Account(long acctNo, AcctType acctType, int userId, double balance) {
		this.acctNo = acctNo;
		this.acctType = acctType;
		this.userId = userId;
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Account [acctNo=" + acctNo + ", acctType=" + acctType + ", userId=" + userId + ", balance=" + balance
				+ "]";
	}


	/**
	 * @return the acctNo
	 */
	public long getAcctNo() {
		return acctNo;
	}


	/**
	 * @param acctNo the acctNo to set
	 */
	public void setAcctNo(long acctNo) {
		this.acctNo = acctNo;
	}


	/**
	 * @return the acctType
	 */
	public AcctType getAcctType() {
		return acctType;
	}


	/**
	 * @param acctType the acctType to set
	 */
	public void setAcctType(AcctType acctType) {
		this.acctType = acctType;
	}


	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}


	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
	
	

}
