package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.herokuapp.theinternet.base.BasePageObject;

public class DynamicallyLoadedElementsPage extends BasePageObject {
	
	private String pageURL = "https://the-internet.herokuapp.com/dynamic_loading/2";
	
	private By startButton =   By.xpath("//button");
	private By textAfterClickStart = By.cssSelector("#finish"); 
	
	
	public DynamicallyLoadedElementsPage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	
	//Open page URL
	public void open() {
		openURL(pageURL);
	}
	
	//Click start button
	public void clickStartButton() {
		log.info("Click Start Button");
		find(startButton).click();
	}
	
	public void waitForMessageToAppear() {
		//waitForVisibilityOf(textAfterClickStart, 10);
		waitForPresenceOf(textAfterClickStart, 5);
	}
	
	public String getTextAfterWait() {
		return find(textAfterClickStart).getText();
	}
	

}
