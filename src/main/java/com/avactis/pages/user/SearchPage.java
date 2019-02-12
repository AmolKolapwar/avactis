package com.avactis.pages.user;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.avactis.utilities.WaitFunction;

public class SearchPage extends LoadableComponent<SearchPage> {
	
	protected WebDriver driver;

	public static Logger log = Logger.getLogger(SearchPage.class.getName());
	
	public  SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath=("//i[@class='fa fa-search search-btn']"))
	WebElement SearchIcon;
	
	@FindBy (xpath=("//input[@name='search_pattern']"))
    WebElement SearchFiled;
	
	@FindBy (xpath=("//button[@class='btn btn-primary']"))
	WebElement SearchButton;
	
	@FindBy (xpath=("//a[@class='collapsed']"))
	WebElement DVD;
	
	@FindBy (xpath=("//div[@class='ajax_message_box_text']//h2"))
	WebElement SuccessMsg;
	
	
@Override
protected void load() {
	// TODO Auto-generated method stub
	
}

@Override
protected void isLoaded() throws Error {
	assertTrue(SearchIcon.isDisplayed());
	
}


public boolean  searchProductByquery(String productname){
	
	Actions action = new Actions(driver);
	try{
	action.moveToElement(SearchIcon).click().build().perform();
	if (SearchButton.isDisplayed()){
		
		SearchFiled.clear();
		SearchFiled.sendKeys(productname);
		SearchButton.click();
		//action.moveToElement(DVD).click().build().perform();
		 searchResult(productname);
		 return true;
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	return false;
}


public boolean searchResult(String produname){
	
	
	List<WebElement> searchresult= driver.findElements(By.xpath("//div[@class='search_result row product-list']"));
	
	
     int itemcount = searchresult.size();
     System.out.println("Print the item coutn" +searchresult.size());
     for (WebElement search: searchresult){
    	 
    	
    	 System.out.println(search.getText() + search.getSize());
    	 break;
     }
     
			
			
	return true;
}  


	public boolean  selectProduct(String category, String subcategory,String prodName) {
		try {
			
			// Using below method we create xpath dynmically
			String categoryname = "//a[contains(text(),'" + category + "') and @class='dropdown-toggle']";
			String subcategoryname = "//ul[@class='dropdown-menu']//li//a[contains(text(),'" + subcategory + "')]";
            
            
			// assign to webelements
			WebElement categoryName = driver.findElement(By.xpath(categoryname));
			WebElement subcategoryName = driver.findElement(By.xpath(subcategoryname));
			// print the configurable xpath
			System.out.println("Print the category xpath: " + categoryName);
			System.out.println("Print the subcategpry xpath :" + subcategory);
			

			Actions action = new Actions(driver);

			WaitFunction.waitForElementPresent(categoryName, 10);
			action.moveToElement(categoryName).build().perform();
			WaitFunction.waitForElementPresent(subcategoryName, 10);
			action.moveToElement(subcategoryName).build().perform();

			subcategoryName.click();
			searchResult(subcategory);
			
            String productName= "//a//div[@class='product_name']//h3[contains(text(),'"+prodName+"')]/preceding::input[@value='Add To Cart']";
            WebElement productNames = driver.findElement(By.xpath(productName));
			System.out.println("Print the Product Name  :"   + productName);
 

			WaitFunction.waitForElementPresent(productNames, 10);
			productNames.click();
			WaitFunction.waitForElementPresent(SuccessMsg,10);
			assertTrue(SuccessMsg.isDisplayed(), "Message not dispalyed");
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
}
