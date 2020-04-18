package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.TimePage;

public class TimePageTest extends TestBase{
	
	TimePage timePage;
	HomePage homePage;
	LoginPage loginPage;

	public TimePageTest() {
		
		super();
		
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		timePage = homePage.clickOnTimeLink();
	}
	
	
	@Test
	public void verifyTimePageLoadedTest() {
		
		
		String timeLinkPageLabel = timePage.verifyTimePageLoaded();
		Assert.assertEquals(timeLinkPageLabel, "Timesheets","Time page not loaded");
	}
	
		
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
