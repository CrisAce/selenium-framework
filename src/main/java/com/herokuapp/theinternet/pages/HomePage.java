package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class HomePage extends BasePageObject {
	
	private String homePageURL ="https://the-internet.herokuapp.com/";
	
	private By forgotPasswordLinkLocator = By.linkText("Forgot Password");
	private By formAuthenticationLinkLocator =By.linkText("Form Authentication");
	
	public HomePage(WebDriver driver, Logger log) {
		super(driver,log);
	}
	

	/** Open page using it's url*/
	public void open() {
		openURL(homePageURL);
	}
	
	/*Open ForgotPasswordPage by clicking on Forgot Password Link */
	public ForgotPasswordPage clickForgotPasswordLink() {
		find(forgotPasswordLinkLocator).click();
		return new ForgotPasswordPage(driver,log);
	}
	/*Open LoginPage  by clicking on Form Authentication Link*/
	public LoginPage clickFormAuthenticationLink() {
		find(formAuthenticationLinkLocator).click();
		return new LoginPage(driver, log);
	}
	
	

}
