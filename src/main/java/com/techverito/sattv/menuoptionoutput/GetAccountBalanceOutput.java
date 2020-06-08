package com.techverito.sattv.menuoptionoutput;

public class GetAccountBalanceOutput implements IMenuOptionOutput {
	
	private double balance;

	public GetAccountBalanceOutput(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}


}
