package com.techverito.sattv.menuoptionoutput;

public class AddServiceOutput implements IMenuOptionOutput {
	private double accountBalance;

	public AddServiceOutput(double accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	

}
