package com.avactis.pages.user;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.avactis.usertest.SearchResult;
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
		WaitFunction.waitForElementPresent(DVD, 10);
		action.moveToElement(DVD).click().build().perform();
		
		 searchResult();
		 return true;
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	return false;
}


public boolean searchResult(){
	
	
	List<WebElement> searchresult= driver.findElements(By.xpath("//div[@class='col-md-9 col-sm-7']"));
	
     int itemcount = searchresult.size();
     System.out.println("Print the item coutn" +searchresult.size());
     for (WebElement search: searchresult){
    	 
    	
    	 System.out.println(search.getText());
    	 break;
     }
     
			
			
	return searchResult();
}  
public void searchProduct(String category,String subcategory,String productname){
	
	
	
	
}



	
}
