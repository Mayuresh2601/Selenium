/******************************************************************************
*  
*  Purpose: To Implement Selenium Automation Script using XPath
*  @class Selenium script using XPath
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.seleniumkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("8109555221");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("3434542121");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='u_0_b']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("test@123");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
