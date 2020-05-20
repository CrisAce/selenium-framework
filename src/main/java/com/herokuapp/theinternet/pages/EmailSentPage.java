package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class EmailSentPage extends BasePageObject {
	
	private By message = By.id("content");
	
	public EmailSentPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	
	public void waitForEmailSentPageToLoad() {
		waitForVisibilityOf(message, 5);
	}
	
	public String getMessageText() {
		return find(message).getText();
	}
}
