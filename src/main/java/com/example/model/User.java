package com.example.model;

import java.io.Serializable;

import org.mindrot.jbcrypt.BCrypt;

public class User implements Serializable {
	private int userId;

	private String password;
	private String phoneNumber;
	private String name;
	private int isAdmin;
	private String email;
	private int totalOrders;
	private String coupon;
	private String address;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public User() {

	}

	public User(String name, int isAdmin, String address, String phoneNumber, String email, int totalOrders, String coupon, String password) {
		super();
		this.name = name;
		this.isAdmin = isAdmin;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.totalOrders = totalOrders;
		this.coupon = coupon;
		this.password =password;
	}
	
	public User(String name, int isAdmin, String address, String phoneNumber, String email, String coupon, String password) {
		super();
		this.name = name;
		this.isAdmin = isAdmin;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.coupon = coupon;
		this.password =password;
	}
}
	
	
