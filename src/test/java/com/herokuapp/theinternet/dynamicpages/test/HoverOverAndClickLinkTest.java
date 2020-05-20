package com.herokuapp.theinternet.dynamicpages.test;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.HoverOverAndClickLink;

public class HoverOverAndClickLinkTest extends BaseTest {

	
	@Test
	public void testHoveAndClickLink() {
		HoverOverAndClickLink page = new HoverOverAndClickLink(driver, log);
		page.open();
		
		page.hoverOverAvatar();
		
		page.clickLinkAfterHover();
		
	}
	
	
	
}
