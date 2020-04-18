package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.qa.base.TestBase;

public class RecruitmentPage extends TestBase {
	@FindBy(xpath =  "//a[@id='menu_recruitment_viewCandidates']")
	WebElement CandidateLabel;
	
	public RecruitmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyRecruitmentPageLoaded() {
		
		//Assert.assertTrue(CandidateLabel.isDisplayed());
		return CandidateLabel.getText();
	}
}
