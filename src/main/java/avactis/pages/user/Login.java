package avactis.pages.user;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import avactis.testbase.Testbase;

public class Login   {

	
	protected WebDriver driver;
	public static Logger log = Logger.getLogger(Login.class.getName());
	
	public Login(WebDriver driver ){
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath =("//input[@id='account_sign_in_form_email_id']"))
	WebElement email;
	
	@FindBy(xpath=("//input[@id='account_sign_in_form_passwd_id']"))
	WebElement password;
	
	@FindBy(xpath=("//a[@href='http://localhost/avactis/sign-in.php']"))
	WebElement Sign_In;
   
	@FindBy(xpath=("//div[@class='note note-danger']"))
	WebElement Create_Account_msg;
	
	@FindBy(xpath=("//input[@type='submit']"))
	WebElement Login_Button;
	
	@FindBy(xpath=("//button[contains(text(),'Register')]"))
	WebElement Register_Button;
	
	/*@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		assertTrue(driver.getCurrentUrl().endsWith("avactis"));
	}*/
	
	public String errorMsg(){
		  String createAccount = Create_Account_msg.getText();
		  return errorMsg();
	}
	
	
	public boolean verifyLogin(String email, String password){
		
		try{
		Sign_In.click();
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		Login_Button.click();
		
            }catch(Exception e){
			         System.err.println(e);
		}
		if (driver.getCurrentUrl().endsWith("home.php")){
			return true;
		}else{
			
			System.out.println("Login Failed ");
			return false;
		}
		
	}
	
	
	public boolean verifyInvalidLogin(String emailid, String password){
		
		try{
			
			Sign_In.click();
			email.sendKeys(emailid);
			this.password.sendKeys(password);
			Login_Button.click();
			
		}catch (Exception e){
				System.err.println(e);
			}
			if (Create_Account_msg.isDisplayed()){
				return true;
			}	
			else{
				
				return false;
			}
		
}
	
	public boolean verifyPasswordMasking(String emailid,String Password){
		
		Sign_In.click();
		email.sendKeys(emailid);
		password.sendKeys(Password);
		if (password.getAttribute("type").equals("password")){
			return true;
			
		}else{
			return false;
		}
	}
	
	/*public Registration doregistartion(){
		Register_Button.click();
		
		return new Registration();
	}*/
	
	public Myaccount doSignIn(String emaild, String password){
		log.debug("Try to click on sign in button");
		Sign_In.click();
		email.sendKeys(emaild);
		this.password.sendKeys(password);
		Login_Button.click();
		if (Create_Account_msg.isDisplayed()){
			System.out.println("User Not Register Please Do Registration First");
			Register_Button.click();
		}else{
			System.out.println("Login Sucessfully ");
		}
		return new Myaccount();
	}
	

}
