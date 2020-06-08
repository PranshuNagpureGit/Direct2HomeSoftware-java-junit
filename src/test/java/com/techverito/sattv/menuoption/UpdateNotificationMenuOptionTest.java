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
import com.techverito.sattv.menuhelper.UpdateNotificationHelper;
import com.techverito.sattv.menuoptioninput.UpdateNotificationInput;
import com.techverito.sattv.menuoptionoutput.UpdateNotificationOutput;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
class UpdateNotificationMenuOptionTest {
	
	@Mock
	private UpdateNotificationHelper helper;
	
	@InjectMocks
	private UpdateNotificationMenuOption updateNotificationMenuOption;

	
	@Test
	void testUpdateNotificationMenuOption() {
		UpdateNotificationMenuOption option = new UpdateNotificationMenuOption();
		assertEquals(Configuration.UPDATE_NOTIFICATION_MENU_TITLE,option.getTitle());
	}
	
	@Test
	void testTakeInputFromUser_success() {
	}
	
	@Test
	void testPerformInputValidation_success() {
		UpdateNotificationInput updateNotificationInput = new UpdateNotificationInput("pk@gmail.com", "7397971174");
		updateNotificationMenuOption.performInputValidation(updateNotificationInput);
	}
	@Test
	void testPerformInputValidation_failure_1() {
		UpdateNotificationInput updateNotificationInput = new UpdateNotificationInput("1211", "7397971174");
		assertThrows(CustomException.class,()->updateNotificationMenuOption.performInputValidation(updateNotificationInput),Configuration.INVALID_EMAIL);
	}
	@Test
	void testPerformInputValidation_failure_2() {
		UpdateNotificationInput updateNotificationInput = new UpdateNotificationInput("1211", "7397971174");
		assertThrows(CustomException.class,()->updateNotificationMenuOption.performInputValidation(updateNotificationInput),Configuration.INVALID_PHONE_NUMBER);
	}
	
	
	@Test
	void testPerformBusinessLogic() {
		UpdateNotificationInput updateNotificationInput = new UpdateNotificationInput("pk@gmail.com", "7397971174");
		updateNotificationMenuOption.performBusinessLogic(updateNotificationInput);
	}

	@Test
	void testPrintOutput() {
		UpdateNotificationOutput updateNotificationOutput = new UpdateNotificationOutput("pk@gmail.com", "7397971174");
		ByteArrayOutputStream testOut =  new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		StringBuilder expectedOutputBuilder=new StringBuilder();
		expectedOutputBuilder.append("Email and Phone updated successfully");
		updateNotificationMenuOption.printOutput(updateNotificationOutput);
		assertTrue(testOut.toString().contains(expectedOutputBuilder.toString()));


	}
	
	@AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(System.in);
        System.setOut(System.out);
    }


	

}
