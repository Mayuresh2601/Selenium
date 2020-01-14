/******************************************************************************
*  
*  Purpose: To Implement Selenium Automation script using Mouse Movement and keyboard Operations
*  @class Selenium script mouse movement and keyboard Operation
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.seleniumkeys;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysConnectivity 
{
	
	static {
    	System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/SeleniumKeys/Driver/chromedriver");
	}
	private static WebDriver driver;
	private static Robot robo;
	
    public static void main( String[] args )
    {   	
    	driver = new ChromeDriver();
    	driver.get("https://www.google.com");
    	
    	try {
    		robo = new Robot();
    		
    		robo.keyPress(KeyEvent.VK_ALT);
    		robo.keyPress(KeyEvent.VK_D);
    		robo.keyRelease(KeyEvent.VK_D);
    		robo.keyRelease(KeyEvent.VK_ALT);
    		
    		robo.keyPress(KeyEvent.VK_CONTROL);
    		robo.keyPress(KeyEvent.VK_C);
    		robo.keyRelease(KeyEvent.VK_C);
    		robo.keyRelease(KeyEvent.VK_CONTROL);
    		Thread.sleep(2000);
    		
    		robo.mouseMove(500, 500);

    		robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    		
    		robo.keyPress(KeyEvent.VK_CONTROL);
    		robo.keyPress(KeyEvent.VK_V);
    		robo.keyRelease(KeyEvent.VK_V);
    		robo.keyRelease(KeyEvent.VK_CONTROL);
    		Thread.sleep(2000);
    		
    		robo.keyPress(KeyEvent.VK_ENTER);
    		robo.keyRelease(KeyEvent.VK_ENTER);
    		Thread.sleep(2000);
    		driver.close();
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}	
    }
}
