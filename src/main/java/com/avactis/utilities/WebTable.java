package com.avactis.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.avactis.testbase.Testbase;

public class WebTable extends Testbase{

	//private WebElement _webtable;
	public static int getRwocount(){
		
		List<WebElement>  row = driver.findElements(By.tagName("tr"));
		return  row.size();
	}
	
	
	public static int getColumnCount(){
		List<WebElement>  row = driver.findElements(By.tagName("tr"));
		WebElement headerRow = row.get(0);

		List<WebElement> col = driver.findElements(By.tagName("th"));
		return col.size();
	}
	
	
	public static String getData(int rowIdx, int colIdx){
		
		
			List<WebElement> row = driver.findElements(By.tagName("tr"));
			WebElement currentRow = row.get(rowIdx-1);
			List<WebElement> col = currentRow.findElements(By.tagName("td"));
			WebElement cell = col.get(colIdx-1);
			return cell.getText();		
		
	}
}
