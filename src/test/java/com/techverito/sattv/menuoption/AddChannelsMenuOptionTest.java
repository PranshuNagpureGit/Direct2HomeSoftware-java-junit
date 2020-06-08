package com.techverito.sattv.menuoption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuhelper.AddChannelsHelper;
import com.techverito.sattv.menuoptioninput.AddChannelMenuInput;
import com.techverito.sattv.menuoptionoutput.AddChannelOutput;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
class AddChannelsMenuOptionTest {
	
	@Mock
	private AddChannelsHelper helper;
	
	@InjectMocks
	private AddChannelsMenuOption addChannelsMenuOption;

	
	@Test
	void testAddChannelsMenuOption() {
		AddChannelsMenuOption option = new AddChannelsMenuOption();
		assertEquals(Configuration.ADD_CHANNEL_MENU_TITLE,option.getTitle());
	}
	
	@Test
	void testTakeInputFromUser_success() {
		String data="zee,sony";
		ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
		assertEquals(data, ((AddChannelMenuInput)addChannelsMenuOption.takeInputFromUser()).getCommaSeparatedChannels());
	}
	
	@Test
	void testPerformInputValidation_success() {
		String data="zee,sony";
		AddChannelMenuInput input = new AddChannelMenuInput(data);
		addChannelsMenuOption.performInputValidation(input);
	}

	@Test
	void testPerformInputValidation_empty() {
		String data="";
		AddChannelMenuInput input = new AddChannelMenuInput(data);
		assertThrows(CustomException.class,()->addChannelsMenuOption.performInputValidation(input),Configuration.EMPTY_INPUT);
	}
	
	@Test
	void testPerformBusinessLogic() {
		String data="";
		AddChannelMenuInput input = new AddChannelMenuInput(data);
		//Mockito.doNothing().when(helper).addChannelsToSubscription(Mockito.any());
		addChannelsMenuOption.performBusinessLogic(input);
	}

	@Test
	void testPrintOutput() {
		AddChannelOutput addChannelOutput = new AddChannelOutput(10);
		ByteArrayOutputStream testOut =  new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		StringBuilder expectedOutputBuilder=new StringBuilder();
		expectedOutputBuilder.append("Channels added successfully.");
		addChannelsMenuOption.printOutput(addChannelOutput);
		assertTrue(testOut.toString().contains(expectedOutputBuilder.toString()));

	}
	
	@AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(System.in);
        System.setOut(System.out);
    }


	

}
