package com.techverito.sattv.menuoption;

import com.techverito.sattv.menuhelper.ViewAllPacksAndServicesHelper;
import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.menuoptionoutput.ViewAllPacksAndServicesOutput;
import com.techverito.sattv.utils.Configuration;

public class ViewAllPacksAndServicesMenuOption extends AbstractMenuOption {

	ViewAllPacksAndServicesHelper vewAllPacksAndServicesHelper;
	
	public ViewAllPacksAndServicesMenuOption() {
		vewAllPacksAndServicesHelper=new ViewAllPacksAndServicesHelper();
		setTitle(Configuration.VIEW_ALL_PACKS_MENU_TITLE);
	}
	@Override
	protected IMenuOptionInput takeInputFromUser() {
		return null;
	}
	@Override
	protected void performInputValidation(IMenuOptionInput input) {
		return;		
	}

	@Override
	protected ViewAllPacksAndServicesOutput performBusinessLogic(IMenuOptionInput input) {
		return vewAllPacksAndServicesHelper.fetchAllAllPacksAndServices();
		
	}
	@Override
	protected void printOutput(IMenuOptionOutput output) {
		System.out.println(getTitle());
		ViewAllPacksAndServicesOutput viewAllOutput=(ViewAllPacksAndServicesOutput)output;
		
		System.out.println("Available Packs For Subscription");
		if(viewAllOutput.getBasePackList() != null && !viewAllOutput.getBasePackList().isEmpty()) {
			viewAllOutput.getBasePackList().forEach((basePack) -> {
				System.out.print(basePack.getName() + " : ");
				basePack.getChannelList().forEach((channel) -> {
					System.out.print(channel.getName() + " ");
				});
				System.out.print(basePack.getAmount() + ".Rs");
				System.out.println("");
			});
		}else {
			System.out.println("No base packs available");
		}
		System.out.println("");
		System.out.println("Available Channels For Subscription");
		if(viewAllOutput.getChannelList() != null && !viewAllOutput.getChannelList().isEmpty()) {
			viewAllOutput.getChannelList().forEach((channel) -> {
					System.out.println(channel.getName() + ":" + channel.getAmount() + ".Rs");
				});
		}else {
			System.out.println("No channels available");
		}
		System.out.println("");
		System.out.println("Available Services For Subscription");
		if(viewAllOutput.getAdditionalServices() != null && !viewAllOutput.getAdditionalServices().isEmpty()) {
			viewAllOutput.getAdditionalServices().forEach((service) -> {
					System.out.println(service.getName() + ":" + service.getAmount() + ".Rs");
				});
		}else {
			System.out.println("No Services available");
		}
		System.out.println("");
	}

}
