package com.techverito.sattv.menuoption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.menuhelper.AddServicesHelper;
import com.techverito.sattv.menuoptioninput.AddServiceMenuInput;
import com.techverito.sattv.menuoptionoutput.AddServiceOutput;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
class AddServicesMenuOptionTest {
	
	@Mock
	private AddServicesHelper helper;
	
	@InjectMocks
	private AddServicesMenuOption addServicesMenuOption;

	
	@BeforeEach
    public void restoreSystemInputOutputBefore() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
	@Test
	void testAddServicesMenuOption() {
		AddServicesMenuOption option = new AddServicesMenuOption();
		assertEquals(Configuration.ADD_SERVICES_MENU_TITLE,option.getTitle());
	}
	
	@Test
	void testTakeInputFromUser_success() {
		String data="LearnCooking";
		ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
		//addServicesMenuOption.takeInputFromUser();
		//assertEquals(data, ((AddServiceMenuInput)addServicesMenuOption.takeInputFromUser()).getServiceName());
	}
	
	@Test
	void testPerformInputValidation_success() {
		addServicesMenuOption.performInputValidation(null);
	}
	
	@Test
	void testPerformBusinessLogic() {
		String data="";
		AddServiceMenuInput input = new AddServiceMenuInput(data);
		addServicesMenuOption.performBusinessLogic(input);
	}

	@Test
	void testPrintOutput() {
		AddServiceOutput addServicesOutput = new AddServiceOutput(10);
		ByteArrayOutputStream testOut =  new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		StringBuilder expectedOutputBuilder=new StringBuilder();
		expectedOutputBuilder.append("Service subscribed successfully.");
		addServicesMenuOption.printOutput(addServicesOutput);
		assertTrue(testOut.toString().contains(expectedOutputBuilder.toString()));

	}
	
	@AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(System.in);
        System.setOut(System.out);
    }


	

}
