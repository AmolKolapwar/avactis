package com.avactis.pages.user;

import static org.testng.Assert.assertEquals;
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
import org.openqa.selenium.support.ui.Select;

import com.avactis.utilities.WebTable;

public class Cart extends LoadableComponent<Cart>{
	
	protected WebDriver driver;

	public static Logger log = Logger.getLogger(Cart.class.getName());
	public Cart(WebDriver driver) {
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath=("//i[@class='fa fa-shopping-cart']"))
	WebElement cart;
	
	@FindBy(xpath=("//a[@class='top-cart-info-count']"))
	WebElement ItemCount;
	
	@FindBy(xpath=("//a[@class='top-cart-info-value']"))
	WebElement ItemValue;
	
	@FindBy (xpath=("//a[@class='btn btn-primary']"))
	WebElement Checkout;
	
	@FindBy (xpath=("//a[contains(text(),'View Cart')]"))
	WebElement View_Cart;
	
	@FindBy (xpath=("//a[contains(text(),'Continue Shopping')]"))
	WebElement Continue;
	
	@FindBy (xpath="//a[contains(text(),'Checkout ')]")
	WebElement CheckOut;
	
	@FindBy (xpath="//li//strong[@class='shopping-total-price price']")
	WebElement TotalAmount;
	
	
	



	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertTrue(Continue.isDisplayed());
		
		
	}
	
	
	public Viewcart goToViewCart() {

		try {
			
			Actions action = new Actions(driver);
			action.moveToElement(cart).build().perform();
			if  (!( ItemCount.getText().equals("0 items") && ItemValue.getText().equals("$0.00") )) {
                    
				System.out.println("Print the Item Count :" + ItemCount.getText());
				System.out.println("Print the Item Value  :" + ItemValue.getText());

				action.moveToElement(View_Cart).build().perform();
				View_Cart.click();
			   System.out.println("Print the row count :"  + WebTable.getRwocount() );
			   System.out.println("Print the column count :"  + WebTable.getColumnCount());
			   System.out.println("Print the Item Name  :"  + WebTable.getData(2, 2));

			}else {
				
				System.out.println("Item And Value is Null" );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Viewcart(driver);

	}

	
	public void verifyProductquntity(){
		try {
		WebElement qunity = driver.findElement(By.name("quantity_in_cart[0]"));
		Select qut = new Select (qunity);
		List<WebElement>  qty = qut.getOptions();
		log.info("Get the All Option form drop down");
        System.out.println("print the All option from Quantity  drop down :"  +  qty.size());

		String qunitycount = qut.getFirstSelectedOption().getText();
		System.out.println("Print the selected Product Quantity :"  + qunitycount);
		} catch (Exception e){
			 e.printStackTrace();
		}
		
	}
	
	
	public void verifyTotalAmount(){
		
		   for (int i =0;i<WebTable.getRwocount();i++){
			for (int j=0;j<WebTable.getColumnCount();j++){
				
				System.out.println(i);
				System.out.println(j);
				/*String Total=	WebTable.getData(i+1,j+2);
				System.out.println("Print the Total amount: "  + Total);

				System.out.println("print the SubTotal Amount  :"   + TotalAmount.getText());
				if (Total.equals(TotalAmount)){
					assertEquals(Total, TotalAmount);*/
				
			}
			
			
			
				
			}
		}
		
		
		
	
	

	
	public Checkout gotoCheckoutPage(){
		
		CheckOut.click();
		log.info("Click on Checkout button Navigat to Chekcout Page");
		return new Checkout(driver);
	}
	
	
}
