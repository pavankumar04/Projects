package com.sample.demo.model;

public class Products {
	private int productId;
	private String productName;
	private String description;
	private String brand;
	private double price;
	
	public int getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Products() {
		
	}

	public Products(int productId, String productName, String description, String brand, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", brand=" + brand + ", price=" + price + "]";
	}
}
