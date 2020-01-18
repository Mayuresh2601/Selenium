package com.bridgelabz.seleniumkeys;

import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

	static WebDriver driver;
	static Robot robo;
	static WebElement element;
	static WebElement emailId;
	static WebElement password;
	static WebElement login;
	static JavascriptExecutor script;
	static boolean validateBoolean;
	static String validateString;
	
	static {
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/geckodriver");
	}
}
