package com.avactis.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javascript {
	
public static void datepicker(WebDriver driver,WebElement element, String date_value){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+date_value+"');", element);
		
	}
	
	public static void drawborwder(WebDriver driver,WebElement element){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void genrateAlert(WebDriver driver,String message){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickonElement(WebDriver driver,WebElement element){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void refreshBrowser(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
		
	}
	
	public static String getTitleBy(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return doucument.title;").toString();
		return title;
	}
	
	public static void scrollPagedown(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element){
         
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
