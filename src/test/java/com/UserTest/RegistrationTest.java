package com.UserTest;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import avactis.pages.user.Login;
import avactis.pages.user.Registration;
import avactis.testbase.Testbase;

public class RegistrationTest extends Testbase {
	
	public static Logger log = Logger.getLogger(RegistrationTest.class.getName());

      Registration regostration;
      
      
      
      @BeforeMethod
      public void setup(){
    	  
    	  regostration = new Registration(driver);
      }
      @Test
      public void verifyValidation_Message(){
    	  extentTest = extent.createTest("verifyValidation_Message");
    	  extentTest.log(Status.INFO, "verifyValidation_Message");
    	  assertTrue(regostration.validateBlank_Form());
      }
}
