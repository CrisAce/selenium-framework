package com.herokuapp.theinternet.login.test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;

public class PositiveLoginTest extends BaseTest  {

	@Test(priority = 1)
	@Parameters({"username","password"})
	public void logInTest(String username, String password) {

		SoftAssert soft = new SoftAssert();
		// Open Home Page
		HomePage home = new HomePage(driver, log);
		home.open();

		// Click Form Authentication
		LoginPage loginPage = home.clickFormAuthenticationLink();

		// Wait for the page to load
		loginPage.waitForLoginPageToLoad();

		// Execute Positive Login
		SecureAreaPage secureAriaPage = loginPage.login(username, password );

		// Wait for success message
		secureAriaPage.waitForSecureAriaPageToLoad();

		String message = secureAriaPage.getMessageText();

		soft.assertTrue(message.contains("You logged into a secure area!"), "Message doesn't contain expected text");
		soft.assertAll();

	}

}
