package com.techverito.sattv.menuoption;

import com.techverito.sattv.discount.DefaultDiscountStrategy;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.main.Application;
import com.techverito.sattv.menuhelper.SubscribeBasePackHelper;
import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptioninput.SubscribeBasePackInput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.utils.Configuration;

public class SubscribeBasePackMenuOption extends AbstractMenuOption {

	SubscribeBasePackHelper helper;

	public SubscribeBasePackMenuOption() {
		helper = new SubscribeBasePackHelper(new DefaultDiscountStrategy());
		setTitle(Configuration.SUBSCRIBE_BASE_PACK_MENU_TITLE);
	}

	@Override
	protected IMenuOptionInput takeInputFromUser() {
		System.out.println("Enter the Pack you wish to subscribe: (Silver: ‘S’, Gold: ‘G’): ");
		String duration;
		String packChoice = Application.inputScanner.next();
		System.out.println("Enter the months: ");
		duration = Application.inputScanner.next();
		return new SubscribeBasePackInput(packChoice, duration);
	}


	@Override
	protected void performInputValidation(IMenuOptionInput input) {
		SubscribeBasePackInput subscribeBasePackInput = (SubscribeBasePackInput)input;
		if(!subscribeBasePackInput.getSelectedBasePack().equalsIgnoreCase("s") && !subscribeBasePackInput.getSelectedBasePack().equalsIgnoreCase("g")) {
			throw new CustomException(Configuration.INVALID_BASE_PACK);
		}
		int duration=0;
		try {
			duration=Integer.parseInt(subscribeBasePackInput.getDurationInMonths());
		}catch (Exception e) {
			throw new CustomException(Configuration.INVALID_DURATION);
		}
		if(duration<=Configuration.SUB_DURATION_MIN_LIMIT || duration>=Configuration.SUB_DURATION_MAX_LIMIT) {
			throw new CustomException(Configuration.INVALID_DURATION);
		}
		
	}
	@Override
	protected IMenuOptionOutput performBusinessLogic(IMenuOptionInput input) {
		SubscribeBasePackInput subscriberBasePackInput = (SubscribeBasePackInput) input;
		return helper.subscribeBasePack(subscriberBasePackInput);
	}

	@Override
	protected void printOutput(IMenuOptionOutput output) {
		System.out.println(output.toString());

	}


}
