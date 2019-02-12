package com.avactis.pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Viewcart {
	
	protected WebDriver driver;
	
	public Viewcart(WebDriver driver){
		
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
