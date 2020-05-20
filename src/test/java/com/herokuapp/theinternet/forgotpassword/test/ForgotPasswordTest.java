package com.herokuapp.theinternet.forgotpassword.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BasePageObject;
import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.EmailSentPage;
import com.herokuapp.theinternet.pages.ForgotPasswordPage;
import com.herokuapp.theinternet.pages.HomePage;

public class ForgotPasswordTest extends BaseTest {

	@Test(priority = 1)
	public void forgotPasswordTest() {

		// Open URL
		HomePage homePage = new HomePage(driver, log);
		homePage.open();

		// Click Forgot Password link from the home page
		ForgotPasswordPage forgotPassPage = homePage.clickForgotPasswordLink();

		// wait for the retrive button ewo
		forgotPassPage.waitForForgotPasswordPageToLoad();

		// Insert email and click retrive password
		 EmailSentPage confirmMailReceivedPage = forgotPassPage.executeRetrivePassword("cristi.ion21@gmail.com");
		 

		// wait for email sent page to load
		confirmMailReceivedPage.waitForEmailSentPageToLoad();
		getScreenshot("TestExecuteRetrivePassword");
		
		String message = confirmMailReceivedPage.getMessageText();

		Assert.assertTrue(message.contains("Your e-mail's been sent!"), "Message is not the correct one");

	}

}
