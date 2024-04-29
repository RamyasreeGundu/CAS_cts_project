package com.cas.news.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cas.driver.DriverSetup;

public class GetSeeAllNews extends DriverSetup {

	GetNewsDetails getNewsDetails = new GetNewsDetails();

	@FindBy(xpath = "//a[@data-automation-id = 'newsItemTitle']")
	List<WebElement> newsItems;

	@FindBy(xpath = "//span[contains(@class, 'author')]")
	List<WebElement> newsAuthors;

	public String[][] tooltipExcelData;
	private int tooltipPointer;
	
	public String[][] newsDetailsData;

	public void initiatePageFactory() {
		wait.until(ExpectedConditions.titleIs("News"));
		PageFactory.initElements(driver, this);
	}

	public void validateToolTipsHelper(List<WebElement> newsList) {
		if (newsList.size() == 0) {
			return;
		}

		String headline = newsList.get(0).getText();
		String tooltip = newsList.get(0).getAttribute("title");
		
		String result = (headline.equals(tooltip)) ? "Passed" : "Failed";

		String[] data = { "All News Page", headline, tooltip, result };

		tooltipExcelData[tooltipPointer++] = data;

		System.out.println("News Title : " + headline);
		System.out.println("Tooltip Text : " + tooltip);
		System.out.print("\n");

		Assert.assertEquals(headline, tooltip);

		validateToolTipsHelper(newsList.subList(1, newsList.size()));
	}

	public void validateToolTips() {
		tooltipExcelData = new String[5][4];
		tooltipPointer = 0;
		validateToolTipsHelper(newsItems.subList(0, 5));
	}

	private void getNewsDetailsHelper(WebElement news) {
		String newsUrl = driver.getCurrentUrl();

		String title = news.getText();

		news.click();

		getNewsDetails.initiate(title);

		getNewsDetails.getDetails();

		navigate(newsUrl);
	}

	public void getNewsDetails() {
		for (byte i = 0; i < 5; i++) {
			initiatePageFactory();
			String authorName = newsAuthors.get(i).getText();
			getNewsDetailsHelper(newsItems.get(i));
			System.out.println("Author's Name : " + authorName + "\n");
		}
		
		newsDetailsData = getNewsDetails.toolTipData;
	}
}
