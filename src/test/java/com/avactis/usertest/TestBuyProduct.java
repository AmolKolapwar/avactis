package com.avactis.usertest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.user.Cart;
import com.avactis.pages.user.Checkout;
import com.avactis.pages.user.Checkoutsteptwo;
import com.avactis.pages.user.CheckpoutFinalPage;
import com.avactis.pages.user.SearchPage;
import com.avactis.testbase.Testbase;
import com.aventstack.extentreports.Status;

public class TestBuyProduct  extends Testbase{
	
public static Logger log = Logger.getLogger(TestBuyProduct.class.getName());

 Cart cart;
 SearchPage  searchproduct;
 Checkout checkout;
 Checkoutsteptwo checkout_two;
 CheckpoutFinalPage finalpage;
 @BeforeMethod
 
 public  void pagesetup(){
	 
	 cart = new Cart(driver);
	 checkout  = new Checkout(driver);
	 searchproduct = new SearchPage(driver);
	 checkout_two = new Checkoutsteptwo(driver);
	 finalpage = new CheckpoutFinalPage(driver);
 }
 

  @Test  

public void selctItemVerfiyCart() throws InterruptedException{

	  
	  extentTest = extent.createTest("selctItemVerfiyCart");
	  extentTest.log(Status.INFO, "selctItemVerfiyCart");
	  searchproduct.selectProduct("DVD", "Classic Films", "Forbidden Planet");
	  
	 searchproduct.selectProduct("DVD", "Classic Films", "James Bond Ultimate Collect ...");
	  cart.goToViewCart();
	  cart.get();
	  cart.verifyProductquntity();
	  cart.verifyTotalAmount();
	  cart.gotoCheckoutPage();
	  checkout.checkout();
	  Thread.sleep(10000);
	  checkout_two.selectPymentMethod("CashOnDelivery");
	  
	  checkout_two.selectShipingoption("Ground Shipping");
	  checkout_two.gotofinalPage();
	  finalpage.getInformation("Forbidden Planet");
	 
	  finalpage.verifyProduct("James Bond Ultimate Collect ...");

	
}
   
}
