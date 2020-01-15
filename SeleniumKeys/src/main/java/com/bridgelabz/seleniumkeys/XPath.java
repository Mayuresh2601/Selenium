package com.bridgelabz.seleniumkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath extends Base{
	
	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.xpath("//input[contains(text(),'email')]")).sendKeys("8109555221");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(text(),'pass')]")).sendKeys("test@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@value,'Log In')]")).click();
		Thread.sleep(1000);
		
		driver.close();
	}
}
