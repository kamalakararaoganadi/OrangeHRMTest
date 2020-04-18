package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.utils.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetName = "Login";
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();

	}
	
    @Test
	public void validateLoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("loginPageTitle"), "Title doesn't match with actual title");
	}
	
	@Test
	public void ValidateHRMLogoTest() {
		boolean flag = loginPage.ValidateHRMLogo();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getHRMLoginDetails(){
		Object data[][] = TestUtil.excel_GetTestData(sheetName);
		//System.out.println(data[1][0]);
		return data;
	}
	
	@Test(dataProvider = "getHRMLoginDetails")
	public void loginTest(String UserName,String Password) {
		
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //getting test data from properties file
		
		
		homePage = loginPage.login(UserName, Password); //getting test data from excel
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
