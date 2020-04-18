package com.hrm.qa.utils;
/*************************************** PURPOSE **********************************

- This class implements the WebDriverEventListener, which is included under events.
The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
which would be displayed/logged as the application under test is being run.

Do not call any of these methods, instead these methods will be invoked automatically
as an when the action done (click, findBy etc). 

*/
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.hrm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		
		System.out.println("inside method afterChangeValueOf on " + arg0.toString());
	 }
	 
	@Override
	 public void afterClickOn(WebElement arg0, WebDriver arg1) {
	 
		 System.out.println("inside method afterClickOn on " + arg0.toString());
	 }
	 
	 @Override
	 public void afterFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println("Found Element By : " + by.toString());
	}
	 
	 @Override
	 public void afterNavigateBack(WebDriver arg0) {
	 
	 
		 System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
	 }
	 
	 @Override
	 public void afterNavigateForward(WebDriver arg0) {
	 
		 System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
	 }
	 
	 @Override
	 public void afterNavigateTo(String arg0, WebDriver arg1) {
	 
		 System.out.println("Inside the afterNavigateTo to " + arg0);
	 }
	 
	 @Override
	 public void afterScript(String arg0, WebDriver arg1) {
	 
		 System.out.println("Inside the afterScript to, Script is " + arg0);
	 }
	 
	 public void beforeChangeValueOf(WebElement element, WebDriver driver) {
			System.out.println("Value of the:" + element.toString() + " before any changes made");
		}
	 
	 @Override
	 public void beforeClickOn(WebElement arg0, WebDriver arg1) {
	 
		 System.out.println("About to click on the " + arg0.toString());
	 
	 }
	 
	 @Override
	 public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println("Trying to find Element By : " + by.toString());
		}
	 
	 @Override
	 public void beforeNavigateBack(WebDriver arg0) {
	 
		 System.out.println("Just before beforeNavigateBack " + arg0.getCurrentUrl());
	 
	 }
	 
	 @Override
	 public void beforeNavigateForward(WebDriver arg0) {
	 
		 System.out.println("Just before beforeNavigateForward " + arg0.getCurrentUrl());
	 
	 }
	 
	 @Override
	 public void beforeNavigateTo(String arg0, WebDriver arg1) {
	 
		 System.out.println("Just before beforeNavigateTo " + arg0);
	 }
	 
	 @Override
	 public void beforeScript(String arg0, WebDriver arg1) {
	 
		 System.out.println("Just before beforeScript " + arg0);
	 }
	 
	 @Override
	 public void onException(Throwable error, WebDriver driver) {
			System.out.println("Error occurred: " + error);
		 try {
			TestUtil.takeScreenShot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }	 
				 	 
	
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		
		
	}


	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		
	}


	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	
	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		
		
	}
	

}
