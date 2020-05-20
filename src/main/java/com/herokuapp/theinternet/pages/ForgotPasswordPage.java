package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class ForgotPasswordPage extends BasePageObject {
	
	private By emailFieldLocator = By.id("email");
	private By retriverPasswordButtonLocator = By.tagName("button");
	
	public ForgotPasswordPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	
	/** Wait for Retrive Password button to be visible on the page*/
	public void waitForForgotPasswordPageToLoad() {
		waitForVisibilityOf(retriverPasswordButtonLocator, 5);
	}
	
	
	/** Execute RetrivePassword*/
	public EmailSentPage executeRetrivePassword(String email) {
		find(emailFieldLocator).sendKeys(email);
		find(retriverPasswordButtonLocator).click();
		return new EmailSentPage(driver,log);
	}
}
