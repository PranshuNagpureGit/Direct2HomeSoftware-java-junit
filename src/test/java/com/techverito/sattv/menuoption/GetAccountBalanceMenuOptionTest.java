package com.techverito.sattv.menuoption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.menuhelper.GetAccountBalanceHelper;
import com.techverito.sattv.menuoptionoutput.GetAccountBalanceOutput;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
class GetAccountBalanceMenuOptionTest {
	
	@Mock
	private GetAccountBalanceHelper helper;
	
	@InjectMocks
	private GetAccountBalanceMenuOption getAccountBalanceMenuOption;

	
	@Test
	void testAddChannelsMenuOption() {
		GetAccountBalanceMenuOption option = new GetAccountBalanceMenuOption();
		assertEquals(Configuration.GET_ACCOUNT_BALANCE_MENU_TITLE,option.getTitle());
	}
	
	@Test
	void testTakeInputFromUser_success() {
		getAccountBalanceMenuOption.takeInputFromUser();
	}
	
	@Test
	void testPerformInputValidation_success() {
		getAccountBalanceMenuOption.performInputValidation(null);
	}
	
	@Test
	void testPerformBusinessLogic() {
		getAccountBalanceMenuOption.performBusinessLogic(null);
	}

	@Test
	void testPrintOutput() {
		GetAccountBalanceOutput getAccountBalanceOutput = new GetAccountBalanceOutput(10);
		ByteArrayOutputStream testOut =  new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		StringBuilder expectedOutputBuilder=new StringBuilder();
		expectedOutputBuilder.append("Current Balance is");
		getAccountBalanceMenuOption.printOutput(getAccountBalanceOutput);
		assertTrue(testOut.toString().contains(expectedOutputBuilder.toString()));

	}
	
	@AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(System.in);
        System.setOut(System.out);
    }


	

}
