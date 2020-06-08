package com.techverito.sattv.domain;

public class Channel {
	private String name;
	private double amount;
	
	
	public Channel(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	public String getName() {
		return name;
	}

}
