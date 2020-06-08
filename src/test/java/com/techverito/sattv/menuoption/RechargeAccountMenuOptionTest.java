package com.techverito.sattv.menuoption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuhelper.RechargeAccountHelper;
import com.techverito.sattv.menuoptioninput.RechargeAccountInput;
import com.techverito.sattv.menuoptionoutput.RechargeAccountOutput;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
class RechargeAccountMenuOptionTest {
	
	@Mock
	private RechargeAccountHelper helper;
	
	@InjectMocks
	private RechargeAccountMenuOption rechargeAccountMenuOption;

	
	@Test
	void testAddChannelsMenuOption() {
		RechargeAccountMenuOption option = new RechargeAccountMenuOption();
		assertEquals(Configuration.RECHARGE_MENU_TITLE,option.getTitle());
	}
	
	@Test
	void testTakeInputFromUser_success() {
		//getAccountBalanceMenuOption.takeInputFromUser();
	}
	
	@Test
	void testPerformInputValidation_success() {
		RechargeAccountInput rechargeInput = new RechargeAccountInput("100");
		rechargeAccountMenuOption.performInputValidation(rechargeInput);
		
	}
	@Test
	void testPerformInputValidation_failure_1() {
		RechargeAccountInput rechargeInput = new RechargeAccountInput("adad");
		assertThrows(CustomException.class,()->rechargeAccountMenuOption.performInputValidation(rechargeInput),Configuration.INVALID_AMOUNT);
	}
	@Test
	void testPerformInputValidation_failure_2() {
		RechargeAccountInput rechargeInput = new RechargeAccountInput("0");
		assertThrows(CustomException.class,()->rechargeAccountMenuOption.performInputValidation(rechargeInput),Configuration.INVALID_AMOUNT);
	}
	
	@Test
	void testPerformInputValidation_failure_3() {
		RechargeAccountInput rechargeInput = new RechargeAccountInput("99999999999999");
		assertThrows(CustomException.class,()->rechargeAccountMenuOption.performInputValidation(rechargeInput),Configuration.INVALID_AMOUNT);
	}
	
	@Test
	void testPerformBusinessLogic() {
		rechargeAccountMenuOption.performBusinessLogic(null);
	}

	@Test
	void testPrintOutput() {
		RechargeAccountOutput balanceOutput = new RechargeAccountOutput(10);
		ByteArrayOutputStream testOut =  new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		StringBuilder expectedOutputBuilder=new StringBuilder();
		expectedOutputBuilder.append("Recharge done successfully");
		rechargeAccountMenuOption.printOutput(balanceOutput);
		assertTrue(testOut.toString().contains(expectedOutputBuilder.toString()));

	}
	
	@AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(System.in);
        System.setOut(System.out);
    }


	

}
