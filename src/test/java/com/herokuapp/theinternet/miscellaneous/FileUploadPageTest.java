package com.herokuapp.theinternet.miscellaneous;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.FileUploadPage;

public class FileUploadPageTest extends BaseTest {
	
	@Test
	public void testUploadFile() {
		//Open URL
		FileUploadPage fu = new FileUploadPage(driver, log);
		fu.open();
		sleep();
		
		String filePath= System.getProperty("user.dir") + "//src//main//resources//test-upload.txt";
		
		//click choose file
		fu.chooseFileForUpload(filePath);
		//click upload
		
		
		fu.clickUploadButton();
		
		sleep();
		
		//wait for the successful message to appear on screen
		fu.waitForMessage();
		
		sleep();
		//verify if the message is correct
		String message = fu.getTextAfterClickUpload();
		Assert.assertTrue(message.contains("File Uploaded!"), "Expected message is not matched");
	}
	
	public void sleep() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
