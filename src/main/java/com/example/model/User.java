package com.example.model;

public class User {
	private int id;
	private String name;
	private int isAdmin;
	private String email;
	private int totalOrders;
	private String coupon;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User(String name, int isAdmin, String address, String email, int totalOrders, String coupon) {
		super();
		this.id = id;
		this.name = name;
		this.isAdmin = isAdmin;
		this.address = address;
		this.email = email;
		this.totalOrders = totalOrders;
		this.coupon = coupon;
	}

	public User(int id, String name, int isAdmin, String address, String email, int totalOrders, String coupon) {
		super();
		this.id = id;
		this.name = name;
		this.isAdmin = isAdmin;
		this.address = address;
		this.email = email;
		this.totalOrders = totalOrders;
		this.coupon = coupon;
	}
}
