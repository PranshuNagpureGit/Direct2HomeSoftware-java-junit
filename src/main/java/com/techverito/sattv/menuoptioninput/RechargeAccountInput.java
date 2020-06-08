package com.techverito.sattv.menuoptioninput;

public class RechargeAccountInput implements IMenuOptionInput {
	
	private String rechargeAmount;

	public RechargeAccountInput(String amount){
		this.rechargeAmount=amount;
	}
	public String getRechargeAmount() {
		return rechargeAmount;
	}

}
