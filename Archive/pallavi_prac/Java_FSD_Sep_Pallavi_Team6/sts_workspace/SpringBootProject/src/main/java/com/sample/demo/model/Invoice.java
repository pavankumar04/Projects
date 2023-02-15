package com.sample.demo.model;

import java.time.LocalDate;

public class Invoice {
	private int invId;
	private LocalDate invDate;
	private int qty;
	private int userId;
	private int productId;
	private double amount;
	
	public int getInvId() {
		return invId;
	}
	
	public LocalDate getInvDate() {
		return invDate;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setInvId(int invId) {
		this.invId = invId;
	}
	
	public void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Invoice() {
		
	}

	public Invoice(int invId, LocalDate invDate, int qty, int userId, int productId, double amount) {
		this.invId = invId;
		this.invDate = invDate;
		this.qty = qty;
		this.userId = userId;
		this.productId = productId;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Invoice [invId=" + invId + ", invDate=" + invDate + ", qty=" + qty + ", userId=" + userId
				+ ", productId=" + productId + ", amount=" + amount + "]";
	}
}
