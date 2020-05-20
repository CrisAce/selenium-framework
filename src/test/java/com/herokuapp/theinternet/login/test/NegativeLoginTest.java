package com.herokuapp.theinternet.login.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BasePageObject;
import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.base.CsvDataProvider;
import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.LoginPage;

public class NegativeLoginTest extends BaseTest {

	@Test(dataProvider = "negativeLoginData")
	public void incorrectUsenameTest(String username, String password, String expectedErrorMessage) {

		// Open Login page directly
		LoginPage loginPage = new LoginPage(driver,log);
		loginPage.open();

		// wait for the authentication page to load
		loginPage.waitForLoginPageToLoad();

		// Execute negative login
		loginPage.negativeLogin(username, password);

		// wait for the error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		Assert.assertTrue(message.contains(expectedErrorMessage),
				"Actual and expected error messages are different. \nExpected: " + expectedErrorMessage + "\nActual:"
						+ message);

	}

	@Test(dataProvider ="CsvDataProvider",dataProviderClass= CsvDataProvider.class)
	public void incorrectPasswordTest(Map<String, String> testData) {
		
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage=testData.get("expectedError");

		// Open Login page directly
		LoginPage loginPage = new LoginPage(driver,log);
		loginPage.open();

		// wait for the authentication page to load
		loginPage.waitForLoginPageToLoad();

		// Execute negative login
		loginPage.negativeLogin(username, password);

		// wait for the error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text");

	}

}
