package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class SecureAreaPage extends BasePageObject {
	
	
	private By message = By.id("flash");
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/** Wait for the message to be visible on page*/
	public void waitForSecureAriaPageToLoad() {
		waitForVisibilityOf(message, 5);
	}
	
	
	public String getMessageText() {
		return find(message).getText();
	}

}
