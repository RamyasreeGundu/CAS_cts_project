package com.cas.news.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cas.driver.DriverSetup;
import com.cas.news.utility.JavaScript;

public class GetMainPageNews extends DriverSetup{

	@FindBy(xpath = "//div[@data-automation-id= 'textBox']//strong[text() = 'Around Cognizant']")
	WebElement newsHeading;
	
	@FindBy(xpath = "//div[@data-automation-id = 'contentScrollRegion']")
	WebElement scrollView;
	
	@FindBy(xpath = "//div[@data-automation-id= 'gridNewsLayout']//div[contains(@class, 'newsItem')]//a")
	List<WebElement> newsLinks;
	
	@FindBy(xpath = "//div[@data-automation-id = 'textBox']//strong[text() = 'See all']")
	WebElement seeAllBtn;
	
	public String[][] tooltipExcelData;
	private int tooltipPointer;
	
	public void initiatePageFactory() {
		wait.until(ExpectedConditions.titleIs("Be.Cognizant - Home"));
		PageFactory.initElements(driver, this);
	}
	
	public String validateNewsSection() {
		JavaScript.scroll(scrollView, "0", "500");
		
		String text = newsHeading.getText();
		
		return text;
	}
	
	private void checkToolTipsHelper(List<WebElement> news) {
		if(news.size() == 0) {
			return;
		}
		
		String headline = news.get(0).getText();
		String tooltip = news.get(0).getAttribute("title");
		
		String result = (headline.equals(tooltip))?"Passed":"Failed";
		
		String[] data = {"Home Page", headline, tooltip, result};
		
		tooltipExcelData[tooltipPointer ++] = data;
		
		System.out.println("News Title : " + headline);
		System.out.println("Tooltip Text : " + tooltip);
		System.out.print("\n");
		
		Assert.assertEquals(headline, tooltip);
		
		checkToolTipsHelper(news.subList(1, news.size()));
	}
	
	public void checkToolTips() {
		tooltipExcelData = new String[newsLinks.size()][4];
		tooltipPointer = 0;
		checkToolTipsHelper(newsLinks);
	}
	
	public void clickSeeAll() {
		seeAllBtn.click();
		System.out.println("'See All' link clicked\n");
	}
}
