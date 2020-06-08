package com.techverito.sattv.menuoption;

import com.techverito.sattv.menuhelper.GetAccountBalanceHelper;
import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptionoutput.GetAccountBalanceOutput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.utils.Configuration;

public class GetAccountBalanceMenuOption extends AbstractMenuOption{

	private GetAccountBalanceHelper getAccountBalanceHelper;
	
	public GetAccountBalanceMenuOption() {
		setTitle(Configuration.GET_ACCOUNT_BALANCE_MENU_TITLE);
		this.getAccountBalanceHelper=new GetAccountBalanceHelper();
	}
	
	@Override
	protected IMenuOptionInput takeInputFromUser() {
		return null;
	}
	@Override
	protected void performInputValidation(IMenuOptionInput input) {
	}
	
	@Override
	protected IMenuOptionOutput performBusinessLogic(IMenuOptionInput input) {
		return getAccountBalanceHelper.getAccountBalance();
	}

	@Override
	protected void printOutput(IMenuOptionOutput output) {
		System.out.println(getTitle());
		GetAccountBalanceOutput balanceOutput = (GetAccountBalanceOutput)output;
		System.out.println("Current Balance is " + balanceOutput.getBalance());
	}



}
