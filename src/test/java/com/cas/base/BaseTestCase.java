package com.cas.base;

import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cas.driver.DriverSetup;
import com.cas.news.test.pages.GetMainPageNews;
import com.cas.news.test.pages.GetSeeAllNews;
import com.cas.news.test.pages.GetUserInformation;
import com.cas.news.utility.ExcelDataHandler;
import com.cas.news.utility.Screenshot;

public class BaseTestCase extends DriverSetup {
	
	protected GetUserInformation getUserInfo = new GetUserInformation();
	protected GetMainPageNews getMainNews = new GetMainPageNews();
	protected GetSeeAllNews getAllNews = new GetSeeAllNews();

	protected ExcelDataHandler excelDataHandler = new ExcelDataHandler();

	protected static ExtentReports extent = new ExtentReports();
	protected ExtentTest test;

	@BeforeSuite
	@Parameters({ "BaseURL", "Browser"})
	public void initiateDriver(String URL, String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			initChromeDriver();
		}
		else {
			initEdgeBrowser();
		}
		navigate(URL);
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\extentReport.html");
		extent.attachReporter(htmlReporter);
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		Date date = new Date();
		long dateLong = date.getTime();
		test.addScreenCaptureFromPath(Screenshot.TakeWebScreenshot("TestCaseImg"+dateLong));
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} 
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.YELLOW));
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		
		extent.flush();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
