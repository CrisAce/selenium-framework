package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class StaleElementsPage extends BasePageObject {

	
	private String URL = "https://the-internet.herokuapp.com/notification_message_rendered";
	
	private By clickHereLink = By.linkText("Click here");
	private By message = By.id("flash");
	
	public StaleElementsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void open() {
		openURL(URL);
	}
	
	public void clickLink() {
		find(clickHereLink).click();
	}
	
	
	  public void waitForMessage() { 
		  waitForVisibilityOf(message, 10);
	}
	  
	  public String retriveMessage() { 
		  return find(message).getText(); 
	}
	 	
	
}
