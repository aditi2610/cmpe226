package com.example.model;

public class Order {
	
	Integer orderId;
	Integer userId;
	Integer totalItems;
	double totalPrice;
	String orderStatus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(Integer totalItems) {
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
	
	
	Order( int orderId, double totalPrice, String orderStatus ){
		this.orderId = orderId;
		this.totalPrice  = totalPrice;
		this.orderStatus = orderStatus;
	}
	
	public Order(Integer orderId, Integer userId, Integer totalItems, double totalPrice, String orderStatus) {
		this.orderId = orderId;
		this.userId = userId;
		this.totalItems = totalItems;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;		
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return this.orderId+ " "+ this.userId+ " "+ this.orderStatus+ " "+ this.totalPrice;
	}
	
}
