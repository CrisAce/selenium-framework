package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class JacascriptErrorsPage extends BasePageObject {
	
	private String URL = "https://the-internet.herokuapp.com/javascript_error"; 
	
	public JacascriptErrorsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//Open Page
	
	public void openURL() {
		openURL(URL);
	}
	

}
