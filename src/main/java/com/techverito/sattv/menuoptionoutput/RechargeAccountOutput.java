package com.techverito.sattv.menuoptionoutput;

public class RechargeAccountOutput implements IMenuOptionOutput {
	
	private double currentBalance;
	
	public RechargeAccountOutput(double accountBalance) {
		this.setCurrentBalance(accountBalance);
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

}
