package com.cas.news.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.cas.base.BaseTestCase;

public class UserInformationTest extends BaseTestCase{
	
	@BeforeClass
	private void initiatePageFactory() {
		wait.until(ExpectedConditions.titleIs("Be.Cognizant - Home"));
		getUserInfo.initiatePageFactory();
	}
	
	@Test
	private void PrintUserDetails() throws Exception {
		test = extent.createTest("Validate User Info", "Test to fetch the user info");
		System.out.println("Fetching account details");
		getUserInfo.getGeneralInfo();
		getUserInfo.getDetailedInfo(2);
	}
}
