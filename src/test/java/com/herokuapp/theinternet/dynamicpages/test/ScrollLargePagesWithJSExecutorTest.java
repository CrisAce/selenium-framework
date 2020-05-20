package com.herokuapp.theinternet.dynamicpages.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.ScrollLargePagesWithJSExecutor;

public class ScrollLargePagesWithJSExecutorTest extends BaseTest {
	
	@Test
	public void testScroll() {
		//open URL
		ScrollLargePagesWithJSExecutor page = new ScrollLargePagesWithJSExecutor(driver, log);
		page.open();
		sleep(3000);
		
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		jsExecutor.executeScript("arguments[0].scrollIntoView();", page.scrollToTable());
		sleep(3000);
	}
	
	
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
