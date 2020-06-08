package com.techverito.sattv.menuoptionoutput;

import java.util.ArrayList;
import java.util.List;

import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.Customer;

public class SubscribeBasePackOutput implements IMenuOptionOutput {
	
	private String basePackName;
	private double monthlyPrice;
	private int duration;
	private double subscriptionAmount;
	private double discountApplied;
	private double finalPriceAfterDiscount;
	private double accountBalance;
	private List<String> notifications;
	
	
	public String getBasePackName() {
		return basePackName;
	}
	public double getMonthlyPrice() {
		return monthlyPrice;
	}
	public int getDuration() {
		return duration;
	}
	public double getSubscriptionAmount() {
		return subscriptionAmount;
	}
	public double getDiscountApplied() {
		return discountApplied;
	}
	public double getFinalPriceAfterDiscount() {
		return finalPriceAfterDiscount;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public List<String> getNotifications() {
		return notifications;
	}
	private void setBasePackName(String basePackName) {
		this.basePackName = basePackName;
	}
	private void setMonthlyPrice(double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}
	private void setDuration(int duration) {
		this.duration = duration;
	}
	private void setSubscriptionAmount(double subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}
	private void setDiscountApplied(double discountApplied) {
		this.discountApplied = discountApplied;
	}
	private void setFinalPriceAfterDiscount(double finalPriceAfterDiscount) {
		this.finalPriceAfterDiscount = finalPriceAfterDiscount;
	}
	private void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	private void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}
	
	public String toString() {
		StringBuilder strBldr = new StringBuilder();
		strBldr.append("You have successfully subscribed to the following packs - " + basePackName);
		strBldr.append("\n");
		strBldr.append("Monthly Price : " + monthlyPrice);
		strBldr.append("\n");
		strBldr.append("Number Of Months : " + duration);
		strBldr.append("\n");
		strBldr.append("Subscription Amount : " + subscriptionAmount);
		strBldr.append("\n");
		strBldr.append("Discount Applied : " + discountApplied);
		strBldr.append("\n");
		strBldr.append("Final Price After discount : " + finalPriceAfterDiscount);
		strBldr.append("\n");
		strBldr.append("Account Balance : " + accountBalance);
		strBldr.append("\n");
		notifications.stream().forEach((notificaton)->{
			strBldr.append(notificaton + " notification sent successfully");
			strBldr.append("\n");
		});
		return strBldr.toString();
	}
	
	public static SubscribeBasePackOutputBuilder getBuilder() {
		return new SubscribeBasePackOutputBuilder();
	}
	public static class SubscribeBasePackOutputBuilder{
		private SubscribeBasePackOutput output;
		private BasePack basePack;
		private int durationInMonths;
		private double finalPrice;
		private double discountApplied;
		private double subscriptionAmount;
		private Customer customer;
		
		public SubscribeBasePackOutputBuilder withBasePack(BasePack basePack) {
			this.basePack = basePack;
			return this;
		}
		
		public SubscribeBasePackOutputBuilder withDuration(int duration) {
			this.durationInMonths = duration;
			return this;
		}
		public SubscribeBasePackOutputBuilder withDiscount(double discount) {
			this.discountApplied = discount;
			return this;
		}
		public SubscribeBasePackOutputBuilder withFinalPrice(double finalPrice) {
			this.finalPrice = finalPrice;
			return this;
		}
		public SubscribeBasePackOutputBuilder withSubscriptionAmount(double subAmount) {
			this.subscriptionAmount = subAmount;
			return this;
		}
		public SubscribeBasePackOutputBuilder withCustomer(Customer customer) {
			this.customer = customer;
			return this;
		}
		
		
		public SubscribeBasePackOutput build() {
			this.output = new SubscribeBasePackOutput();
			output.setAccountBalance(customer.getAccountBalance());
			output.setBasePackName(basePack.getName());
			output.setDiscountApplied(this.discountApplied);
			output.setDuration(this.durationInMonths);
			output.setFinalPriceAfterDiscount(this.finalPrice);
			output.setMonthlyPrice(basePack.getAmount());
			output.setSubscriptionAmount(this.subscriptionAmount);
			List<String> notifications = new ArrayList<String>();
			if(customer.getEmailId()!=null && !customer.getEmailId().isEmpty()) {
				notifications.add("Email");
			}
			if(customer.getPhoneNumber()!=null && !customer.getPhoneNumber().isEmpty()) {
				notifications.add("SMS");
			}
			output.setNotifications(notifications);
			return this.output;
		}
		
		
		
	}
	
	

}
