package com.bridgelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame extends Base{

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("file:///home/admin1/eclipse-workspace/Mayuresh/Selenium/selenium/Webpages/Page2.html");
		Thread.sleep(1000);
		
		//Using id of Frame
		driver.switchTo().frame("f1");
		element1 = driver.findElement(By.id("t1"));
		element1.sendKeys("Hello");
		Thread.sleep(500);
		
		driver.switchTo().defaultContent();
		element2 = driver.findElement(By.id("t2"));
		element2.sendKeys("World");
		Thread.sleep(1000);
		
		//Using name of Frame
		driver.switchTo().frame("n1");
		element1.clear();
		element1.sendKeys("Bye");
		Thread.sleep(500);
		
		driver.switchTo().defaultContent();
		element2.clear();
		element2.sendKeys("Bye");
		Thread.sleep(1000);
		
		//Using class of Frame
		classElement = driver.findElement(By.className("c1"));
		driver.switchTo().frame(classElement);
		element1.clear();
		element1.sendKeys("Good Morning");
		Thread.sleep(500);
		
		driver.switchTo().defaultContent();
		element2.clear();
		element2.sendKeys("Good Evening");
		Thread.sleep(2000);
		driver.close();
	}

}
