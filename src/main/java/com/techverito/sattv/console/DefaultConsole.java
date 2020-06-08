package com.techverito.sattv.console;

import com.techverito.sattv.menuoption.AddChannelsMenuOption;
import com.techverito.sattv.menuoption.AddServicesMenuOption;
import com.techverito.sattv.menuoption.GetAccountBalanceMenuOption;
import com.techverito.sattv.menuoption.RechargeAccountMenuOption;
import com.techverito.sattv.menuoption.SubscribeBasePackMenuOption;
import com.techverito.sattv.menuoption.UpdateNotificationMenuOption;
import com.techverito.sattv.menuoption.ViewAllPacksAndServicesMenuOption;
import com.techverito.sattv.menuoption.ViewSubscriptionMenuOption;

public class DefaultConsole extends AbstractConsole {

	@Override
	protected void initialize() {
		
		menuOptionMapping.put(1, new GetAccountBalanceMenuOption());
		menuOptionMapping.put(2, new RechargeAccountMenuOption());
		menuOptionMapping.put(3, new ViewAllPacksAndServicesMenuOption());
		menuOptionMapping.put(4, new SubscribeBasePackMenuOption());
		menuOptionMapping.put(5, new AddChannelsMenuOption());
		menuOptionMapping.put(6, new AddServicesMenuOption());
		menuOptionMapping.put(7, new ViewSubscriptionMenuOption());
		menuOptionMapping.put(8, new UpdateNotificationMenuOption());
	}
	

}
