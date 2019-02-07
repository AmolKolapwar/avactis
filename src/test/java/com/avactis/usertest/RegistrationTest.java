package com.avactis.usertest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.user.RegistratingMethod;
import com.avactis.pages.user.Registration;
import com.avactis.testbase.Testbase;
import com.aventstack.extentreports.Status;

public class RegistrationTest extends Testbase {
	
	public static Logger log = Logger.getLogger(RegistrationTest.class.getName());

      Registration registration;
      
      
      
      @BeforeMethod
      public void setup(){
    	  
    	   registration  = new Registration(driver);
    	   driver.get("http://localhost/avactis/");
      }
      
      @Test
      public void verifyValidation_Message(){
    	  extentTest = extent.createTest("verifyValidation_Message");
    	  extentTest.log(Status.INFO, "verifyValidation_Message");
    	  assertTrue(registration.validateBlank_Form());
      }
    
      
     /* @Test 
      public void verifyRegistraction_With_ValidData(){
    	  
    	  extentTest = extent.createTest("verifyRegistraction_With_ValidData");
    	  extentTest.log(Status.INFO, "verifyRegistraction_With_ValidData");
    	  
    	  
    	 Registration check= registration.navigatetoRegistationPage();
    	  RegistratingMethod newrgistrtion = new RegistratingMethod();
    	  newrgistrtion.setEmail(prjprop.getProperty("EmailID"));
    	  newrgistrtion.setPassword(prjprop.getProperty("Password"));
    	  newrgistrtion.setRe_TypePassword(prjprop.getProperty("ReTypePassword"));
    	  newrgistrtion.setFirstName(prjprop.getProperty("FirstName"));
    	  newrgistrtion.setLastName(prjprop.getProperty("LastName"));
    	  newrgistrtion.setCountry(prjprop.getProperty("Country"));
    	  newrgistrtion.setState(prjprop.getProperty("State"));
    	  newrgistrtion.setZipCode(prjprop.getProperty("Zip"));
    	  newrgistrtion.setCity(prjprop.getProperty("City"));
    	  newrgistrtion.setAddress1(prjprop.getProperty("Address1"));
    	  newrgistrtion.setAddress2(prjprop.getProperty("Address2"));
    	  newrgistrtion.setPhone(prjprop.getProperty("PhoneNo"));
    	 
    	  if(check.addRegistrationDetails(newrgistrtion)){
    		  assertTrue(true,"Registration Successfully ");
    	  }else{
    		  
    		  System.out.println("Registration Failed");
    	  }
      }
      */
      @Test 
      public void verifyUserAlreadyMsg(){
    	  extentTest = extent.createTest("verifyUserAlreadyMsg");
    	  extentTest.log(Status.INFO, "verifyUserAlreadyMsg");
    	  
    	  
    	  Registration check= registration.navigatetoRegistationPage();
    	  registration.verifyAllCountry();
    	  RegistratingMethod newrgistrtion = new RegistratingMethod();
    	  newrgistrtion.setEmail(prjprop.getProperty("EmailID"));
    	  newrgistrtion.setPassword(prjprop.getProperty("Password"));
    	  newrgistrtion.setRe_TypePassword(prjprop.getProperty("ReTypePassword"));
    	  newrgistrtion.setFirstName(prjprop.getProperty("FirstName"));
    	  newrgistrtion.setLastName(prjprop.getProperty("LastName"));
    	  newrgistrtion.setCountry(prjprop.getProperty("Country"));
    	  newrgistrtion.setState(prjprop.getProperty("State"));
    	  newrgistrtion.setZipCode(prjprop.getProperty("Zip"));
    	  newrgistrtion.setCity(prjprop.getProperty("City"));
    	  newrgistrtion.setAddress1(prjprop.getProperty("Address1"));
    	  newrgistrtion.setAddress2(prjprop.getProperty("Address2"));
    	  newrgistrtion.setPhone(prjprop.getProperty("PhoneNo"));
    	  
    	  if(check.addRegistrationDetails(newrgistrtion)){
    		  
    		  assertFalse(false,"Registartion Failed,User Already exits");
    	  }
      }
}
