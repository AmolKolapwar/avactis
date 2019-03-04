package com.avactis.pages.user;

import java.util.ArrayList;
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
	
	    @FindBy (xpath="//div[@class='main']//li[1]")
	    WebElement subTotal;	
	
	public String   getInformation (String name,String name1) throws InterruptedException{
		String productname = null;
		String produceprice = null;
		
		WaitFunction.waitForElementPresent(PlaceOrder, 10);
		int rowcount = WebTable.getRwocount();
		int colcount = WebTable.getColumnCount();
		List<WebElement> itemprice = driver.findElements(By.xpath("//td[@class='product_total_price']"));
		List<WebElement> itemname = driver.findElements(By.xpath("//td[@class='product_data']"));
	 
		System.out.println("Print -----------" +itemname.size());
		System.out.println("Print -----------" +itemprice.size());

		for (int i =0;i<itemname.size();i++){
		  productname = itemname.get(i).getText() + " ";	
		  System.out.println("Print The  Item Name :"  + productname);

		
		  
			if (productname.contains(name) ){
 
			}else if (productname.contains(name1)) {
				
				System.out.println("Item In List");
			
			}else{
				
				
				System.out.println("Item Not In List");
			}
			
		} 
		
		
		
			for (int k=0;k<itemprice.size();k++){
				
				produceprice =itemprice.get(k).getText() + " " ;
				System.out.println("Print The  Item Price :"  + produceprice);
			
				Thread.sleep(10000);
				
				
				
			}
			return produceprice ;
			
		
		
		
		
	}
			
	
	
	
	public void verifyProductOnFinalPage(String name,String name1){
		WebElement textpresent = null;
		String ItemText = null;
		int rowcount = WebTable.getRwocount();
		int colcount = WebTable.getColumnCount();
			
		System.out.println("Number Of Row :" + rowcount + "And Number Column :"  +colcount );
		try{
			
			for (int i=1;i<rowcount;i++){
				
				textpresent = WebTable.getElement(i,0);
				
				ItemText = textpresent.getText();
				System.out.println("-----------" +textpresent.getText());
				if(ItemText.contains(name) ) {
					System.out.println("Item in Cart");
					
					
				}else if (ItemText.contains(name1)){
					
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
	
	public boolean subTotal(double d) {

		String subtotal = subTotal.getText().substring(11);
		double testing = Double.parseDouble(subtotal);
		System.out.println("Print the SubTotal Value:" + subtotal);
		if (testing == d) {

			System.out.println("Rate match with the final order");

		} else {

			System.out.println("Rate  not match with the final order");
		}
		return false;
	}
	


public ConfirmationPage finalPage(){
	
	log.info("Click on Place Order Button");
	PlaceOrder.click();
	
	return new ConfirmationPage(driver);
}
}


