package com.techverito.sattv.console;

import java.util.LinkedHashMap;

import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.main.Application;
import com.techverito.sattv.menuoption.AbstractMenuOption;
import com.techverito.sattv.utils.ApplicationUtil;
import com.techverito.sattv.utils.Configuration;

public abstract class AbstractConsole {

	LinkedHashMap<Integer, AbstractMenuOption> menuOptionMapping;

	public AbstractConsole() {
		menuOptionMapping = new LinkedHashMap<Integer, AbstractMenuOption>();
		initialize();
	}

	protected abstract void initialize();

	public void show() {
		while (true) {
			try {
				System.out.println(Configuration.CONSOLE_HEADER);
				ApplicationUtil.printEmptyLines(1);
				menuOptionMapping.forEach((k, v) -> {
					System.out.println(k + ". " + v.getTitle());
				});
				System.out.println(Configuration.EXIT_OPTION + ". " + "Exit");
				ApplicationUtil.printEmptyLines(1);
				ApplicationUtil.printMessage(Configuration.SELECT_OPTION);
				int optionEntered = 0;
				AbstractMenuOption menuOption = null;
				String option = Application.inputScanner.next();
				try {
					optionEntered = Integer.parseInt(option);
				}catch(Exception e) {
					throw new CustomException(Configuration.INVALID_OPTION);
				}
				if(optionEntered==Configuration.EXIT_OPTION) {
					System.out.println("Exiting application");
					break;
				}
				if (!menuOptionMapping.containsKey(optionEntered)) {
					throw new CustomException(Configuration.INVALID_OPTION);
				}
				menuOption = menuOptionMapping.get(optionEntered);
				menuOption.execute();
			} catch (CustomException e) {
				ApplicationUtil.printMessage(e.getMessage());
			} catch (Exception e) {
				ApplicationUtil.printMessage(Configuration.UNEXPECTED_ERROR);
			}

		}
	}
}
