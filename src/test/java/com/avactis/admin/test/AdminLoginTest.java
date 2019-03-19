package com.avactis.admin.test;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.admin.AdminHomePage;
import com.avactis.pages.admin.AdminLogin;
import com.avactis.testbase.Testbase;
import com.aventstack.extentreports.Status;

public class AdminLoginTest  extends Testbase{
	public static Logger log = Logger.getLogger(AdminLoginTest.class.getName());
	AdminLogin adminlogin;
	AdminHomePage adminhome;
	
	@BeforeMethod
	public void setup(){
		adminlogin= new AdminLogin(driver);
		adminhome = new AdminHomePage(driver);
	}
	
	
	
	@Test
	public void verifyLogin_PageUI(){
		  extentTest = extent.createTest("verifyLogin_PageUI");
		  extentTest.log(Status.INFO, "verifyLogin_PageUI");
		  adminlogin.get();
		  assertTrue(adminlogin.verifyLoginPage_UI());
	}
	
	
	/*@Test
	public void verify_InvalidLogin(){
		
		extentTest = extent.createTest("verify_InvalidLogin");
		extentTest.log(Status.INFO, "verify_InvalidLogin");
		assertTrue(adminlogin.invalidLogin("amol@testing.com", "testing"));

	}
	*/
	
	@Test (priority =1)
	public void verify_ValidLogin(){
		
		extentTest = extent.createTest("verify_ValidLogin");
		extentTest.log(Status.INFO, "verify_ValidLogin");
		adminlogin.validLogin("amol@test.com", "amol_123");
		assertTrue(driver.getCurrentUrl().endsWith("/index.php"),"Faild to load");
	}
	
	
	/*@Test 
	public void  verifyRememberMe_clickable(){
		extentTest = extent.createTest("verifyRememberMe_clickable");
		extentTest.log(Status.INFO, "verifyRememberMe_clickable");
		assertTrue(adminlogin.verifyRememberMeClickable());
	}
	
	
	@Test 
	public void verifyForgotPass_Navigation(){
		extentTest = extent.createTest("verifyForgotPass_Navigation");
		extentTest.log(Status.INFO, "verifyForgotPass_Navigation");
		adminlogin.verifyForgotPasswordlink();
		log.info("verify the current page URL");
		assertTrue(driver.getCurrentUrl().endsWith("/signin_password_recovery.php"));
		
	}*/
	
	@Test(priority =2)
	public void table() throws InterruptedException{
		extentTest = extent.createTest("table");
		extentTest.log(Status.INFO, "table");
		adminhome.Order();
		
	}

}
