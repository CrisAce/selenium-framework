package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class LoginPage extends BasePageObject{
	
	private String loginPageUrl = "https://the-internet.herokuapp.com/login";
	
	private By usernameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By logInButtonLocator = By.tagName("button");
	private By errorMessageLocator = By.id("flash");
	
	
	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void open() {
		openURL(loginPageUrl);
	}
	/*Wait for username field to be visible on page*/
	public void waitForLoginPageToLoad() {
		waitForVisibilityOf(usernameLocator, 5);
	}
	
	/** Positive log in test*/
	public SecureAreaPage login(String username, String password) {
		insertUsernameAndPassword(username, password);
		ClickLigInButton();
		return new SecureAreaPage(driver,log);
	} 
	/** Negative log in test*/
	public void  negativeLogin(String username, String password) {
		insertUsernameAndPassword(username, password);
		ClickLigInButton();
		waitForErrorMessage();
	} 
	
	
	/* Type given username and password*/
	private void insertUsernameAndPassword(String username, String password) {
		log.info("Entering username and password");
		find(usernameLocator).sendKeys(username);
		find(passwordLocator).sendKeys(password);
	}
	
	/** Click method for login */
	private void ClickLigInButton() {
		log.info("Clicking Login button");
		find(logInButtonLocator).click();
	}
	
	/**wait for error method*/
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, 5);
	}
	
	public String getErrorMessageText() {
		return find(errorMessageLocator).getText();
	}
	
	
	
	
}
