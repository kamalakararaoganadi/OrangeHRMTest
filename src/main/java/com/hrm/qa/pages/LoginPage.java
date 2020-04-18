package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory or Object Repository
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@id='divLogo']//img")
	WebElement logo;
	
	//Constructor --- initialize page objects
	public LoginPage() {
		//We are invoking the all the page factory objects or webElements through the driver object by using  PageFactory.initElements
		//PageFactory.initElements(driver, LoginPage.class);// we are going to initialize/invoke the object repository of this class
		PageFactory.initElements(driver, this); // the sophisticated way to write the above line of code.  this --- represents this class. 
	}
	
	//Actions: nothing but features in the login page
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateHRMLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un,String Pwd) {
		username.sendKeys(un);
		password.sendKeys(Pwd);
		loginButton.click();
		
		return new HomePage();
	}
}
