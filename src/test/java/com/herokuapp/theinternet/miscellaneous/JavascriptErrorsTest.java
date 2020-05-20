package com.herokuapp.theinternet.miscellaneous;

import java.util.List;

import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.JacascriptErrorsPage;

public class JavascriptErrorsTest extends BaseTest {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void testJavascriptErrors() {
		JacascriptErrorsPage page = new JacascriptErrorsPage(driver,log);
		
		
		page.openURL();
		
		
		//Verify if there are no javascript errors
		List<LogEntry> logs = getBrowserLogs();
		log.info("Logs:" + logs );
		
		for(LogEntry log : logs) {
			if(log.getLevel().toString().equals("SEVER")) {
				softAssert.fail("Sever error:" + log.getMessage());
			}
		}
		softAssert.assertAll();
		getScreenshot("JavascriptLogs");
	}

}
