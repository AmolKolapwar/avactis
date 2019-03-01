package com.avactis.pages.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.utilities.WaitFunction;
import com.avactis.utilities.WebTable;

public class CheckpoutFinalPage {
	
	
	protected WebDriver driver;
	
	public static Logger log = Logger.getLogger(CheckpoutFinalPage.class.getName());
	

	public CheckpoutFinalPage(WebDriver driver) {
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//input[@value='Place Order']")
	WebElement PlaceOrder;
	
	public String   getInformation (String naem) throws InterruptedException{
		String productname = null;
		String produceprice = null;
		
		WaitFunction.waitForElementPresent(PlaceOrder, 10);
		List<WebElement> itemprice = driver.findElements(By.xpath("//td[@class='product_total_price']"));
		List<WebElement> itemname = driver.findElements(By.xpath("//td[@class='product_data']"));
	 
		System.out.println("Print -----------" +itemname.size());
		System.out.println("Print -----------" +itemprice.size());

		for (int i =0;i<itemname.size();i++){
			productname = itemname.get(i).getText() + " ";
			
			System.out.println("Print The  Item Name :"  + productname);
			if (productname.equalsIgnoreCase(naem)){
				System.out.println("item In Cart");
			}else{
				
				System.out.println("Item Not in cart");
			}
		} 
		
			for (int k=0;k<itemprice.size();k++){
				
				produceprice =itemprice.get(k).getText() + " " ;
				System.out.println("Print The  Item Price :"  + produceprice);
			
				Thread.sleep(10000);
				
				
				
			}
			return produceprice ;
			
		
		
		
		
	}
			
	
	
	
	public void verifyProduct(String name){
		
		int rowcount = WebTable.getRwocount();
		int colcount = WebTable.getColumnCount();
		
		System.out.println("Number Of Row :" + rowcount + "And Number Column :"  +colcount );
		try{
			
			for (int i=1;i<rowcount;i++){
				
				WebElement textpresent = WebTable.getElement(i,2);
				if(textpresent.getText().equalsIgnoreCase(name)){
					System.out.println("Item in Cart");
				}
				else{
					
					System.out.println("Item Name Not Match");
				}
				
			}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
}


