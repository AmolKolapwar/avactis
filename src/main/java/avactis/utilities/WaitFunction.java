package avactis.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import avactis.testbase.Testbase;

public class WaitFunction {
	
	public static boolean waitForElementPresent(WebElement element,int timeout){
		
		try{
		WebDriverWait wait = new WebDriverWait(Testbase.driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		return true;
		}catch (Exception e){
			e.printStackTrace();
		}return false;
	}

}
