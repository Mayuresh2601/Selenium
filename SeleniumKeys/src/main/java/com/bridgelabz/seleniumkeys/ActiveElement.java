package com.bridgelabz.seleniumkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveElement extends Base{
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		try {
			
			driver.switchTo().activeElement().sendKeys("Admin");
			Thread.sleep(2000);
			
			driver.findElement(By.id("email")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
			Thread.sleep(2000);
			
			WebElement emailId = driver.findElement(By.id("email"));
			String nameValue = emailId.getAttribute("class");
			System.out.println("Name Attribute of EmailId is: "+nameValue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.close();
		
	}

}
