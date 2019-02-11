package com.avactis.pages.admin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.avactis.utilities.WaitFunction;

public class ForgotPassword extends LoadableComponent<ForgotPassword>{
	
	protected WebDriver driver;
	
	public static Logger log = Logger.getLogger(ForgotPassword.class.getName());
	
	public ForgotPassword(WebDriver driver ){
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath=("//input[@class='form-control placeholder-no-fix']"))
	WebElement ForgotPassLable;
	
	@FindBy(xpath=("//button[@class='btn blue pull-right']"))
	WebElement Submit;
	
	@FindBy (xpath=("//a[@id='forget-password']"))
	WebElement ForgotpasswordButton;
	
	
	@FindBy (xpath=("//p[contains(text(),'A new password has been sent to the e-mail address you ')]"))
	WebElement SuccessMSG;
	
	@FindBy (xpath=("//span[@class='required']"))
	WebElement ErrorMsg;
	
	
	@FindBy(xpath=("//a[contains(text(),'Continue')]"))
	WebElement Continue;
	
	public boolean verifyForgotPasswordPage_UI(){
		boolean flag2 = false;
         log.info("Stroe All Page Element in List ");
		List<WebElement> ElementsList = driver.findElements(By.tagName("body"));

		String[] tempList = ElementsList.get(0).getText().split("\n");
		List<String> expectedResult = new ArrayList<String>();
    
	
		log.info("Stroe Expected Result in List");
		expectedResult.add("Sign In");
		expectedResult.add("Remember me");
		expectedResult.add("Sign In");
		expectedResult.add("Forgot your password ?");
		expectedResult.add("no worries, click here to reset your password.");
		expectedResult.add("© 2004-2019 Avactis. All Rights Reserved.");
		expectedResult.add("4.8.0 AVACTIS-NEXT, build 48000");

		for (int k = 0; k < expectedResult.size(); k++) {
			Boolean flag = false;
			for (int i = 0; i < tempList.length; i++) {

				if (tempList[i].equalsIgnoreCase(expectedResult.get(k))) {
					System.out.println(tempList[i]);
					System.out.println(expectedResult.get(k));
					assertEquals(tempList[i], expectedResult.get(k));
					flag = true;
					log.info("---------List commapre-------------- ");
					break;
                 
				}

			}
			if (!flag) {
				System.out.println("Not Found " + expectedResult.get(k));
			}
			flag2 = flag;

		}
		return flag2;
	}

		
	
	public void verifyerrorMSG(String email) {

		ForgotpasswordButton.click();
		log.info("navigate to forgot password page");

		WaitFunction.waitForElementPresent(ForgotPassLable, 10);

		try {
			ForgotPassLable.clear();
			ForgotPassLable.sendKeys(email);
			ForgotpasswordButton.click();

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (ErrorMsg.isDisplayed()) {

			System.out.println("Errro Message Dispalyed ");
		} else {
			System.out.println("Message Not Displayed");

		}

	}
		public boolean verifyForgotPassword(String email){
			
			
			ForgotpasswordButton.click();
			log.info("navigate to forgot password page");
			
			WaitFunction.waitForElementPresent(ForgotPassLable, 10);
			ForgotPassLable.clear();
			ForgotPassLable.sendKeys(email);
			if (ForgotpasswordButton.isDisplayed()){
				log.info("Forgot Password Button disable");
				ForgotpasswordButton.click();
				SuccessMSG.isDisplayed();
                return true;
			}else{
				
				System.out.println("Forgot Password Failed");
			}return false;
		}
		

		
		 public AdminLogin clickOnContinue(){
			 
			 Continue.click();
			 return new AdminLogin(driver);
		 }



		@Override
		protected void load() {
			// TODO Auto-generated method stub
			
		}



		@Override
		protected void isLoaded() throws Error {
			// TODO Auto-generated method stub
			
			assertTrue(ForgotPassLable.isDisplayed());
		}
}
