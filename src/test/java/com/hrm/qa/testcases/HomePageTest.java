package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.TimePage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TimePage timePage;

	public HomePageTest() {
		super();		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		timePage = new TimePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void VerifyHomePageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("homePageTitle"), "Title doesn't match with actual title");
	}
	
	@Test
	public void VerifyLoggedInUserTest() {
		
		String userLoggedIn = homePage.VerifyLoggedInUser();
		Assert.assertEquals(userLoggedIn, "Welcome "+prop.getProperty("username"),"User login information is not correct");
	}
	
	@Test(priority = 1)
	public void clickOnTimeLinkTest() {
		timePage = homePage.clickOnTimeLink();
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
