package com.techverito.sattv.menuoptioninput;

public class AddServiceMenuInput implements IMenuOptionInput {
	private String serviceName;

	public AddServiceMenuInput(String serviceName) {
		super();
		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return serviceName;
	}

}
