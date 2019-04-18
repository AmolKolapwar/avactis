package com.avactis.pages.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.avactis.utilities.WaitFunction;

public class Registration   {
	
	
	protected WebDriver driver;
	public static Logger log = Logger.getLogger(Registration.class.getName());

	public Registration(WebDriver driver) {
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath=("//input[@name='customer_info[Customer][Email]']"))
	WebElement Email;
	
    @FindBy(xpath=("//input[@name='customer_info[Customer][Password]']"))
    WebElement Password;
    
    @FindBy(xpath =("//input[@name='customer_info[Customer][RePassword]']"))
    WebElement	Re_TypePassword;
    
    @FindBy (xpath=("//input[@name='customer_info[Customer][FirstName]']"))
    WebElement FirstName;
    
    @FindBy (xpath= ("//input[@name='customer_info[Customer][LastName]']"))
    WebElement LastName;
    
    @FindBy(xpath=("//select[@name='customer_info[Customer][Country]']"))
    WebElement Country;
    
    @FindBy (xpath=("//select[@name='customer_info[Customer][State]']"))
    WebElement State;
    
    @FindBy(xpath=("//input[@name='customer_info[Customer][ZipCode]']"))
    WebElement ZipCode;
    
    @FindBy (xpath="//input[@name='customer_info[Customer][City]']")
    WebElement City;
    
    @FindBy(xpath="//input[@name='customer_info[Customer][Streetline1]']")
    WebElement Address1;
    
    @FindBy(xpath="//input[@name='customer_info[Customer][Streetline2]']")
    WebElement Address2;
    
    @FindBy(xpath = "//input[@name='customer_info[Customer][Phone]']")
    WebElement Phone;
    
    @FindBy(xpath="//input[@value='Register']")
    WebElement Register_Button;
     
    @FindBy (xpath ="//div[@class='subheader']//h3[contains(text(),'New Customers')]")
    WebElement NewCustomers_Title;
    
    @FindBy(xpath=("//a[@href='http://localhost/avactis/sign-in.php']"))
	WebElement Sign_In;
    
    @FindBy (xpath="//div[@class='registration_form']")
    List<WebElement> Message;
    
    @FindBy (xpath="//a[contains(@href,'register.php')]")
    WebElement Register;
    
    @FindBy(xpath="//div[@class='registration_form']//div")
    WebElement Already_MSG;
    
    @FindBy (xpath="//div[@class='note note-danger']")
   List <WebElement> errorMsg;
    
    public boolean validateBlank_Form(){
		
		log.info("Try to click on Register   button ");

		Register.click();
		try {
             log.info("Registratin Page Open");
			WaitFunction.waitForElementPresent(Register_Button, 10);
			Register_Button.click();

			for (WebElement errorMsg : Message) {
				String getmsg = errorMsg.getText();

				if (getmsg.equalsIgnoreCase("Invalid data in field 'First Name'.")) {

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;

	}

     public Registration navigatetoRegistationPage(){
    	 
     	Register.click();
     	return new Registration (driver);

     }

	public boolean addRegistrationDetails(RegistratingMethod registration) {

		log.info("Try To Add Basic Info");
		Email.sendKeys(registration.getEmail());
		Password.sendKeys(registration.getPassword());
		Re_TypePassword.sendKeys(registration.getRe_TypePassword());
		FirstName.sendKeys(registration.getFirstName());
		LastName.sendKeys(registration.getLastName());
		Select country = new Select(Country);

		country.selectByVisibleText(registration.getCountry());
		Select state = new Select(State);
		state.selectByVisibleText(registration.getState());
		ZipCode.sendKeys(registration.getZipCode());
		City.sendKeys(registration.getCity());
		Address1.sendKeys(registration.getAddress1());
		Address2.sendKeys(registration.getAddress2());
		Phone.sendKeys(registration.getPhone());
		Register_Button.click();

		if (driver.getCurrentUrl().endsWith("/home.php")) {
			System.out.println("Regstration Done Successfully");
			return true;

		} else if (Already_MSG.getText().equalsIgnoreCase("This account name is already taken. Please choose a different account name.")){
			System.out.println("Registration Failed Because User Already exist");
			return false;
		}else{
			log.info("Registration Failed");
			return false;
			
			
		}
			

	}

	
	public boolean verifyAllCountry(){
		
		Select country = new Select (Country);
		
		List<WebElement> country1 = driver.findElements(By.xpath("//select[@name='customer_info[Customer][Country]']"));
		
		for (WebElement cou :country1){
			System.out.println(cou.getText());
			System.out.println(cou.getSize());
			if (cou.getText().equalsIgnoreCase("India")){
				log.info("----------Country size and name match----------");
				return true;
			}else{
				
				System.out.println("-------------Faild---------------------");
			}
			return false;

		}
		return true;
	}
	
  
	public void verifyErrorMsg(RegistratingMethod registration){
		
		
		log.info("Try To Add Basic Info");
		Email.sendKeys(registration.getEmail());
		Password.sendKeys(registration.getPassword());
		Re_TypePassword.sendKeys(registration.getRe_TypePassword());
		FirstName.sendKeys(registration.getFirstName());
		LastName.sendKeys(registration.getLastName());
		Select country = new Select(Country);

		country.selectByVisibleText(registration.getCountry());
		Select state = new Select(State);
		state.selectByVisibleText(registration.getState());
		ZipCode.sendKeys(registration.getZipCode());
		City.sendKeys(registration.getCity());
		Address1.sendKeys(registration.getAddress1());
		Address2.sendKeys(registration.getAddress2());
		Phone.sendKeys(registration.getPhone());
		Register_Button.click();

	   
		for (WebElement message : errorMsg){
			
			
		
		System.out.println(message.getText());
	
		if (message.equals("The password you entered is incorrect. Please enter the correct password.") && message.equals("Invalid data in field 'First Name'.") && message.equals("Invalid data in field 'Last Name'.") && message.equals("Invalid data in field 'E-mail'.") ){
			
			//Assert.assertEquals(errormsg, "The password you entered is incorrect. Please enter the correct password.");
			System.out.println("Message dispaly for incorret password");
		/*}else if (message.equals("Invalid data in field 'E-mail'.")){
			
			System.out.println("Message display for invalid  email");
			
		}else if (message.equals("Invalid data in field 'Last Name'.") && message.equals("Invalid data in field 'First Name'.")){
			System.out.println("Message dispalyed for invalid last name");
			*/
		}else {
			
			System.out.println("Message not dispalyed proper ");
		}
		}
		
	}
	
}
