package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrm.qa.base.TestBase;

public class TimePage extends TestBase {

	@FindBy(xpath =  "//a[@id='menu_time_Timesheets']")
	WebElement timeLinkPage;
	
	public TimePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTimePageLoaded() {
		
		Assert.assertTrue(timeLinkPage.isDisplayed());
		return timeLinkPage.getText();
	}
	
	
}
