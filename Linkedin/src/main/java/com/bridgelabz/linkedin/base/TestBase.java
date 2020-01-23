package com.bridgelabz.linkedin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bridgelabz.linkedin.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	
	
	/**
	 * Constructor: To Load the Properties file in file.io
	 */
	public TestBase() {
		try {
			
			properties = new Properties();
			FileInputStream file = new FileInputStream("/home/admin1/eclipse-workspace/Mayuresh/Selenium/Linkedin/src/main/java/com/bridgelabz/linkedin/config/config.properties");
			properties.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method: To Initialize the WebDriver 
	 */
	public static void init_Driver() {
		
		String browserName = properties.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/Linkedin/src/main/java/com/bridgelabz/linkedin/drivers/chromedriver");
			driver = new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/admin1/eclipse-workspace/Mayuresh/Selenium/Linkedin/src/main/java/com/bridgelabz/linkedin/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
	}
}
