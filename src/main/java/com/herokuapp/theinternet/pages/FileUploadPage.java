package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.herokuapp.theinternet.base.BasePageObject;

public class FileUploadPage extends BasePageObject{

	private String URL = "https://the-internet.herokuapp.com/upload";
	
	private By chooseFile = By.id("file-upload");
	private By uploadButton = By.id("file-submit");
	private By uploadMessage = By.xpath("//h3[contains(text(),'File Uploaded!')]");
	
	
	public FileUploadPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void open() {
		log.info("Page is opened");
		openURL(URL);
	}
	
	public void clickChooseFile() {
		log.info("clicked choose file");
		find(chooseFile).click();
	}
	public void chooseFileForUpload(String filePath) {
		find(chooseFile).sendKeys(filePath);
	}
	
	public void clickUploadButton() {
		log.info("clicked upload button");
		find(uploadButton).click();
	}
	
	public void waitForMessage() {
		waitForVisibilityOf(uploadMessage, 5);
	}
	
	public String getTextAfterClickUpload() {
		return find(uploadMessage).getText();
	}
	
	

}
