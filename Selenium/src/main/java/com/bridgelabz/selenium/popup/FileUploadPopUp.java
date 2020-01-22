package com.bridgelabz.selenium.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bridgelabz.selenium.Base;

public class FileUploadPopUp extends Base{
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		Thread.sleep(3000);
		
		//Uploading File 
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("/home/admin1/eclipse-workspace/Mayuresh/Selenium/Selenium/Webpages/Page2.html");
	
		Thread.sleep(4000);
		driver.close();
	}

}
