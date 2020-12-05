package com.example.model;
public class Coupon {

	int couponId;
	double value;
	int adminId; 
	int minOrders;
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getMinOrders() {
		return minOrders;
	}

	public void setMinOrders(int minOrders) {
		this.minOrders = minOrders;
	}
	
	public Coupon( double price, int minOrder, int adminId){
		this.value = price;
		this.minOrders = minOrder;
		this.adminId = adminId;
		
	}
	
	public Coupon( double price, int minOrder){
		this.value = price;
		this.minOrders = minOrder;
	}
	
	public Coupon( int couponId, double price, int minOrder, int adminId){
		this.couponId = couponId;
		this.value = price;
		this.minOrders = minOrder;
		this.adminId = adminId;
		
	}

	public Coupon() {

	}
	
}
