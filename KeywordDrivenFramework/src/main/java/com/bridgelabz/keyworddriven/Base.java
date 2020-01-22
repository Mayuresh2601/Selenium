package com.bridgelabz.keyworddriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	static WebDriver driver;
	static Properties properties;
	static FileInputStream configFile;
	
	
	/**Method: To Initialize the WebDriver
	 * @param browserName
	 * @return WebDriver
	 */
	public WebDriver init_Driver(String browserName) {
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	
	/**Method: To Initialize the Property file
	 * @return Properties
	 */
	public Properties init_Properties() {
		
		properties = new Properties();
		try {
			configFile = new FileInputStream("/home/admin1/eclipse-workspace/Mayuresh/Selenium/KeywordDrivenFramework/src/main/resources/config.properties");
			properties.load(configFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return properties;
	}
}
