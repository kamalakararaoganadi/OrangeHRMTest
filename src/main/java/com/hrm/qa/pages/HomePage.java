package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page factor - OR
	@FindBy(id = "welcome")
	@CacheLookup
	WebElement loggedInUser_id;
	
	@FindBy(xpath = "//b[contains(text(),'Time')]")
	WebElement timeLink_xpath;
	
	@FindBy(xpath = "//b[contains(text(),'Recruitment')]")
	WebElement RecruitmentLink_xpath;
	
    //Initialization 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String VerifyLoggedInUser() {
		Assert.assertTrue(loggedInUser_id.isDisplayed());
		return loggedInUser_id.getText();
	}
	
	public TimePage clickOnTimeLink() {
		timeLink_xpath.click();
		return new TimePage();
	}
	
	public RecruitmentPage clickOnRecruitmentLink() {
		RecruitmentLink_xpath.click();
		return new RecruitmentPage();
	}

}
