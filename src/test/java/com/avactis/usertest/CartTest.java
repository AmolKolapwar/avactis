package com.avactis.usertest;

import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.user.Cart;
import com.avactis.testbase.Testbase;
import com.aventstack.extentreports.Status;

public class CartTest extends Testbase{
	
	public static Logger log = Logger.getLogger(CartTest.class.getName());
	
	Cart carttest;
	
	
	@BeforeMethod
	
	public void pagesteup(){
		
		carttest = new Cart(driver);
	}
	
	
	
	@Test 
	public void verifyCardItem(){
		
		  extentTest = extent.createTest("verifyCardItem");
		  extentTest.log(Status.INFO, "verifyCardItem");
		  carttest.goToViewCart();
		  
	}
}
