package com.techverito.sattv.menuoptioninput;

public class AddChannelMenuInput implements IMenuOptionInput {
	private String commaSeparatedChannels;

	public AddChannelMenuInput(String commaSeparatedChannels) {
		this.commaSeparatedChannels = commaSeparatedChannels;
	}

	public String getCommaSeparatedChannels() {
		return commaSeparatedChannels;
	}

}
