/******************************************************************************
*  
*  Purpose: To Implement Selenium Automation Script using locators
*  @class Selenium Selector using Locators
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.seleniumkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.name("firstname")).sendKeys("Arun");
		Thread.sleep(500);
		
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		Thread.sleep(500);
		
		driver.findElement(By.name("reg_email__")).sendKeys("arun.kumar235@gmail.com");
		Thread.sleep(500);
		
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("arun.kumar235@gmail.com");
		Thread.sleep(500);
		
		driver.findElement(By.name("reg_passwd__")).sendKeys("Nelson@123");
		Thread.sleep(500);
		
		driver.findElement(By.name("birthday_day")).sendKeys("18");
		Thread.sleep(500);
		
		driver.findElement(By.name("birthday_month")).sendKeys("September");
		Thread.sleep(500);
		
		driver.findElement(By.name("birthday_year")).sendKeys("1954");
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#u_0_7")).click();
		Thread.sleep(500);
		
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(5000);
		
		driver.close();
	}

}
