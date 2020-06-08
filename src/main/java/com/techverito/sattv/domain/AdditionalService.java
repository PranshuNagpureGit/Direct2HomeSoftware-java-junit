package com.techverito.sattv.domain;

public class AdditionalService {
	
	private String name;
	private double amount;
	public AdditionalService(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public double getAmount() {
		return amount;
	}

}
