package com.cas.news.test;

import com.cas.base.BaseTestCase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTestCase{
	
	@BeforeClass
	public void initiatePageClass() {
		getMainNews.initiatePageFactory();
	}
	
	@Test(priority = 1)
	private void ValidateHeader() {
		test = extent.createTest("Validate News Section", "Test to see if News Around Cognizant section is present");
		String headerTextString = getMainNews.validateNewsSection();
		
		Assert.assertTrue((headerTextString.equals("Around Cognizant")), "Validation failed for 'Around Cognizant' header");
	}
	
	@Test(priority = 2)
	private void ValidateMainPageToolTips() {
		test = extent.createTest("Validate News Tooltips in Main Page", "Comparing and checking if the Headlines and the tooltips are the same for news displayed in main page");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
		System.out.println("Validating Main Page Tooltips :\n");
		getMainNews.checkToolTips();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
		
		excelDataHandler.writeTooltipData(getMainNews.tooltipExcelData);
	}
	
	@Test(priority = 3)
	private void SellAll() {
		test = extent.createTest("Clicking on 'See All' news link", "Test click on the See all hyperlink");
		getMainNews.clickSeeAll();
	}
}
