package com.avactis.usertest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.user.Cart;
import com.avactis.pages.user.SearchPage;
import com.avactis.testbase.Testbase;

public class SearchResult extends Testbase{
	
	public static Logger log = Logger.getLogger(SearchResult.class.getName());
	public static Logger log =  Logger.getLogger(Cart.class.getName());
	
	SearchPage search;
	Cart cart;
	
	@BeforeMethod
	  public void pageSetup() {
		  
		search = new SearchPage(driver);
		cart = new Cart(driver);
	  }

	  
	 /* @Test
	  public void verifyValidLogin() {
		  extentTest = extent.createTest("verifyValidLogin");
		  extentTest.log(Status.INFO, "Verify Valid Login");
		  assertTrue(search.searchProductByquery("DVD"));
	 }*/
    
	  
	 /* @Test 
	  public void testing() {
		  extentTest = extent.createTest("testing");
		  extentTest.log(Status.INFO, "testing");
		  search.selectProduct("DVD", "Classic Films","Forbidden Planet");
	  }*/
	
	@Test
	public void testing2(){
		extentTest = extent.createTest("testing2");
		  extentTest.log(Status.INFO, "testing2");
	      search = cart.goToViewCart();
	}
   

}
