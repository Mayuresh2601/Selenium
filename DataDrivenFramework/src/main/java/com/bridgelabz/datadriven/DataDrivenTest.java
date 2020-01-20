package com.bridgelabz.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.bridgelabz.datadriven.utility.Utility;

public class DataDrivenTest extends Base{

	public static void main(String[] args) throws InterruptedException {
		
		//WebDriver Code
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		//Data Driven Approach (Parameterization Approach) :-> Driving the test data from Excel Sheet 
		utility = new Utility();
		utility.ReadXlsxFile("/home/admin1/eclipse-workspace/Mayuresh/Selenium/DataDrivenFramework/xlsxfiles/FacebookTestData.xlsx");
		
		int rowCount = utility.getRowCount("RegDataTest");
		System.out.println("Number of Rows in Sheet are: "+rowCount);
		
		for (int i = 2; i <= rowCount; i++) {
			
			String firstName = utility.getData("RegDataTest", "firstName", i);
			System.out.println("User FirstName is: "+firstName);
			
			String surname = utility.getData("RegDataTest", "surname", i);
			System.out.println("User Surname is: "+surname);
			
			String emailId = utility.getData("RegDataTest", "emailId", i);
			System.out.println("User EmailId is: "+emailId);
			
			String confirmEmailId = utility.getData("RegDataTest", "confirmEmailId", i);
			System.out.println("User Confirm EmailId is: "+confirmEmailId);
			
			String password = utility.getData("RegDataTest", "password", i);
			System.out.println("User Password is: "+password);
			
			System.out.println("*****Birthday Details*****");		
			String birthday = utility.getData("RegDataTest", "Birthday", i);
			
			//To split Birthday due to getting value in decimals
			String[] date = birthday.split("/");
			String day = date[0];
			String month = date[1];
			String year = date[2];
			System.out.println("User Birthday: "+birthday);
			System.out.println();
			
			driver.findElement(By.name("firstname")).clear();
			driver.findElement(By.name("firstname")).sendKeys(firstName);
			Thread.sleep(500);
			
			driver.findElement(By.name("lastname")).clear();
			driver.findElement(By.name("lastname")).sendKeys(surname);
			Thread.sleep(500);
			
			driver.findElement(By.name("reg_email__")).clear();
			driver.findElement(By.name("reg_email__")).sendKeys(emailId);
			Thread.sleep(500);
			
			driver.findElement(By.name("reg_email_confirmation__")).clear();
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys(confirmEmailId);
			Thread.sleep(500);
			
			driver.findElement(By.name("reg_passwd__")).clear();
			driver.findElement(By.name("reg_passwd__")).sendKeys(password);
			Thread.sleep(500);
			
			Select select = new Select(driver.findElement(By.id("day")));
			select.selectByVisibleText(day);
			
			select = new Select(driver.findElement(By.cssSelector("#month")));
			select.selectByVisibleText(month);
			
			select = new Select(driver.findElement(By.xpath("//select[@id='year']")));
			select.selectByVisibleText(year);
			
			driver.findElement(By.cssSelector("#u_0_7")).click();
			
			driver.findElement(By.name("websubmit")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(3000);
		driver.close();
	}
}
