package com.avactis.usertest;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.user.Cart;
import com.avactis.pages.user.Checkout;
import com.avactis.pages.user.Checkoutsteptwo;
import com.avactis.pages.user.CheckpoutFinalPage;
import com.avactis.pages.user.ConfirmationPage;
import com.avactis.pages.user.SearchPage;
import com.avactis.testbase.Testbase;
import com.aventstack.extentreports.Status;

public class CartTest extends Testbase{
	
	public static Logger log = Logger.getLogger(CartTest.class.getName());
	
	Cart carttest;
	
	 SearchPage  searchproduct;
	 Checkout checkout;
	 Checkoutsteptwo checkout_two;
	 CheckpoutFinalPage finalpage;
	 ConfirmationPage message;
	
	@BeforeMethod
	
	public void pagesteup(){
		
		 carttest = new Cart(driver);
		 checkout  = new Checkout(driver);
		 searchproduct = new SearchPage(driver);
		 checkout_two = new Checkoutsteptwo(driver);
		 finalpage = new CheckpoutFinalPage(driver);
		 message = new ConfirmationPage(driver);
		 searchproduct.selectProduct("DVD", "Classic Films", "Forbidden Planet");
		 carttest.goToViewCart();
	}
	
	
	
	@Test 
	public void verifyCardItem(){
		  extentTest = extent.createTest("verifyCardItem");
		  extentTest.log(Status.INFO, "verifyCardItem");
		  carttest.goToViewCart();
		  
	}
	
	
	
	@Test
	public void enterInvalidCoupan(){
		
		  extentTest = extent.createTest("enterInvalidCoupan");
		  extentTest.log(Status.INFO, "enterInvalidCoupan");
		  carttest.verifyApplycoupanWithInvalidData("Testing");
		  
	}
}
