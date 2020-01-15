package com.bridgelabz.seleniumkeys;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest extends Base{
	
	@Test
	public void LoginTextFieldAlignment() {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
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
		driver.close();
		
		assertEquals(emailId_Height, password_Height);
		assertEquals(emailId_Width, password_Width);	
	}

	@Test
	public void LoginTextFieldDisplayed() {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		WebElement emailIdTextfield = driver.findElement(By.xpath("//input[contains(@class,'inputtext')]"));
		boolean emailId = emailIdTextfield.isDisplayed();
		System.out.println("Login EmailId TextField "+emailId);
		
		WebElement passwordTextfield = driver.findElement(By.xpath("//input[@type='password']"));
		boolean password = passwordTextfield.isDisplayed();
		System.out.println("Login Password Textfield "+password);
		driver.close();
		
		assertEquals(emailId, true);
		assertEquals(password, true);
	}
	
	@Test
	public void LoginTextFieldEnabled() {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		WebElement emailIdTextfield = driver.findElement(By.xpath("//input[contains(@class,'inputtext')]"));
		boolean emailId = emailIdTextfield.isEnabled();
		System.out.println("Login EmailId TextField "+emailId);
		
		WebElement passwordTextfield = driver.findElement(By.xpath("//input[@type='password']"));
		boolean password = passwordTextfield.isEnabled();
		System.out.println("Login Password Textfield "+password);
		driver.close();
		
		assertEquals(emailId, true);
		assertEquals(password, true);
	}
	
	@Test
	public void EmailIdTextFieldSeleted() {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		WebElement emailIdTextfield = driver.findElement(By.xpath("//input[contains(@class,'inputtext')]"));
		boolean emailId = emailIdTextfield.isSelected();
		System.out.println("Login EmailId TextField "+emailId);
		driver.close();
		
		assertEquals(emailId, false);
	}

}
