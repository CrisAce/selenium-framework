package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.herokuapp.theinternet.base.BasePageObject;

public class ScrollLargePagesWithJSExecutor extends BasePageObject {
	
	private String URL = "https://the-internet.herokuapp.com/large";
	private By table = By.cssSelector("#large-table");
	

	public ScrollLargePagesWithJSExecutor(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void open() {
		openURL(URL);
	}
	
	public WebElement scrollToTable() {
		return find(table);
	}

}
