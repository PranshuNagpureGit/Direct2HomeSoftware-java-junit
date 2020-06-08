package com.techverito.sattv.menuoption;

import com.techverito.sattv.menuhelper.ViewSubscriptionHelper;
import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.menuoptionoutput.ViewSubscriptionOutput;
import com.techverito.sattv.utils.ApplicationUtil;
import com.techverito.sattv.utils.Configuration;

public class ViewSubscriptionMenuOption extends AbstractMenuOption {

	ViewSubscriptionHelper viewSubscriptionHelper;
	
	public ViewSubscriptionMenuOption() {
		viewSubscriptionHelper=new ViewSubscriptionHelper();
		setTitle(Configuration.VIEW_SUBSCRIPTION_MENU_TITLE);
	}
	@Override
	protected IMenuOptionInput takeInputFromUser() {
		return null;
	}
	@Override
	protected ViewSubscriptionOutput performBusinessLogic(IMenuOptionInput input) {
		return viewSubscriptionHelper.fetchCurrentSubscription();
		
	}
	@Override
	protected void printOutput(IMenuOptionOutput output) {
		System.out.println(getTitle());
		ViewSubscriptionOutput viewSubscriptionOutput=(ViewSubscriptionOutput)output;
		StringBuilder strBld = new StringBuilder();
		strBld.append("Currently subscribed packs and channels : ");
		if(viewSubscriptionOutput.getSubscription() != null && viewSubscriptionOutput.getSubscription().getBasePack() != null) {
			
			strBld.append(viewSubscriptionOutput.getSubscription().getBasePack().getName());
			if(!viewSubscriptionOutput.getSubscription().getAdditionalChannelList().isEmpty()) {
				viewSubscriptionOutput.getSubscription().getAdditionalChannelList().stream().forEach((channel) -> {
					strBld.append("+");
					strBld.append(channel.getName());
				});
			}
			strBld.append("\n");
			strBld.append("Currently subscribed services : ");
			if(!viewSubscriptionOutput.getSubscription().getAdditionalServiceList().isEmpty()) {
				viewSubscriptionOutput.getSubscription().getAdditionalServiceList().stream().forEach((channel) -> {
					strBld.append(channel.getName() + " ");
				});
			}else {
				strBld.append("None");
			}
		}else {
			strBld.append("No base packs subscibed");
		}
		strBld.append("\n");
		ApplicationUtil.printMessage(strBld.toString());
		
	}
	@Override
	protected void performInputValidation(IMenuOptionInput input) {
		// TODO Auto-generated method stub
		
	}

}
