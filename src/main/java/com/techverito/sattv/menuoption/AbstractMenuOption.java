package com.techverito.sattv.menuoption;

import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;

public abstract class AbstractMenuOption {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public final void execute() {
		IMenuOptionInput input = takeInputFromUser();
		performInputValidation(input);
		IMenuOptionOutput output = performBusinessLogic(input);
		printOutput(output);
	}
	
	protected abstract IMenuOptionInput takeInputFromUser();
	protected abstract void performInputValidation(IMenuOptionInput input);
	protected abstract IMenuOptionOutput performBusinessLogic(IMenuOptionInput input);
	protected abstract void printOutput(IMenuOptionOutput output);
	
}
