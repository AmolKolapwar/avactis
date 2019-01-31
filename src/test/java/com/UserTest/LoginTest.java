package com.UserTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import avactis.pages.user.Login;
import avactis.pages.user.Myaccount;
import avactis.testbase.Testbase;
import avactis.utilities.TestListener;
@Listeners  (TestListener.class)
public class LoginTest extends Testbase {
	public static Logger log = Logger.getLogger(LoginTest.class.getName());
 
	Login login;
	
	
  @BeforeMethod
  public void pageSetup() {
	  
		login = new Login(driver);
  }

  
  @Test
  public void verifyValidLogin() {
	  
	assertTrue(login.verifyLogin("amol@test.com", "dfsf"));
 }
  
  @Test
  public void verifyInvalidLogin(){
	  
	  assertTrue(login.verifyInvalidLogin("amol@test.com", "Testing"));
	  
	  
  }
  
  @Test 
  public void verifyPassword_Feild_Masking(){
	  
	  assertTrue(login.verifyPasswordMasking("amol@test.com", "Testijg"));
  }
  
  @Test 
  public void verifyUserLoggedIn(){
	  assertTrue(login.verifyLogin("amol@test.com", "Password$123"));
	  if (login.isUserLoggedIn()){
		  
		  assertEquals("Avactis Demo Store", driver.getTitle());
	  }else{
		  
		  System.out.println("User Not Logged In");
	  }
	  
  }
  





@AfterMethod
  public void afterMethod() {
	
	
  }

}
