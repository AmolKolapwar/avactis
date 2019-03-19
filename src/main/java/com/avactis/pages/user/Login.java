package com.avactis.pages.user;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.utilities.WaitFunction;

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
	
	@FindBy(xpath=("//a[@href='http://localhost/Avactis/sign-in.php']"))
	WebElement Sign_In;
   
	@FindBy(xpath=("//div[@class='note note-danger']"))
	WebElement Create_Account_msg;
	
	@FindBy(xpath=("//input[@type='submit']"))
	WebElement Login_Button;
	
	@FindBy(xpath=("//button[contains(text(),'Register')]"))
	WebElement Register_Button;
	
	@FindBy(xpath=("//span//a[contains(text(),'Sign Out')]"))
	WebElement Sign_Out;
	 
     @FindBy (xpath ="//div[@class='subheader']//h3[contains(text(),'New Customers')]")
	 WebElement NewCustomers_Title;
	
     
     @FindBy (xpath="//a[contains(@href,'register.php')]")
     WebElement Register;
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
	
	public boolean isUserLoggedIn(){
		try {

			if (WaitFunction.waitForElementPresent(Sign_Out, 5)) {

				log.debug("User is logged in");
				Sign_Out.click();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.debug("User is not logged in");
		return false;
	}
		
	
	
	public   Registration verifyRegistrationButton(){
		boolean flag;
		try{
		log.debug("Try to click on sing in button ");
		Sign_In.click();
		if (NewCustomers_Title.isDisplayed() && Register_Button.isDisplayed()){
			
			Register_Button.click();
			flag = true;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}return new Registration(driver);
		
		
	}
	
	
	public Registration doRegistaration(){
		
		if(Register.isDisplayed() && Register.isEnabled() ){
			Register.click();
		} 
		return new Registration (driver);
	}
	
	
	
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
			System.out.println("Login Sucessfully");
		}
		return new Myaccount();
	}
	
	
	
	public void verifyActiveURL() throws IOException{
		
		List <WebElement> links  = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Size of all links :" + links.size());

		List<WebElement> activelink = new ArrayList<WebElement>();
		
		for (int i = 0; i < links.size(); i++) {

			if (links.get(i).getAttribute("href") != null) {
				activelink.add(links.get(i));
				
				System.out.println("Print the active link only :" + activelink.size());

				for (int j = 0; j < activelink.size(); j++) {

					HttpsURLConnection conection = (HttpsURLConnection) new URL(activelink.get(j).getAttribute("href")).openConnection();
					conection.connect();
					String message = conection.getResponseMessage();
					conection.disconnect();

					System.out.println(activelink.get(j).getAttribute("href") + "---" + message);
				}

			}
		}
	}

}
