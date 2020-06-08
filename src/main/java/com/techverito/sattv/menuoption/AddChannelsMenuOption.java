package com.techverito.sattv.menuoption;

import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.main.Application;
import com.techverito.sattv.menuhelper.AddChannelsHelper;
import com.techverito.sattv.menuoptioninput.AddChannelMenuInput;
import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptionoutput.AddChannelOutput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.utils.ApplicationUtil;
import com.techverito.sattv.utils.Configuration;

public class AddChannelsMenuOption extends AbstractMenuOption {

	private AddChannelsHelper helper;

	
	public AddChannelsMenuOption() {
		setTitle(Configuration.ADD_CHANNEL_MENU_TITLE);
		helper=new AddChannelsHelper();
	}
	@Override
	protected IMenuOptionInput takeInputFromUser() {
		String channels = "";
		try {
			 System.out.println("Enter channel names to add (separated by commas): ");
			 channels  = Application.inputScanner.next();
		}catch(Exception e) {
			throw new CustomException(Configuration.INVALID_INPUT);
		}
		return new AddChannelMenuInput(channels);
	}
	@Override
	protected void performInputValidation(IMenuOptionInput input) {
		AddChannelMenuInput addChannelMenuInput = (AddChannelMenuInput)input;
		if(addChannelMenuInput.getCommaSeparatedChannels() == null || addChannelMenuInput.getCommaSeparatedChannels().isEmpty()) {
			throw new CustomException(Configuration.EMPTY_INPUT);
		}
		String[] channelList = addChannelMenuInput.getCommaSeparatedChannels().split(",");
		if(channelList.length == 0) {
			throw new CustomException(Configuration.INVALID_INPUT);
		}	
	}

	@Override
	protected IMenuOptionOutput performBusinessLogic(IMenuOptionInput input) {
		return helper.addChannelsToSubscription((AddChannelMenuInput)input);
	}

	@Override
	protected void printOutput(IMenuOptionOutput output) {
		ApplicationUtil.printMessage("Channels added successfully.");
		AddChannelOutput addChannelOutput = (AddChannelOutput)output;
		ApplicationUtil.printMessage("Account balance:" + addChannelOutput.getAccountBalance());
	}

}
