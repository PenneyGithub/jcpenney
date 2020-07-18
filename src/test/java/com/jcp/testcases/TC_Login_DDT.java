package com.jcp.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.XLSBUnsupportedException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jcp.pageobjects.LoginPage;
import com.jcp.utilities.XLUtils;



public class TC_Login_DDT extends BaseClass {
	
	
	
	
	@Test(dataProvider ="LoginData" )
	public void loginDDT(String username, String password) throws IOException, InterruptedException {
		
		driver.get(getBaseURL());
		logger.info("URL is Opened");
		
		
		
	LoginPage login= new LoginPage(driver);
	boolean bool;
	login.accountToolTip.click();
	Thread.sleep(2000);
	try {
	 bool = login.logout.isDisplayed();
	} 
	
	catch(Exception e){
		bool=false;
	}
	
	if(bool) {
		login.logout.click();
		Thread.sleep(3000);
		login.accountToolTip.click();
	}
	WebDriverWait wait=new WebDriverWait(driver,3);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='create_account_button']")));
	
	//login.btnCreateAccount.click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@automationid='at-email-input']")));
	
		
		
		login.emailInput.sendKeys(username);
		logger.info("Enter email");
		login.passwordInput.sendKeys(password);
		logger.info("Enter password");
		login.btnSign.click();
		logger.info("Click on Sign in Button");
		
		
		
		Thread.sleep(3000);
		try {
			boolean bool1 = login.emailInput.isDisplayed();
		if(bool1) {
			
			capturescreen(driver, "loginDDT");
			Assert.fail("Login credentials are not valid");
			logger.info("Page title not displayed");
			
		}
		else {
			Assert.assertTrue(true);
			logger.info("Page title is displayed");
		}
		}
		
		catch(Exception e) {
			
			Assert.assertTrue(true);
			logger.info("Page title is displayed");
		}
		
		
		
	}
	
	@DataProvider(name="LoginData")
	String [][]  getData() throws IOException{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/jcp/testdata/loginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Foglio1");
		int colnum = XLUtils.getCellCount(path, "Foglio1", 1);
		String loginData[][] = new String[rownum][colnum];
		for (int i = 1; i <=rownum; i++) {
			for (int j = 0; j < colnum; j++) {

				loginData[i - 1][j] = XLUtils.getCellData(path, "Foglio1", i, j);

			}
		}

		return loginData;
	}

}
