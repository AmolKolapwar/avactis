package avactis.pages.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration  {
	protected WebDriver driver;
	
	

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
    
    
}
