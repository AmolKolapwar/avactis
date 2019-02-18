package com.avactis.usertest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.user.Checkout;
import com.avactis.testbase.Testbase;

public class CheckoutTest  extends Testbase{
	
	public static Logger log = Logger.getLogger(CheckoutTest.class.getName());
	
	 Checkout checkout;
	
	@BeforeMethod
	public void pagesetup(){
		
		checkout = new Checkout(driver);
	}
	
	
	@Test 
	public void fillingBillingAddress(){
		
		
	}

}
