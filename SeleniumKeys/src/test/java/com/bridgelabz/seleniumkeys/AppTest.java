package com.bridgelabz.seleniumkeys;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppTest extends Base{
	
	
	/**
	 * Method: To Execute method before each test method
	 */
	@BeforeSuite
	public void openBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}
	
	
	/**
	 * Method: To Execute method after each test method
	 */
	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}
	
	
	/**
	 * Method: Checking the Alignment of EmailId and Password TestFields
	 */
	@Test()
	public void LoginTextFieldAlignment() {
		
		WebElement emailIdTextfield = driver.findElement(By.xpath("//input[contains(@class,'inputtext')]"));
		int emailId_Height = emailIdTextfield.getSize().getHeight();
		int emailId_Width = emailIdTextfield.getSize().getWidth();
		System.out.println("Login EmailId Height "+emailId_Height);
		System.out.println("Login EmailId Width "+emailId_Width);
		
		WebElement passwordTextfield = driver.findElement(By.xpath("//input[@type='password']"));
		int password_Height = passwordTextfield.getSize().getHeight();
		int password_Width = passwordTextfield.getSize().getWidth();
		System.out.println("Login Password Textfield Height "+password_Height);
		System.out.println("Login Password Textfield Width "+password_Width);
		
		assertEquals(emailId_Height, password_Height);
		assertEquals(emailId_Width, password_Width);	
	}

	
	/**
	 * Method: Checking the Login Textfield of EmailId and Password is Displayed and Enabled
	 */
	@Test(priority = 2)
	public void LoginTextFieldDisplayedEnabled() {
				
		WebElement emailIdTextfield = driver.findElement(By.xpath("//input[contains(@class,'inputtext')]"));
		boolean emailId_Displayed = emailIdTextfield.isDisplayed();
		boolean emailId_Enabled = emailIdTextfield.isEnabled();
		System.out.println("Login EmailId TextField Displayed: "+emailId_Displayed);
		System.out.println("Login EmailId TextField Enabled: "+emailId_Enabled);
		
		WebElement passwordTextfield = driver.findElement(By.xpath("//input[@type='password']"));
		boolean password_Displayed = passwordTextfield.isDisplayed();
		boolean password_Enabled = passwordTextfield.isEnabled();
		System.out.println("Login Password Textfield Displayed: "+password_Displayed);
		System.out.println("Login Password Textfield Enabled: "+password_Enabled);
		
		assertTrue(emailId_Displayed);
		assertTrue(emailId_Enabled);

		assertTrue(password_Displayed);
		assertTrue(password_Enabled);
	}
	

	/**
	 * Method: Checking the Male Gender Radio Button is Selected
	 */
	@Test(priority = 1)
	public void GenderRadioButtonSelected() {
				
		WebElement maleRadio = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
		maleRadio.click();
		validateBoolean = maleRadio.isSelected();
		System.out.println("Male Radio Button Selected: "+validateBoolean);
		
		assertTrue(validateBoolean);
	}
	

	/**
	 * Method: Checking the Radio Button is validated
	 */
	@Test()
	public void RegistrationRadioButtonValidation() {
			
		WebElement radioButton = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
		validateString = radioButton.getAttribute("type");
		System.out.println("Radio Button Type: "+validateString);
		
		assertEquals(validateString, "radio");
	}
	
	
	/**
	 * Method: Checking the Game Link is validated
	 */
	@Test
	public void GameLinkValidation() {
			
		WebElement gameLink = driver.findElement(By.xpath("//ul[contains(@class,'page')]/li[10]/a"));
		String validateString = gameLink.getAttribute("title");
		System.out.println("Game Link Title: "+validateString);
		
		assertEquals(validateString, "Check out Facebook games.");
	}
	
}
