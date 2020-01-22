package com.bridgelabz.selenium.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bridgelabz.selenium.Base;

public class DownloadPopUp extends Base{

	public static void main(String[] args) {
		try {
			FirefoxProfile profile = new FirefoxProfile();
			//By specifying key it will not show download popup on screen
			String key = "browser.helperApps.neverAsk.saveToDisk";
			
			//Specifying type of file to be downloaded
			String value = "application/zip";
			
			profile.setPreference(key, value);
			profile.setPreference("browser.download.folderList", 2);
			
			//Downloading file on desktop path
			profile.setPreference("browser.download.dir", "/home/admin1/Desktop");

			//Used to modify firefox setting
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability(FirefoxDriver.PROFILE, profile);

			driver = new FirefoxDriver(cap);
			driver.get("https://jqueryui.com");

			driver.findElement(By.linkText("Download")).click();

			element1 = driver.findElement(By.xpath("//input[@value='Download']"));
			x = element1.getLocation().getX();
			y = element1.getLocation().getY();

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy("+ x +","+ y +")");
			Thread.sleep(1000);
			
			Actions action = new Actions(driver);
			action.click(element1).perform();

			Thread.sleep(5000);
			driver.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
