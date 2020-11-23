package com.example.model;

public class Product {
	int productId;
	String productName;
	String category;
	String size;
	int quantity;
	double price;
	String color;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public Product(String productName, String category, String size, int quanity,
			double price, String color) {
		this.productName = productName;
		this.category = category;
		this.size = size;
		this.quantity = quanity;
		this.price = price;
		this.color= color;
	}
	
	
}
