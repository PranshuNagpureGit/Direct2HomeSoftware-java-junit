package com.techverito.sattv.domain;

public class AuthenticationInput {
	
	private long customerId;
	private String password;
	
	public AuthenticationInput(long customerId, String password) {
		this.customerId = customerId;
		this.password = password;
	}
	public long getCustomerId() {
		return customerId;
	}
	public String getPassword() {
		return password;
	}
}
