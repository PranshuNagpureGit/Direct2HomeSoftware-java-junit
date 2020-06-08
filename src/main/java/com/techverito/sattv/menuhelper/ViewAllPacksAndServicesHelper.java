package com.techverito.sattv.menuhelper;

import com.techverito.sattv.database.DatabaseInstance;
import com.techverito.sattv.menuoptionoutput.ViewAllPacksAndServicesOutput;

public class ViewAllPacksAndServicesHelper {

	public ViewAllPacksAndServicesOutput fetchAllAllPacksAndServices() {
		ViewAllPacksAndServicesOutput output = new ViewAllPacksAndServicesOutput(DatabaseInstance.getInstance().getBasePackList(),
				DatabaseInstance.getInstance().getChannelList(),DatabaseInstance.getInstance().getAdditionalServices());
		return output;
		
	}

}
