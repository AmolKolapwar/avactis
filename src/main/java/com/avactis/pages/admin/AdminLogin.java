package com.avactis.pages.admin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.avactis.utilities.WaitFunction;

public class AdminLogin extends LoadableComponent<AdminLogin>{
	
	
	protected WebDriver driver;
	public static Logger log = Logger.getLogger(AdminLogin.class.getName());
	
	
	
	public AdminLogin(WebDriver driver ){
		//Initializing the Page With Webdriver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

          
	@FindBy(xpath=("//input[@name='AdminEmail']"))
	WebElement AdminEmail;
	
	@FindBy(xpath=("//input[@name='Password']"))
	WebElement Password;
	
	@FindBy (xpath=("//button[@type='submit']"))
	WebElement Sign_In;
	
	@FindBy(xpath=("//input[@type='checkbox']"))
	WebElement Remember;
	
	@FindBy (xpath=("//a[@id='forget-password']"))
	WebElement Forgot;
	
	@FindBy(xpath=("//div[@class='alert alert-danger']"))
	WebElement Error_msg;
	

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
		assertTrue(driver.getCurrentUrl().endsWith("admin/signin.php"));
		
	}
	
	
	public boolean verifyLoginPage_UI(){
		boolean flag2 = false;
         log.info("Stroe All Page Element in List ");
		List<WebElement> ElementsList = driver.findElements(By.tagName("body"));

		String[] tempList = ElementsList.get(0).getText().split("\n");
		List<String> expectedResult = new ArrayList<String>();
    
		log.info("Stroe Expected Result in List");
		expectedResult.add("Sign In");
		expectedResult.add("Remember me");
		expectedResult.add("Sign In");
		expectedResult.add("Forgot your password ?");
		expectedResult.add("no worries, click here to reset your password.");
		expectedResult.add("© 2004-2019 Avactis. All Rights Reserved.");
		expectedResult.add("4.8.0 AVACTIS-NEXT, build 48000");

		for (int k = 0; k < expectedResult.size(); k++) {
			Boolean flag = false;
			for (int i = 0; i < tempList.length; i++) {

				if (tempList[i].equalsIgnoreCase(expectedResult.get(k))) {
					System.out.println(tempList[i]);
					System.out.println(expectedResult.get(k));
					assertEquals(tempList[i], expectedResult.get(k));
					flag = true;
					log.info("---------List commapre-------------- ");
					break;
                 
				}

			}
			if (!flag) {
				System.out.println("Not Found " + expectedResult.get(k));
			}
			flag2 = flag;

		}
		return flag2;
	}

	
	
	public boolean invalidLogin(String id,String password){
		
		log.info("---------Into Invalid Login---------");
		
		
		try{
			
		    WaitFunction.waitForElementPresent(AdminEmail, 10);
		    
		    AdminEmail.clear();
		    AdminEmail.sendKeys(id);
		    log.info("====User Name"+ id+ "====================");
		    Password.clear();
		    Password.sendKeys(password);
		    
		    log.info("====Password" + password + " =================");
		    Sign_In.click();
		}catch(Exception e){
			e.printStackTrace();
		
		}
		
		if (!driver.getCurrentUrl().endsWith("/index.php?") ){
			log.info("========invalid login method failed=========");
			 return true;
			 
		}else{
			log.info("============invalid login method pass=====================");
			return false;
			
					 
		}
		
		 
	}
	
	public AdminHomePage validLogin(String id, String password){
		
		
		WaitFunction.waitForElementPresent(AdminEmail, 10);
		
		AdminEmail.clear();
		AdminEmail.sendKeys(id);
		Password.clear();
		Password.sendKeys(password);
	    Sign_In.click();

		System.out.println(driver.getTitle());
		WaitFunction.watiForPageLoad(20);
		if (driver.getCurrentUrl().endsWith("/index.php")&& driver.getTitle().equalsIgnoreCase("Avactis Shopping Cart")){
			
			log.info("-------valid login passed-------------");
			
		}else{
			
			System.out.println("------------------Test Failed------------------");
		}
		
		
		return new AdminHomePage(driver);
	}
	
	
	
	}


