package com.bridgelabz.linkedin.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.TestBase;
import com.bridgelabz.linkedin.pages.SignInPage;

public class SignInPageTest extends TestBase{
	
	
	/**
	 * Constructor: To Avoid Null Pointer Exception by going to parent class(TestBase) using super()
	 */
	public SignInPageTest() {
		
		super();
	}
	
	
	/**
	 * Method: To Run Initialize method before running each Testcases
	 */
	@BeforeMethod
	public void beginTest() {
		
		init_Driver();
		signIn = new SignInPage();
	}
	
	
	/**
	 * Method: To Test the Sign In Page is working properly or not 
	 */
	@Test(priority = 6)
	public void SignInTest() {
		
		homePage = signIn.signIn(properties.getProperty("emailId"), properties.getProperty("passWord"));
	}
	
	
	/**
	 * Method: To validate Forget Password Link present on Webpage or not
	 * @throws InterruptedException 
	 */
	@Test(priority = 4)
	public void validateForgetPasswordLinkTest() throws InterruptedException {
		
		flag = signIn.validateForgetPasswordLink(properties.getProperty("username"));
		assertEquals(flag, true);
	}
	
	
	/**
	 * Method: To validate Sign In Page Title
	 */
	@Test(priority = 1)
	public void verifySignInPageTitleTest() {
		
		validate = signIn.verifySignInPageTitle();
		assertEquals(validate, "LinkedIn Login, Sign in | LinkedIn");
	}
	
	
	/**
	 * Method: To validate Show Password Button present on Webpage or not
	 */
	@Test(priority = 2)
	public void validateShowPasswordTest() {
		
		flag = signIn.validateShowPassword(properties.getProperty("username") ,properties.getProperty("password"));
		assertEquals(flag, true);
	}
	
	
	/**
	 * Method: To Test Join Now Link is working properly or not
	 */
	@Test(priority = 5)
	public void validateJoinNowLinkTest() {
		
		joinNow = signIn.validateJoinNowLink();
	}
	
	
	/**
	 * Method: To validate Hide Password Button present on Webpage or not
	 */
	@Test(priority = 3)
	public void validateHidePasswordTest() {
		
		flag = signIn.validateHidePassword(properties.getProperty("username") ,properties.getProperty("password"));
		assertEquals(flag, true);
	}

	
	/**
	 * Method: To Run Terminate method after running each Testcases
	 */
	@AfterMethod
	public void endTest() {
		
		driver.quit();
	}
}