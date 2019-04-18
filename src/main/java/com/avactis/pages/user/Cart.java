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
import org.openqa.selenium.support.ui.Wait;

import com.avactis.utilities.WaitFunction;
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
	
    @FindBy (xpath="//input[@onclick ='submitStep(2);']")
    WebElement Continue_Button;

    @FindBy (xpath="//input[@id='input_promo_code']")
    WebElement PromoCode;
    
    @FindBy (xpath="//div[@class='col-lg-3']//input[@class='btn input_submit']")
    WebElement ApplyButton;
    
    @FindBy (xpath="//div[@class='promo_code_form']//div[@class='note note-danger']")
    WebElement Error_msg;

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
			if (!(ItemCount.getText().equals("0 items") && ItemValue.getText().equals("$0.00"))) {

				System.out.println("Print the Item Count :" + ItemCount.getText());
				System.out.println("Print the Item Value  :" + ItemValue.getText());

				action.moveToElement(View_Cart).build().perform();
				View_Cart.click();
				System.out.println("Print the row count :" + WebTable.getRwocount());
				System.out.println("Print the column count :" + WebTable.getColumnCount());
				System.out.println("Print the Item Name  :" + WebTable.getcoldata());
				
				System.out.println("-------------------------------------------------------------------------------------");

			} else {

				System.out.println("Item And Value is Null");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Viewcart(driver);

	}

	public void verifyProductquntity() {

		try {
			String productname = null;
			String itemqunity = null;
			// Get the All option from drop down.......
			WebElement qunity = driver.findElement(By.name("quantity_in_cart[0]"));
			Select qut = new Select(qunity);

			// Store the all options in list and get the size of list so we can
			// get
			// the number of option from drop down...
			List<WebElement> qty = qut.getOptions();
			log.info("Get the All Option form drop down");
			System.out.println("print the All option from Quantity  drop down :" + qty.size());

			
			List<WebElement> productdescription = driver
					.findElements(By.xpath("//td[@class='goods-page-description']"));
			List<WebElement> productqunity = driver
					.findElements(By.xpath("//td[@class='product_quantity_selector goods-page-quantity']"));

			for (int i = 0; i < productdescription.size(); i++) {
				productname = productdescription.get(i).getText() + " ";
				String qunitycount = qut.getFirstSelectedOption().getText();

				System.out.println("----Print the Product description: " + productname + " And Prodcut quntity  : " + qunitycount);
						
				
				System.out.println("-------------------------------------------------------------------------------------");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public boolean  verifyTotalAmount() {

		String subtotal = TotalAmount.getText();

		try {
			String amount = null;
			float sum = 0;
			float sum1 = 0;

			// get the all item amount from total column
			List<WebElement> allColumnsInRow = driver.findElements(By.xpath("//td[@class='goods-page-total']"));

			for (WebElement e : allColumnsInRow) {
				System.out.println("print the:" + e.getText().substring(1));
				sum = sum + Float.valueOf(e.getText().substring(1));
				
			}
			System.out.println("----------Print the Total Price---------------: " + sum);
			
			System.out.println("-------------------------------------------------------------------------------------");
			
			if (subtotal.substring(1).equals(sum)) {
				log.info("SubTotal and Total Amount Match");
				return true;
			}

		} catch (NumberFormatException e) {

			System.out.println(e);
		}
		return false;

	}
		
			
		public void verifyApplycoupanWithInvalidData(String coupan){
			
			WaitFunction.waitForElementPresent(PromoCode, 10);
			PromoCode.clear();
			PromoCode.sendKeys(coupan);
			ApplyButton.click();
			WaitFunction.waitForElementPresent(Error_msg, 10);
			
			log.info("-------Verify The Error Message--------------------");
			if(Error_msg.isDisplayed()){
				assertTrue(Error_msg.getText().equalsIgnoreCase("Invalid Promo Code. Please enter correct promo code."));
				System.out.println("---------It Showing error Message for Invalid Data------------");
			}else{
				
				System.out.println("Message not Displey");
			}
			
			
			
		}
	
	

	
	public Checkout gotoCheckoutPage(){
		
		CheckOut.click();
		log.info("Click on Checkout button Navigat to Chekcout Page");
		return new Checkout(driver);
	}
	
	
}
