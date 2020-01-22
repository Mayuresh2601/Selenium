package com.bridgelabz.keyworddriven;

import org.testng.annotations.Test;

/**
 * TestNG test for Facebook Application.
 */
public class FacebookLoginTest {
	
	private KeywordDriven keyword;
	
	/**
	 * Method: To Test Login Data
	 */
	@Test
	public void LoginTest() {
		
		keyword = new KeywordDriven();
		keyword.startExecution("ScenarioDataTest");
	}
}
