package com.avactis.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	protected WebDriver driver;

	
	
	
	public AdminHomePage(WebDriver driver ){
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
