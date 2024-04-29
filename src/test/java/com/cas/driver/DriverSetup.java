package com.cas.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSetup {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	protected void initChromeDriver() {
		driver = new ChromeDriver();
		setUpWait();
		driver.manage().window().maximize();
	}
	
	protected void initEdgeBrowser() {
		driver = new EdgeDriver();
		setUpWait();
		driver.manage().window().maximize();
	}
	
	protected void navigate(String URL) {
		driver.navigate().to(URL);
	}
	
	private void setUpWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
}
