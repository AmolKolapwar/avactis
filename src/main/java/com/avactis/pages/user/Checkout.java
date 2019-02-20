package com.avactis.pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.utilities.FileManager;

import bsh.util.JConsole.BlockingPipedInputStream;

public class Checkout {

	protected WebDriver driver;
	
	
	public Checkout (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	
	@FindBy(name="billingInfo[Firstname]")
	WebElement billingFirstName;
	
	@FindBy (name="billingInfo[Lastname]")
	WebElement billingLastName;
	
	@FindBy(name="billingInfo[Email]")
	WebElement billingEmail;
	
	@FindBy (name="billingInfo[Postcode]")
	WebElement billingPostCode;
	
	@FindBy(name="billingInfo[City]")
	WebElement billingCity;
	
	@FindBy (name="billingInfo[Streetline1]")
	WebElement billingAddress;
	
	@FindBy(name="billingInfo[Phone]")
	WebElement billingPhone;
	
	@FindBy(name="billingInfo[Statemenu]")
	WebElement billingState;
	
	@FindBy (name="billingInfo[Country]")
	WebElement billingContry;
	
	@FindBy(xpath="//input[@name='checkbox_shipping_same_as_billing']")
    WebElement SameAddress;
	
	@FindBy (xpath="//div[@class='checkout_buttons']/input[@class='en btn btn-primary button_continue_checkout']")
	WebElement continuebutton;
	
	public void addbillingAddress(){
		billingFirstName.sendKeys(FileManager.prjprop.getProperty("FirstName"));
		billingLastName.sendKeys(FileManager.prjprop.getProperty("LastName"));
		billingEmail.sendKeys(FileManager.prjprop.getProperty("Email"));
		billingContry.sendKeys(FileManager.prjprop.getProperty("Country_b"));
		billingCity.sendKeys(FileManager.prjprop.getProperty("City_b"));
		billingState.sendKeys(FileManager.prjprop.getProperty("State_b"));
		billingPostCode.sendKeys(FileManager.prjprop.getProperty("Postcode"));
		billingPhone.sendKeys(FileManager.prjprop.getProperty("Phone"));
		billingAddress.sendKeys(FileManager.prjprop.getProperty("Address"));
		
	}
	
	public void addShipingAddress(){
		
		SameAddress.click();
	}
	
	public Checkoutsteptwo checkout(){
    
		addbillingAddress();
		addShipingAddress();
		
		continuebutton.click();
		return new Checkoutsteptwo(driver);
	}
	
	
	
	
}
