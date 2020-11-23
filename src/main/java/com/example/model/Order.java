package com.example.model;

public class Order {
	
	int orderId;
	int userId;
	int totalItems;
	double totalPrice;
	String orderStatus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	public Order(int orderId, int userId, int totalItems, double totalPrice, String orderStatus) {
		this.orderId = orderId;
		this.userId = userId;
		this.totalItems = totalItems;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;		
	}
	
}
