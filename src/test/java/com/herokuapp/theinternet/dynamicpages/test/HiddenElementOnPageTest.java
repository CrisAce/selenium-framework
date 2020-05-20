package com.herokuapp.theinternet.dynamicpages.test;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.HiddenElementOnPage;

public class HiddenElementOnPageTest extends BaseTest {
	
	@Test
	public void testHiddenEmenet() {
		//Open URL
		HiddenElementOnPage page = new HiddenElementOnPage(driver, log);
		page.open();
		
		//Is click button display?
		System.out.println(page.clickIsVisible());
		
		//Click start button
		page.clickStartBtn();
		
		//wait for the Visibility of text
		page.waitForVisibilityOfText();
		
		//get text after element is visible
		String message =page.getTextAfterWait();
		System.out.println(message);
		
		System.out.println(page.clickIsVisible());
	}

}
