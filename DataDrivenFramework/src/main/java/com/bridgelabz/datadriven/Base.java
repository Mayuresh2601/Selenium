package com.bridgelabz.datadriven;

import org.openqa.selenium.WebDriver;

import com.bridgelabz.datadriven.utility.Utility;

public class Base {

	static WebDriver driver;
	protected static Utility utility;
	
	static {
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/geckodriver");
	}
}
