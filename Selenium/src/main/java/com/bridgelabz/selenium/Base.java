package com.bridgelabz.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

	static WebDriver driver;
	static WebElement element1;
	static WebElement element2;
	static WebElement classElement;
	static int x;
	static int y;
	static JavascriptExecutor js;
	
	static {
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/geckodriver");
	}
}
