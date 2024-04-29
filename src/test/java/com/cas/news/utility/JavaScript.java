package com.cas.news.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cas.driver.DriverSetup;

public class JavaScript extends DriverSetup{
	
	private static JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public static void scroll(WebElement element, String x, String y) {
		js.executeScript("arguments[0].scrollBy(" + x + ", " + y + ")", element);
	}
	
	public static void clickElement(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}
}
