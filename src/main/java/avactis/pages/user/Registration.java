package avactis.pages.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import avactis.utilities.WaitFunction;

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
    List<WebElement> Country;
    
    @FindBy (xpath=("//select[@name='customer_info[Customer][State]']"))
    List<WebElement> State;
    
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
    
    
   
	@FindBy(xpath=("//button[contains(text(),'Register')]"))
	WebElement Sign_Register_Button;
    
    @FindBy (xpath ="//div[@class='subheader']//h3[contains(text(),'New Customers')]")
    WebElement NewCustomers_Title;
    
    @FindBy(xpath=("//a[@href='http://localhost/avactis/sign-in.php']"))
	WebElement Sign_In;
    
    @FindBy (xpath="//div[@class='registration_form']")
    List<WebElement> Message;
    
    
    
    public boolean validateBlank_Form(){
    	WaitFunction.waitForElementPresent(Sign_In, 10);
    	log.info("Try to click on Sign in button ");
    	Sign_In.click();
    	
    	WaitFunction.waitForElementPresent(Sign_Register_Button, 10);
    	Sign_Register_Button.click();
    	try{
    		
    		WaitFunction.waitForElementPresent(Register_Button, 10);
    		Register_Button.click();
    		
			for (WebElement errorMsg : Message){
    			String getmsg = errorMsg.getText();
    			
    			if (getmsg.equalsIgnoreCase("Invalid data in field 'First Name'.")){
    				
    				
    			}
    		}
    		
    	}catch (Exception e){
    		
    		e.printStackTrace();
    	}
		return true;
    	
    }



    public void 

	
    
}
