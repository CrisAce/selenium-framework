package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class HiddenElementOnPage extends BasePageObject{
	
	String pageURL="https://the-internet.herokuapp.com/dynamic_loading/1";
	
	private By startBtn = By.tagName("button");
	private By textAfterStartBtn = By.id("finish");

	public HiddenElementOnPage(WebDriver driver,Logger log) {
		super(driver, log);
	}
	
	public void open() {
		openURL(pageURL);
	}
	
	public void clickStartBtn() {
		find(startBtn).click();
		System.out.println("Click Start Button");
	}
	
	public  Boolean clickIsVisible() {
	Boolean visibility =find(startBtn).isDisplayed();
		return visibility;
	}
	
	public void waitForVisibilityOfText() {
		waitForVisibilityOf(textAfterStartBtn, 10);
	}
	
	public String getTextAfterWait() {
		return find(textAfterStartBtn).getText();
	}
	

}
