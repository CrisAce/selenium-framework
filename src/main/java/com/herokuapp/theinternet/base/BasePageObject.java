package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject  {
	
	protected WebDriver driver;
	protected Logger log;
	
	public BasePageObject(WebDriver driver, Logger log) {
		this.driver=driver;
		this.log = log;
	}
	
	protected void openURL(String url) {
		log.info("Opening page:" + url );
		driver.get(url);
		log.info("Page opened");
	}
	
	protected WebElement find(By locatior) {
		return driver.findElement(locatior);
	}
	
	private void waitFor(ExpectedCondition<WebElement> conditions, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds:30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(conditions);
	}
	
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null ));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}
	protected void waitForPresenceOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.presenceOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null ));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}
	

}
