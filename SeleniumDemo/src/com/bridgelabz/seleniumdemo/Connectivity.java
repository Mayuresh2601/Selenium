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
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
		WebDriver driver1 = new ChromeDriver();
		
		driver1.get("https://www.google.com");
		
		//Get Webpage Title
		String title = driver1.getTitle();
		System.out.println("Title of Webpage is: "+title);
		
		//Get Webpage Url
		String pageUrl = driver1.getCurrentUrl();
		System.out.println("Url of Webpage is: "+pageUrl);
		
		//Get Webpage Source code
		String pageSourceCode = driver1.getPageSource();
		System.out.println("Source code of Webpage is: "+pageSourceCode);
		
		Thread.sleep(2000);
		driver1.close();
		
		WebDriver driver2 = new ChromeDriver();
		
		driver2.get("https://www.google.com");
		
		// Navigate to Gmail webpage
		driver2.navigate().to("https://www.gmail.com");
		Thread.sleep(1000);
		
		//Navigate Back to Google webpage
		driver2.navigate().back();
		Thread.sleep(1000);
		
		//Navigate to Gmail webpage
		driver2.navigate().forward();
		Thread.sleep(1000);
		
		//Refresh webpage
		driver2.navigate().refresh();
		
		driver2.close();
	}

}