package com.techverito.sattv.menuoption;

import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.main.Application;
import com.techverito.sattv.menuhelper.AddServicesHelper;
import com.techverito.sattv.menuoptioninput.AddServiceMenuInput;
import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptionoutput.AddServiceOutput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.utils.ApplicationUtil;
import com.techverito.sattv.utils.Configuration;

public class AddServicesMenuOption extends AbstractMenuOption {

	private AddServicesHelper helper;

	
	public AddServicesMenuOption() {
		setTitle(Configuration.ADD_SERVICES_MENU_TITLE);
		helper=new AddServicesHelper();
	}
	
	@Override
	protected IMenuOptionInput takeInputFromUser() {
		String serviceName = "";
		try {
			 System.out.println("Enter the service name: ");
			 serviceName  = Application.inputScanner.next();
		}catch(Exception e) {
			throw new CustomException(Configuration.INVALID_INPUT);
		}
		return new AddServiceMenuInput(serviceName);
		
	}
	
	@Override
	protected void performInputValidation(IMenuOptionInput input) {
		
	}


	@Override
	protected IMenuOptionOutput performBusinessLogic(IMenuOptionInput input) {
		return helper.addService((AddServiceMenuInput)input);
	}

	@Override
	protected void printOutput(IMenuOptionOutput output) {
		ApplicationUtil.printMessage("Service subscribed successfully.");
		AddServiceOutput addServiceOutput = (AddServiceOutput)output;
		ApplicationUtil.printMessage("Account balance:" + addServiceOutput.getAccountBalance());
		ApplicationUtil.printMessage("Email notification sent successfully");
		ApplicationUtil.printMessage("SMS notification sent successfully");
	}

}
