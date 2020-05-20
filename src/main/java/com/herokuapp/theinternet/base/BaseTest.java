package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected static WebDriver driver;
	protected Logger log;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	protected void setUp(@Optional("chrome") String browser, ITestContext ctx) {
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		

		// maximize browser window
		driver.manage().window().maximize();
		
		// implicit wait till an element should be searched ide DOM
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	protected void thearDown() {
		log.info("[Closing driver]");
		driver.quit();
	}

	// Static sleep method to see the test execution
	protected void sleep() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void getScreenshot(String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//test-output//screenshots//" + getTime() +fileName + ".jpeg";
		try {
			FileUtils.copyFile(srcFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* This method returns current time in "MMddyyyyHHmmss format " */
	private String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyyHHmmss");
		
		
		Date date = new Date();

		return formatter.format(date);

	}
	
	//Data provider
	@DataProvider(name="negativeLoginData")
	public  Object[][] negativeLoginData(){
		return new Object[][] {
			{"123wqer","SuperSecretPassword!","Your username is invalid!"},
			{"tomsmith","incorrectpass","Your password is invalid!"}
		};
		
	}
	
	public  List<LogEntry> getBrowserLogs(){
		LogEntries log= driver.manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}

}
