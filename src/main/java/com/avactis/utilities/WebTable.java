package com.avactis.utilities;

import java.util.List;
import java.util.NoSuchElementException;

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
	
	
	
	
	public static int getheadercoun(){
		
		List <WebElement>allHeadersOfTable1= driver.findElements(By.xpath("//table[@summary='Shopping cart']/tbody/tr/th"));
		System.out.println("Headers in table are below:");
		System.out.println("Total headers found: "+allHeadersOfTable1.size());
		for(WebElement header:allHeadersOfTable1)
		{
			System.out.println(header.getText());
		}
		return allHeadersOfTable1.size();
		
}
	
	
	
	
	public static void custemtable(){
		
		List<WebElement> row = driver.findElements(By.tagName("tr"));
		String beforexpath = "//table[@summary='Shopping cart']/tbody/tr[";
		String afterxpath = "]/td[5]";
		
		for (int i =2;i<row.size();i++){
			
			String actualxpath = beforexpath+i+afterxpath;
			WebElement elements = driver.findElement(By.xpath(actualxpath));
			System.out.println("Print the Prize"+elements);
			
		}
		
		
	}

	public static String getcoldata() {
		
		String amount = null;
		String ItemName = null;

		try{
	
		
		List<WebElement> allColumnsInRow = driver.findElements(By.xpath("//td[@class='goods-page-total']"));
		List<WebElement> itemName = driver.findElements(By.xpath("//td[@class='goods-page-description']"));

		// Getting the All column data with spacifica
		for (int j = 0; j < allColumnsInRow.size(); j++) {

			amount = allColumnsInRow.get(j).getText() + " ";
			System.out.println("-------Print the Product  Price----- :  " + amount);

		}

		// Gettting the all row data with spacifica row
		for (int i = 0; i < itemName.size(); i++) {

			ItemName = itemName.get(i).getText() + " ";
			System.out.println("-----------Print the Product Name-------- :" + ItemName);
		}
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return ItemName;
	}

}
	
			
			
		
		
		
		
	
	
