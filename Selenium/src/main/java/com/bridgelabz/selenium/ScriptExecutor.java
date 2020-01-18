package com.bridgelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScriptExecutor extends Base{
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.get("file:///home/admin1/eclipse-workspace/Mayuresh/Selenium/Selenium/Webpages/Disabled_TextBox.html");
		
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('t1').value='admin'");
		Thread.sleep(500);
		js.executeScript("document.getElementById('t2').value=''");
		Thread.sleep(1000);
		js.executeScript("document.getElementById('t2').value='manager'");
		Thread.sleep(1000);
		js.executeScript("document.getElementById('t2').type='button'");
		
		Thread.sleep(3000);
		driver.close();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
			
		element1 = driver.findElement(By.xpath("//div[contains(@class,'nav-logo')]"));
		int xcoordinates = element1.getLocation().getX();
		int ycoordinates = element1.getLocation().getY();
		System.out.println("Co-0rdinates of the Amazon Footer Image is: ("+xcoordinates+", "+ycoordinates+")");
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+xcoordinates+","+ycoordinates+")");
		Thread.sleep(2000);
		element1.click();
		
		Thread.sleep(3000);
		driver.close();
	}

}
