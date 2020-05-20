package com.herokuapp.theinternet.dynamicpages.test;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.StaleElementsPage;

public class StaleElementsPageTest extends BaseTest {

	@Test
	public void testStaleElement() {
		// open page
		StaleElementsPage page = new StaleElementsPage(driver, log);
		page.open();
		
		// click on Link Text
		for(int i =0; i<4;i++) {
			page.clickLink();
			String message =page.retriveMessage();
			log.info(message);
		}
		
		

		// waiting for message
		page.waitForMessage();
		
		// get and print message
		
		
	}

}
