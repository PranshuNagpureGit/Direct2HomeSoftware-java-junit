package com.techverito.sattv.domain;

public class Customer {
	
	private long customerId;
	private String password;
	private double accountBalance;
	private Subscription subscription;
	private String emailId;
	private String phoneNumber;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Customer(long customerId,String password) {
		this.customerId=customerId;
		this.password=password;
		accountBalance=100;
	}
	public long getCustomerId() {
		return customerId;
	}
	public String getPassword() {
		return password;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double d) {
		this.accountBalance = d;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	
}
