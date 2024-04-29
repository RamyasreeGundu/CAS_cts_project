package com.cas.news.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cas.driver.DriverSetup;

public class GetUserInformation extends DriverSetup{
	
	@FindBy(xpath = "//button[contains(@title, 'Account manager')]")
	WebElement profileBtn;
	
	@FindBy(xpath = "//div[@id= 'mectrl_currentAccount_primary']")
	WebElement accountNameDiv;
	
	@FindBy(xpath = "//div[@id= 'mectrl_currentAccount_secondary']")
	WebElement accountIDDiv;
	
	public void initiatePageFactory() {
		wait.until(ExpectedConditions.titleIs("Be.Cognizant - Home"));
		PageFactory.initElements(driver, this);
	}
	
	public void getGeneralInfo() {
		System.out.println("\t" + profileBtn.getAttribute("title"));
	}
	
	public void getDetailedInfo(int n) throws Exception {
		try {
			profileBtn.click();
			System.out.println("\tName: " + accountNameDiv.getAttribute("innerHTML"));
			System.out.println("\tEmail: " + accountIDDiv.getText());
			System.out.print("\n");
		}
		catch (Exception e) {
			if(n == 0) {
				System.err.println("Failed to validate to user details");
				throw e;
			}
			else {
				getDetailedInfo(n-1);
			}
		}
	}
}
