package com.hrm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hrm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 30;
	public static long ExPLICIT_WAIT = 30;
	
	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void explicit_Wait_For_WebElement(WebDriver driver,WebElement element,long exPLICIT_WAIT) {
		new WebDriverWait(driver, exPLICIT_WAIT).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		//element.click();
	}
	
	public static  String Testdatasheetpath = "C:\\Users\\kamalakararao.ganadi\\eclipse-workspace\\OrangeHRMTest\\src\\main\\java\\com\\hrm\\qa\\testdata\\LoginDetails.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] excel_GetTestData(String sheetName){
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(Testdatasheetpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		
		}
		return data;
		
	}
	
	public static void takeScreenShot() throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
                
                String currentDir = System.getProperty("user.dir");

                File DestFile=new File(currentDir+"\\screenShots\\"+System.currentTimeMillis()+".png");

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }
	
	
	
}
