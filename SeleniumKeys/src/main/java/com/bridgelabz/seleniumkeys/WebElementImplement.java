/******************************************************************************
*  
*  Purpose: To Implement Selenium Automation Script using Web Element
*  @class Selenium script using WebElement
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.seleniumkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementImplement {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.facebook.com");
		WebElement emailId = driver.findElement(By.id("email"));
		emailId.sendKeys("8109555221");
		Thread.sleep(500);
		
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("test@123");
		Thread.sleep(500);
		
		WebElement login = driver.findElement(By.id("loginbutton"));
		login.click();
		Thread.sleep(500);
		
		driver.close();
	}

}