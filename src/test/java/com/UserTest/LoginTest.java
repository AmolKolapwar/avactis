package com.UserTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import avactis.pages.user.Login;
import avactis.pages.user.Myaccount;
import avactis.pages.user.Registration;
import avactis.test.listener.TestListener;
import avactis.testbase.Testbase;

//@Listeners  (TestListener.class)
public class LoginTest extends Testbase {
	public static Logger log = Logger.getLogger(LoginTest.class.getName());
 
	Login login;
	
	
  @BeforeMethod
  public void pageSetup() {
	  
		login = new Login(driver);
  }

  
  @Test
  public void verifyValidLogin() {
	  extentTest = extent.createTest("verifyValidLogin");
	  extentTest.log(Status.INFO, "Verify Valid Login");
	assertTrue(login.verifyLogin("amol@test.com", "dfsf"));
 }
  
  @Test
  public void verifyInvalidLogin(){
	  extentTest = extent.createTest("verifyInvalidLogin");
	  assertTrue(login.verifyInvalidLogin("amol@test.com", "Testing"));
	  
	  
  }
  
  @Test 
  public void verifyPassword_Feild_Masking(){
	  extentTest = extent.createTest("verifyPassword_Feild_Masking");
	  extentTest.log(Status.INFO, "VerifyPassword Masking");
	  assertTrue(login.verifyPasswordMasking("amol@test.com", "Testijg"));
  }
  
  @Test 
  public void verifyUserLoggedIn(){
	  extentTest = extent.createTest("verifyUserLoggedIn");
	  extentTest.log(Status.INFO, "Verify User Logged In");

	  assertTrue(login.verifyLogin("amol@test.com", "Password$123"));
	  if (login.isUserLoggedIn()){
		  
		  assertEquals("Avactis Demo Store", driver.getTitle());
	  }else{
		  
		  System.out.println("User Not Logged In");
	  }
	  
  }
  

@Test
public void verifyNavigate_To_Ragistration(){
	
	extentTest = extent.createTest("verifyNavigate_To_Ragistration");
	extentTest.log(Status.INFO, "Verify Navigate To  Registration Page");
	login.verifyRegistrationButton();
	log.info("Verify Registration Page URL");
	assertTrue(driver.getCurrentUrl().endsWith("register.php"));
}





@AfterMethod
  public void afterMethod() {
	
	
  }

}
