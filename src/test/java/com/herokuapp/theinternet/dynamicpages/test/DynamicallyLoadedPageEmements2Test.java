package com.herokuapp.theinternet.dynamicpages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.DynamicallyLoadedElementsPage;

public class DynamicallyLoadedPageEmements2Test extends BaseTest {
	
	
	@Test(priority=1)
	public void testDynamicLoad() {
		//Open URL
		DynamicallyLoadedElementsPage page = new DynamicallyLoadedElementsPage(driver, log);
		page.open();
		
		//Click Start Button
		page.clickStartButton();
		
		//wait for loading element is done
		page.waitForMessageToAppear();
		
		//Verify if message after load is correct
		String message = page.getTextAfterWait();
		Assert.assertTrue(message.contains("Hello World!"), "Message is not correct");
	}

}
