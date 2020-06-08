package com.techverito.sattv.menuoptionoutput;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.techverito.sattv.domain.AdditionalService;
import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.Channel;

class ViewAllPacksAndServicesOutputTest {

	@Test
	void testViewAllPacksAndServicesOutput_constructor() {
		List<BasePack> basePackList = new ArrayList<BasePack>();
		List<Channel> channelList = new ArrayList<Channel>();
		List<AdditionalService> additionalServices = new ArrayList<AdditionalService>();
		ViewAllPacksAndServicesOutput viewSubscriptionOutput = new ViewAllPacksAndServicesOutput(basePackList,channelList,additionalServices);
		Assertions.assertNotNull(viewSubscriptionOutput.getBasePackList());
		Assertions.assertNotNull(viewSubscriptionOutput.getChannelList());
		Assertions.assertNotNull(viewSubscriptionOutput.getAdditionalServices());
	}

}
