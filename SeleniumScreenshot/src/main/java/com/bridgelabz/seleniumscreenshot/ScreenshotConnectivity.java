/******************************************************************************
*  
*  Purpose: To Implement Selenium Automated webpages screenshot
*  @class Selenium Screenshots
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.seleniumscreenshot;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotConnectivity 
{
	static {
    	System.setProperty("webdriver.chrome.driver","/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumScreenshot/Driver/chromedriver");
	}
	private static WebDriver driver;
	
    public static void main( String[] args )
    {
      
    	Date date = new Date();
     	
    	driver = new ChromeDriver();
    	
    	driver.get("https://www.facebook.com");
    	
    	TakesScreenshot screenshot1 = (TakesScreenshot) driver;
    	
    	//To get the Source File and store it in file.io
    	File srcFile1 = screenshot1.getScreenshotAs(OutputType.FILE);
    	
    	//To store the screenshot in the destination file
    	File destFile = new File("/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumScreenshot/Screenshots/" + date + ".png");
    	
    	try {
    		FileUtils.copyFile(srcFile1, destFile);
    		Thread.sleep(2000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	driver.close();
    }
}
