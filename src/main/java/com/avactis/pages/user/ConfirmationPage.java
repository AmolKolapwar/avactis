package com.avactis.pages.user;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.utilities.WaitFunction;

public class ConfirmationPage {
	
	protected WebDriver driver;
	public static Logger log = Logger.getLogger(ConfirmationPage.class.getName());

	
	
	@FindBy (xpath="//div[@class='note note-success note-bordered']")
	WebElement Confirmation_Message;
	
	
	public ConfirmationPage(WebDriver driver) {
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void message(){
		WaitFunction.waitForElementPresent(Confirmation_Message, 10);
		Confirmation_Message.getText();
		System.out.println("---------------------:" + Confirmation_Message.getText());
		
	}

}
  