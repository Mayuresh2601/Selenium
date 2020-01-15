/******************************************************************************
*  
*  Purpose: To Implement Selenium Automation Script using Web Element
*  @class Selenium script using WebElement
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.seleniumkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementImplement extends Base{
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		emailId = driver.findElement(By.id("email"));
		emailId.sendKeys("8109555221");
		Thread.sleep(500);
		
		password = driver.findElement(By.name("pass"));
		password.sendKeys("test@123");
		Thread.sleep(500);
		
		login = driver.findElement(By.id("loginbutton"));
		login.click();
		Thread.sleep(500);
		driver.close();
		
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		
		emailId = driver.findElement(By.id("email"));
		emailId.sendKeys("8109555221");
		Thread.sleep(500);
		
		password = driver.findElement(By.name("pass"));
		password.sendKeys("test@123");
		Thread.sleep(500);
		
		login = driver.findElement(By.id("loginbutton"));
		login.click();
		Thread.sleep(500);
		driver.close();
	}
}