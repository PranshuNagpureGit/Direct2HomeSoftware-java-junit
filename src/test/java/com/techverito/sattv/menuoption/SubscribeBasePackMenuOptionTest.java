package com.techverito.sattv.menuoption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuhelper.SubscribeBasePackHelper;
import com.techverito.sattv.menuoptioninput.SubscribeBasePackInput;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
class SubscribeBasePackMenuOptionTest {
	
	@Mock
	private SubscribeBasePackHelper helper;
	
	@InjectMocks
	private SubscribeBasePackMenuOption subscribeBasePackMenuOption;

	
	@Test
	void testAddChannelsMenuOption() {
		SubscribeBasePackMenuOption option = new SubscribeBasePackMenuOption();
		assertEquals(Configuration.SUBSCRIBE_BASE_PACK_MENU_TITLE,option.getTitle());
	}
	
	@Test
	void testTakeInputFromUser_success() {
		//getAccountBalanceMenuOption.takeInputFromUser();
	}
	
	@Test
	void testPerformInputValidation_success() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("s", "1");
		subscribeBasePackMenuOption.performInputValidation(subscribeBasePackInput);
	}
	@Test
	void testPerformInputValidation_failure_1() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("H", "1");
		assertThrows(CustomException.class,()->subscribeBasePackMenuOption.performInputValidation(subscribeBasePackInput),Configuration.INVALID_BASE_PACK);
	}
	@Test
	void testPerformInputValidation_failure_2() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("G", "ahg");
		assertThrows(CustomException.class,()->subscribeBasePackMenuOption.performInputValidation(subscribeBasePackInput),Configuration.INVALID_DURATION);
	}
	
	@Test
	void testPerformInputValidation_failure_3() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("G", "0");
		assertThrows(CustomException.class,()->subscribeBasePackMenuOption.performInputValidation(subscribeBasePackInput),Configuration.INVALID_DURATION);
	}
	@Test
	void testPerformInputValidation_failure_4() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("S", "13");
		assertThrows(CustomException.class,()->subscribeBasePackMenuOption.performInputValidation(subscribeBasePackInput),Configuration.INVALID_DURATION);
	}
	
	@Test
	void testPerformBusinessLogic() {
		subscribeBasePackMenuOption.performBusinessLogic(new SubscribeBasePackInput("s", "1"));
	}

	@Test
	void testPrintOutput() {
		//subscribeBasePackMenuOption.printOutput(balanceOutput);

	}
	
	@AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(System.in);
        System.setOut(System.out);
    }


	

}
