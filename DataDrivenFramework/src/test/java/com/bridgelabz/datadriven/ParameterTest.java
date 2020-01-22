package com.bridgelabz.datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest extends Base{
	
	/**
	 * Method: To Open the Browser using WebDriver
	 */
	@BeforeMethod
	public void openBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
	}
	
	
	/**Method: To Test Login Data from Xml file
	 * @param userName
	 * @param password
	 * @throws InterruptedException
	 */
	@Test
	@Parameters({"username","password"})
	public void facebookLoginTest(String username, String password) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[contains(@class,'inputtext')]")).clear();
		driver.findElement(By.xpath("//input[contains(@class,'inputtext')]")).sendKeys(username);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//tr/following-sibling::tr//input[@type='password']")).clear();
		driver.findElement(By.xpath("//tr/following-sibling::tr//input[@type='password']")).sendKeys(password);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[contains(@value,'Log In')]")).click();
		Thread.sleep(1000);
	}
	
	
	/**
	 * Method: To Close All Opened Browser which are Automated
	 */
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
}
