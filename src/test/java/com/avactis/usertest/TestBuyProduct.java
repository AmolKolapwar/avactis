package com.avactis.usertest;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.user.Cart;
import com.avactis.pages.user.Checkout;
import com.avactis.pages.user.SearchPage;
import com.avactis.testbase.Testbase;
import com.aventstack.extentreports.Status;

public class TestBuyProduct  extends Testbase{
	
public static Logger log = Logger.getLogger(TestBuyProduct.class.getName());

 Cart cart;
 SearchPage  searchproduct;
 Checkout checkout;
 
 @BeforeMethod
 
 public  void pagesetup(){
	 
	 cart = new Cart(driver);
	 checkout  = new Checkout(driver);
	 searchproduct = new SearchPage(driver);
 }
 

  @Test  

public void selctItemVerfiyCart(){

	  
	  extentTest = extent.createTest("selctItemVerfiyCart");
	  extentTest.log(Status.INFO, "selctItemVerfiyCart");
	  searchproduct.selectProduct("DVD", "Classic Films", "Forbidden Planet");
	  
	 // searchproduct.selectProduct("DVD", "Classic Films", "James Bond Ultimate Collect ...");
	  cart.goToViewCart();
	  cart.get();
	  cart.verifyProductquntity();
	  
	  cart.gotoCheckoutPage();
	  checkout.checkout();
}
   
}