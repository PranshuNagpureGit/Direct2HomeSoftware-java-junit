package com.techverito.sattv.menuoptionoutput;

public class AddChannelOutput implements IMenuOptionOutput{
	private double accountBalance;

	public double getAccountBalance() {
		return accountBalance;
	}

	public AddChannelOutput(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
