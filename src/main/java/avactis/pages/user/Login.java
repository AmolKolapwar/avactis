package avactis.pages.user;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Login extends  LoadableComponent <Login> {

	
	protected WebDriver driver;
	public static Logger log = Logger.getLogger(Login.class.getName());
	
	public Login(WebDriver driver){
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =("//input[@id='account_sign_in_form_email_id']"))
	WebElement email;
	
	@FindBy(xpath=("//input[@id='account_sign_in_form_passwd_id']"))
	WebElement password;

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.
	}
	

}
