package com.cas.news.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cas.driver.DriverSetup;

public class GetNewsDetails extends DriverSetup {

	@FindBy(xpath = "//div[@id= 'title_text']")
	WebElement standardNewsTitle;

	@FindBy(xpath = "//div[@data-automation-id = 'textBox']//p")
	WebElement newsText;
	
	public String[][] toolTipData = new String[5][4];
	private int toolTipPointer = 0;
	
	private String newsTitle;

	WebElement blogDate;
	WebElement blogHeader;
	WebElement blogText;

	public void initiate(String title) {
		newsTitle = title;

		if (!isBlog(newsTitle)) {
			wait.until(ExpectedConditions.titleIs(newsTitle));
			PageFactory.initElements(driver, this);
		} else {
			wait.until(ExpectedConditions.titleIs("Our growth mindset"));
		}
	}

	private boolean isBlog(String title) {
		return title.startsWith("CEO blog:");
	}

	public void getDetails() {
		if (isBlog(newsTitle)) {
			getBlogDetails();
		} else {
			getStandardDetails();
		}
	}

	private void getBlogDetails() {
		if(isLatest()) {
			getLatesBlog();
		}
		else {
			getSpecificBlog();
		}
		
		String heading = blogHeader.getText();
		String tooltip = "\"Not Available\"";

		System.out.println("Type : CEO Blog");
		System.out.println("Date : " + blogDate.getText());
		System.out.println("Title : " + heading);
		System.err.println("No Tooltip available");
		System.out.println("Blog first paragraph : " + blogText.getText());
		System.out.print("\n");
		
		String result = (heading.equals(tooltip))?"Passed":"Failed";		
		String[] item = {driver.getTitle(), heading, tooltip, result};
		
		toolTipData[toolTipPointer ++] = item;
	}

	private void getStandardDetails() {

		String heading = standardNewsTitle.getText();
		String tooltip = standardNewsTitle.getAttribute("title");

		System.out.println("Type : Standard News");
		System.out.println("Title: " + standardNewsTitle.getText());
		System.out.println("Tooltip : " + standardNewsTitle.getAttribute("title"));
		System.out.println("News first paragraph : " + newsText.getText());
		
		String result = (heading.equals(tooltip))?"Passed":"Failed";		
		String[] item = {driver.getTitle(), heading, tooltip, result};
		
		toolTipData[toolTipPointer ++] = item;

		Assert.assertEquals(heading, tooltip);
	}

	private boolean isLatest() {
		String url = driver.getCurrentUrl();

		return (!url.contains("#"));
	}

	private void getSpecificBlog() {

		String date = driver.getCurrentUrl();

		date = date.replace(
				"https://cognizantonline.sharepoint.com/sites/CorporateFunctions/SitePages/Our-growth-mindset.aspx#",
				"");

		date = date.replace("-", " ");

		date = Character.toUpperCase(date.charAt(0)) + date.substring(1);

		blogDate = driver.findElement(By.xpath("//h3[text() = '" + date + "']"));

		blogHeader = driver.findElement(By.xpath("(//h3[text() = '" + date + "']//following::p)[1]"));

		blogText = driver.findElement(By.xpath("(//h3[text() = '" + date + "']//following::p)[2]"));
		
		
	}

	private void getLatesBlog() {
		blogDate = driver.findElement(By.xpath("//h3"));

		blogHeader = driver.findElement(By.xpath("(//h3//following::p)[1]"));

		blogText = driver.findElement(By.xpath("(//h3//following::p)[2]"));
	}
}
