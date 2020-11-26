package com.example.model;

public class Coupon {

	String couponId;
	double value;
	
	int minOrders;

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
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
	
}
