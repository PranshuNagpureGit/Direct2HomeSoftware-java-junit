package com.techverito.sattv.menuoption;

import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.main.Application;
import com.techverito.sattv.menuhelper.RechargeAccountHelper;
import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptioninput.RechargeAccountInput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.menuoptionoutput.RechargeAccountOutput;
import com.techverito.sattv.utils.Configuration;

public class RechargeAccountMenuOption extends AbstractMenuOption {

	RechargeAccountHelper rechargeAccountHelper;
	

	public RechargeAccountMenuOption() {
		setTitle(Configuration.RECHARGE_MENU_TITLE);
		this.rechargeAccountHelper = new RechargeAccountHelper();
	}

	@Override
	protected RechargeAccountInput takeInputFromUser() {
		String amount="";
		System.out.println("Enter the amount to recharge");
		try {
			amount  = Application.inputScanner.next();
			//amount = Double.parseDouble(amountInString);
		} catch (Exception e) {
			throw new CustomException(Configuration.INVALID_AMOUNT);
		}
		return new RechargeAccountInput(amount);
	}
	
	@Override
	protected void performInputValidation(IMenuOptionInput input) {
		RechargeAccountInput rechargeInput = (RechargeAccountInput)input;
		double amount=0;
		try {
			amount=Double.parseDouble(rechargeInput.getRechargeAmount());
		}catch (Exception e) {
			throw new CustomException(Configuration.INVALID_AMOUNT);
		}
		if(amount<=Configuration.RECHARGE_AMT_MIN_LIMIT || amount>=Configuration.RECHARGE_AMT_MAX_LIMIT) {
			throw new CustomException(Configuration.INVALID_AMOUNT);
		}
	}

	@Override
	protected RechargeAccountOutput performBusinessLogic(IMenuOptionInput input) {
		return rechargeAccountHelper.performRecharge((RechargeAccountInput) input);
	}

	@Override
	protected void printOutput(IMenuOptionOutput output) {
		RechargeAccountOutput balanceOutput = (RechargeAccountOutput) output;
		System.out.println("Recharge done successfully. " + "Current Balance is " + balanceOutput.getCurrentBalance());
	}

}
