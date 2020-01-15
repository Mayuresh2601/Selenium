package com.bridgelabz.seleniumkeys;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath extends Base{
	
	public static void main(String[] args) throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");

		driver.findElement(By.xpath("//input[contains(@class,'inputtext')]")).sendKeys("8109555221");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tr/following-sibling::tr//input[@type='password']")).sendKeys("test@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@value,'Log In')]")).click();
		Thread.sleep(1000);
		
		driver.close();
	}
}
