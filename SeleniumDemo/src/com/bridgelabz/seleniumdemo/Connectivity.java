/******************************************************************************
*  
*  Purpose: To Implement Selenium Demo Project
*  @class Selenium Web Driver
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Connectivity {
	
	static {
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
	}
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		//Get Webpage Title
		String title = driver.getTitle();
		System.out.println("Title of Webpage is: "+title);
		
		//Get Webpage Url
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Url of Webpage is: "+pageUrl);
		
		//Get Webpage Source code
		String pageSourceCode = driver.getPageSource();
		System.out.println("Source code of Webpage is: "+pageSourceCode);
		
		// Navigate to Gmail webpage
		driver.navigate().to("https://www.gmail.com");
		Thread.sleep(1000);
		
		//Navigate Back to Google webpage
		driver.navigate().back();
		Thread.sleep(1000);
		
		//Navigate to Gmail webpage
		driver.navigate().forward();
		Thread.sleep(1000);
		
		//Refresh webpage
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		driver.close();
	}

}