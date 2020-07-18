package com.jcp.testcases;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jcp.pageobjects.LoginPage;


public class TC_Login_001 extends BaseClass {
	
	@Test
	public void login() throws IOException {
		
		driver.get(getBaseURL());
		logger.info("URL is Opened");
		
		
		
	LoginPage login= new LoginPage(driver);
	
	login.accountToolTip.click();
	WebDriverWait wait=new WebDriverWait(driver,20);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='create_account_button']")));
	
	//login.btnCreateAccount.click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@automationid='at-email-input']")));
	
	login.emailInput.sendKeys(getEmail());
	logger.info("Enter email");
	login.passwordInput.sendKeys(getPassword());
	logger.info("Enter password");
	login.btnSign.click();
	logger.info("Click on Sign in Button");
	
	
	if(driver.getTitle().toLowerCase().contains("jcpenney123@#@$##@#@#@4")) {
		
		Assert.assertTrue(true);
		logger.info("Page title is displayed");
	}
	
	else {
		capturescreen(driver, "login");
		Assert.assertTrue(false);
		logger.info("Page title not displayed");
	}
	
	}

}
