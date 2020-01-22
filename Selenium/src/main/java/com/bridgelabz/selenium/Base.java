package com.bridgelabz.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

	protected static WebDriver driver;
	protected static WebElement element1;
	protected static int x;
	protected static int y;
	protected static JavascriptExecutor js;
	static WebElement element2;
	static WebElement classElement;
	
	static {
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/geckodriver");
	}
}
