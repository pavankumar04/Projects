package com.Company.BMS.model;

import com.Company.BMS.util.BankType;

public class Recepient {
	private int rcptId;
	private long acctNo;
	private String name;
	private String phoneNo;
	private BankType bankType;
	
	public Recepient() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Recepient [rcptId=" + rcptId + ", acctNo=" + acctNo + ", name=" + name + ", phoneNo=" + phoneNo
				+ ", bankType=" + bankType + "]";
	}

	/**
	 * @param rcptId
	 * @param acctNo
	 * @param name
	 * @param phoneNo
	 * @param bankType
	 */
	public Recepient(int rcptId, long acctNo, String name, String phoneNo, BankType bankType) {
		this.rcptId = rcptId;
		this.acctNo = acctNo;
		this.name = name;
		this.phoneNo = phoneNo;
		this.bankType = bankType;
	}

	/**
	 * @return the rcptId
	 */
	public int getRcptId() {
		return rcptId;
	}

	/**
	 * @param rcptId the rcptId to set
	 */
	public void setRcptId(int rcptId) {
		this.rcptId = rcptId;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the bankType
	 */
	public BankType getBankType() {
		return bankType;
	}

	/**
	 * @param bankType the bankType to set
	 */
	public void setBankType(BankType bankType) {
		this.bankType = bankType;
	}
	
	
	
	
	

	
	

}
