package com.bridgelabz.seleniumdemo;

import org.openqa.selenium.WebDriver;

public class Base {

	static {
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
	}
	static WebDriver driver;
}
