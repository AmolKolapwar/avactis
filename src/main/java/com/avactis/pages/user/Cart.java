package com.avactis.pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Cart extends LoadableComponent<Cart>{
	
	protected WebDriver driver;


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
	
	



	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
		
	}
	
	
	public Viewcart goToViewCart() {

		try {
			Actions action = new Actions(driver);
			action.moveToElement(cart).build().perform();
			if (!(ItemCount == null && ItemValue == null)) {

				System.out.println("Print the Item Count :" + ItemCount.getText());
				System.out.println("Print the Item Value  :" + ItemValue.getText());

				action.moveToElement(View_Cart).build().perform();
				View_Cart.click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Viewcart(driver);

	}

	
}
