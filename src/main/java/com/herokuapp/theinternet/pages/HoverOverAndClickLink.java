package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.herokuapp.theinternet.base.BasePageObject;

public class HoverOverAndClickLink extends BasePageObject{
	
	private String URL="https://the-internet.herokuapp.com/hovers";
	private By picture = By.xpath("/html//div[@id='content']/div/div[1]/img[@alt='User Avatar']");
	private By link = By.xpath("//div[@class='example']//div[1]//div[1]//a[1]");

	public HoverOverAndClickLink(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void open() {
		openURL(URL);
	}
	
	
	
	public void hoverOverAvatar() {
		WebElement pictureHover =find(picture);
		Actions action = new Actions(driver);
		action.moveToElement(pictureHover).build().perform();
	}
	
	public void clickLinkAfterHover() {
		WebElement clickAfterHovePicutre = find(link);
		Actions action = new Actions(driver);
		action.moveToElement(clickAfterHovePicutre).click().build().perform();
		
	}
	
	
	

}
