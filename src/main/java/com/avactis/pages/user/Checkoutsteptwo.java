package com.avactis.pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Checkoutsteptwo {
	protected WebDriver driver;
	
	public Checkoutsteptwo(WebDriver driver){
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

}
