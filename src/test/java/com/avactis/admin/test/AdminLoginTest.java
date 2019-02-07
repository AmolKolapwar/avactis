package com.avactis.admin.test;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.admin.AdminLogin;
import com.avactis.testbase.Testbase;
import com.aventstack.extentreports.Status;

public class AdminLoginTest  extends Testbase{
	public static Logger log = Logger.getLogger(AdminLoginTest.class.getName());
	AdminLogin adminlogin;
	
	
	@BeforeMethod
	public void setup(){
		adminlogin= new AdminLogin(driver);
	}
	
	
	
	@Test
	public void verifyLogin_PageUI(){
		  extentTest = extent.createTest("verifyLogin_PageUI");
		  extentTest.log(Status.INFO, "verifyLogin_PageUI");
		  adminlogin.get();
		  assertTrue(adminlogin.verifyLoginPage_UI());
	}
	
	
	@Test
	public void verify_InvalidLogin(){
		
		extentTest = extent.createTest("verify_InvalidLogin");
		extentTest.log(Status.INFO, "verify_InvalidLogin");
		assertTrue(adminlogin.invalidLogin("amol@testing.com", "testing"));

	}
	
	
	@Test
	public void verify_ValidLogin(){
		
		extentTest = extent.createTest("verify_ValidLogin");
		extentTest.log(Status.INFO, "verify_ValidLogin");
		adminlogin.validLogin("amol@test.com", "amol_123");
		assertTrue(driver.getCurrentUrl().endsWith("/index.php"),"Faild to load");
	}

}
