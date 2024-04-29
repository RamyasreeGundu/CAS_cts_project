package com.cas.news.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cas.base.BaseTestCase;

public class AllNewsPageTests extends BaseTestCase{
	
	@BeforeClass
	private void initiatePageClass() {
		getAllNews.initiatePageFactory();
	}
	
	@Test(priority = 4)
	private void ValidateSeeAllToolTips() {
		test = extent.createTest("Validate News Tool Tips in All News Page", "Comparing and checking if the Headlines and the tooltips are the same for news displayed in all news page");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
		System.out.println("Validating All News Page Tooltips :\n");
		getAllNews.validateToolTips();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
		
		excelDataHandler.writeTooltipData(getAllNews.tooltipExcelData);
	}
	
	@Test(priority = 5)
	private void GetNewsDetails() {
		test = extent.createTest("Get News Details", "Test to fetch the news details for the top 5 news in the all news page");
		getAllNews.getNewsDetails();
		excelDataHandler.writeTooltipData(getAllNews.newsDetailsData);
	}
}
