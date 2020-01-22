package com.bridgelabz.selenium.popup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bridgelabz.selenium.Base;

public class WindowPopUp extends Base{

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		Thread.sleep(1000);
	
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		//Storing multiple windows object in Set
		Set<String> handler =driver.getWindowHandles();
		
		//Iterating one by one windows object
		Iterator<String> it = handler.iterator();
		
		//Parent window Id
		String parentWindowId = it.next();
		System.out.println("Parent Window Id :"+parentWindowId);
		
		//Child Window Id
		String childWindowId =it.next();
		System.out.println("Child Window Id :"+childWindowId);
	
		Thread.sleep(2000);
		//Switching to child Window
		driver.switchTo().window(childWindowId);
		Thread.sleep(1500);
		
		//Printing title of child window pop-up
		System.out.println("Child Window PopUp Title:"+driver.getTitle());
		
		Thread.sleep(2000);
		//Switching to parent Window
		driver.switchTo().window(parentWindowId);
		Thread.sleep(1500);
		
		//Printing title of Parent window pop-up
		System.out.println("Parent Window PopUp Title:"+driver.getTitle());
		Thread.sleep(1000);
		driver.close();
	}
}
