package com.cas.news.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cas.driver.DriverSetup;

public class Screenshot extends DriverSetup{
	public static String TakeWebScreenshot(String filename) {
		TakesScreenshot tScreenshot = (TakesScreenshot) driver;
		
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + filename + ".png";
		
		try {
			Thread.sleep(2000);
			File imgFile = tScreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imgFile, new File(path));
		}
		catch (Exception e) {
			path = "";
		}
		
		return path;
	}
}
