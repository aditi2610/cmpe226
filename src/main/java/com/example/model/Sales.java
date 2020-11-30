package com.example.model;

public class Sales {
	private int items;
	private double amount;
	
	public Sales() {
		super();
	}

	public Sales(int items, double amount) {
		super();
		this.items = items;
		this.amount = amount;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
