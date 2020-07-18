package com.jcp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="accountBlock")
	public WebElement accountToolTip;

	 @FindBy(how = How.XPATH, using = "//*[@data-automation-id='create_account_button']")
	 public WebElement btnCreateAccount;
	 
	 @FindBy(how = How.XPATH, using = "//*[@automationid='at-email-input']")
	 public WebElement emailInput;
	 
	 @FindBy(how = How.XPATH, using = "//*[@data-automation-id='header-amn-signout']")
	 public WebElement logout;
	 
	 @FindBy(how = How.XPATH, using = "[data-automation-id='signin_error-title']")
	 public WebElement errorSigninMessage;
	 
	 
	 
	 @FindBy(how = How.XPATH, using = "//*[@data-automation-id='passwrod_input']")
	 public WebElement passwordInput;
	 
	 @FindBy(how = How.XPATH, using = "//*[@data-automation-id='signin_button']")
	 public WebElement btnSign;
	 
	 @FindBy(how = How.XPATH, using = "//*[@data-automation-id='at-panel-title']")
	 public WebElement accountpaneltitle;

	 
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	
	 
	 public void customerSliderLogin() {
		 
		 
		 
	 }
	 
	 

}
