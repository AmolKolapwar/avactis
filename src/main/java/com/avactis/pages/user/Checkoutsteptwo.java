package com.avactis.pages.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.utilities.WaitFunction;

public class Checkoutsteptwo {
	protected WebDriver driver;
	Logger log = Logger.getLogger(Checkoutsteptwo.class.getName());
	public Checkoutsteptwo(WebDriver driver){
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (xpath="//div[@class ='shipping_method_name']")
	WebElement shippingmethod;
	
	@FindBy (xpath="//div[@class='payment_methods']")
	WebElement paymentMethod;
	
    @FindBy (xpath="//input[@onclick ='submitStep(2);']")
    WebElement Continue_Button;
    
    
   
	public void selectPymentMethod(String paymentmethodName) {
		boolean flag = false;
		List<WebElement> paymenmethod = driver.findElements(By.xpath("//div[@class='payment_methods']"));

		log.info("Print the payment method size :" + paymenmethod.size());

		for (WebElement payment : paymenmethod) {
			log.info("Print the payment Method name : " + payment.getText());

			if (payment.getText().equalsIgnoreCase(paymentmethodName)) {

				flag = true;

				WebElement selectmethod = driver.findElement(By.xpath("//input[@name='paymentModule[method_code]']"));

				// selectmethod.click();

				if (selectmethod.isSelected()) {

					System.out
							.println("---------Print the Selected  Payment Method Name  :" + selectmethod.isSelected());

				} else {

					System.out.println("----------Payment Method Not Selected  : ");

				}
			} else {
				System.out.println("Payment Method :" + paymentmethodName + " :Not Avliable ");

			}

		}
	}
	
	public void selectShipingoption(String shipinmethodName) {
		boolean flag = false;
		List<WebElement> shipingmethod = driver.findElements(By.xpath("//div[@class ='shipping_method_name']/label"));

		log.info("Print the Shiping Mehtod Size :" + shipingmethod.size());

		for (WebElement shipingmethodname : shipingmethod) {
			System.out.println("-------Print the Method Names :  " + shipingmethodname.getText());
			flag = true;
			if (shipingmethodname.getText().equalsIgnoreCase(shipinmethodName)) {
				
				log.info("------------Print the User Provided Method Name------- :" + shipinmethodName);
				WaitFunction.waitForElementPresent(shipingmethodname, 10);
				shipingmethodname.click();
				log.info("Shiping Method Get Selected :" + shipinmethodName);

			}
		}
		
	}
	
	
	
	
public CheckpoutFinalPage gotofinalPage(){
		
		
		Continue_Button.click();
		return new CheckpoutFinalPage(driver);
		
	}
	
}