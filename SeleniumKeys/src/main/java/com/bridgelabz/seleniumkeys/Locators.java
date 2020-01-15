/******************************************************************************
*  
*  Purpose: To Implement Selenium Automation Script using locators
*  @class Selenium Selector using Locators
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.seleniumkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators extends Base{
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
				
		driver.findElement(By.linkText("Create a Page")).click();
		Thread.sleep(500);
		
		driver.findElement(By.partialLinkText("Up")).click();
		Thread.sleep(500);
		
		driver.findElement(By.name("firstname")).sendKeys("Arun");
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		driver.findElement(By.name("reg_email__")).sendKeys("arun.kumar235@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("arun.kumar235@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("15643354");
		Thread.sleep(500);
		
		driver.findElement(By.id("day")).sendKeys("23");
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#month")).sendKeys("July");
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//select[@id='year']")).sendKeys("1995");
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#u_0_7")).click();
		
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
