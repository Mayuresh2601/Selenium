package com.bridgelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingAction extends Base{

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com");
		
		driver.findElement(By.linkText("Download")).click();
	
		element1 = driver.findElement(By.xpath("//input[@value='Download']"));
		x = element1.getLocation().getX();
		y = element1.getLocation().getY();
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.click(element1).perform();
		
		element2 = driver.findElement(By.linkText("Demos"));
		x = element2.getLocation().getX();
		y = element2.getLocation().getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
		Thread.sleep(500);
		action.click(element2).perform();
		
		driver.findElement(By.linkText("Droppable")).click();
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		element1 = driver.findElement(By.xpath("//div[contains(@class,'draggable')]"));
		element2 = driver.findElement(By.xpath("//div[contains(@class,'droppable')]"));
		action.dragAndDrop(element1, element2).perform();
		
		Thread.sleep(3000);
		driver.close();
	}
}
