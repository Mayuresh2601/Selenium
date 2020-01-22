package com.bridgelabz.selenium.popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bridgelabz.selenium.Base;

public class AlertPopUp extends Base{

	public static void main(String[] args) {
		
		try {
			driver = new ChromeDriver();
			driver.get("https://www.rediff.com/");
			// Clicking on Search Button
			driver.findElement(By.xpath("//form[@id='queryTop']//input[@class='newsrchbtn']")).click();
			Thread.sleep(1000);
			
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert Message is: "+alertMsg );
			
			// Validating Alert Message
			if (alertMsg.equals("Please enter search keyword")) {
				System.out.println("Correct Alert Message");
			} else {
				System.out.println("InCorrect Alert Message");
			}

			alert.accept();
			driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
