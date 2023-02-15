package com.Company.BMS.model;

import java.time.LocalDate;

import com.Company.BMS.util.TxnType;

public class Transaction {
	private int txnId;
	private long acctNo;
	private long othersAcct;
	private LocalDate txnDate;
	private TxnType txnType;
	private double txnAmount;
	private double balance;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param txnId
	 * @param acctNo
	 * @param othersAcct
	 * @param txnDate
	 * @param txnType
	 * @param txnAmount
	 * @param balance
	 */
	public Transaction(int txnId, long acctNo, long othersAcct, LocalDate txnDate, TxnType txnType, double txnAmount,
			double balance) {
		this.txnId = txnId;
		this.acctNo = acctNo;
		this.othersAcct = othersAcct;
		this.txnDate = txnDate;
		this.txnType = txnType;
		this.txnAmount = txnAmount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [txnId=" + txnId + ", acctNo=" + acctNo + ", othersAcct=" + othersAcct + ", txnDate="
				+ txnDate + ", txnType=" + txnType + ", txnAmount=" + txnAmount + ", balance=" + balance + "]";
	}

	/**
	 * @return the txnId
	 */
	public int getTxnId() {
		return txnId;
	}

	/**
	 * @param txnId the txnId to set
	 */
	public void setTxnId(int txnId) {
		this.txnId = txnId;
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
	 * @return the othersAcct
	 */
	public long getOthersAcct() {
		return othersAcct;
	}

	/**
	 * @param othersAcct the othersAcct to set
	 */
	public void setOthersAcct(long othersAcct) {
		this.othersAcct = othersAcct;
	}

	/**
	 * @return the txnDate
	 */
	public LocalDate getTxnDate() {
		return txnDate;
	}

	/**
	 * @param txnDate the txnDate to set
	 */
	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	/**
	 * @return the txnType
	 */
	public TxnType getTxnType() {
		return txnType;
	}

	/**
	 * @param txnType the txnType to set
	 */
	public void setTxnType(TxnType txnType) {
		this.txnType = txnType;
	}

	/**
	 * @return the txnAmount
	 */
	public double getTxnAmount() {
		return txnAmount;
	}

	/**
	 * @param txnAmount the txnAmount to set
	 */
	public void setTxnAmount(double txnAmount) {
		this.txnAmount = txnAmount;
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
