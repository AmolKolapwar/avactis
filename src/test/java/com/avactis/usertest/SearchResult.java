package com.avactis.usertest;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.pages.user.Cart;
import com.avactis.pages.user.SearchPage;
import com.avactis.testbase.Testbase;
import com.aventstack.extentreports.Status;

public class SearchResult extends Testbase{
	
	public static Logger log = Logger.getLogger(SearchResult.class.getName());
	
	SearchPage search;
	Cart cart;
	
	@BeforeMethod
	  public void pageSetup() {
		  
		search = new SearchPage(driver);
		
	  }

	  
	  @Test
	  public void verifyValidLogin() {
		  extentTest = extent.createTest("verifyValidLogin");
		  extentTest.log(Status.INFO, "Verify Valid Login");
		  assertTrue(search.searchProductByquery("DVD"));
	 }
    
	  
	  @Test 
	  public void testing() {
		  extentTest = extent.createTest("testing");
		  extentTest.log(Status.INFO, "testing");
		  search.selectProduct("DVD", "Classic Films","Forbidden Planet");
	  }
	
	
	}
   


