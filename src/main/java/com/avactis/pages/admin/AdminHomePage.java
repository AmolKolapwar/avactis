package com.avactis.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.utilities.WaitFunction;

public class AdminHomePage {

	protected WebDriver driver;

	
	
	
	public AdminHomePage(WebDriver driver ){
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (xpath="//a[@href='orders.php']//span[@class='title']")
	WebElement Order_Menue;
	
	
	
	
	
	public void Order() throws InterruptedException{
		
		Actions action = new Actions(driver);
		WaitFunction.waitForElementPresent(Order_Menue, 10);
		action.moveToElement(Order_Menue).click().build().perform();
	
		System.out.println("Print the order page title :"  + driver.getTitle());
		
	
		String Beforexpath = "//div[@class='portlet-body']//tbody//tr[";
		
		String Afterxpath ="]//td[3]";
		
		for (int i =1;i<=10;i++){
			
			String name = driver.findElement(By.xpath(Beforexpath+i+Afterxpath)).getText();
			System.out.println(name);
			
			if (name.contains("anonymous9")){
				
			WebElement select=	driver.findElement(By.xpath("//div[@class='portlet-body']//tbody//tr["+i+"]//td[3]"));
			System.out.println("-------" +select.getText());
			Thread.sleep(10000);
			action.moveToElement(select).click().build().perform();
			
			String parent = driver.getWindowHandle();
			String child = driver.getWindowHandle();
			
			driver.switchTo().window(child);
			Thread.sleep(10000);
			System.out.println("Print the child window title :" + driver.getTitle());
				
			}
		}
	}
	
	
	
	
}
