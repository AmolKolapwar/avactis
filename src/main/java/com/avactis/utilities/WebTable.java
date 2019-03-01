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
	
	
	public static WebElement getElement(int rowIdx, int colIdx) throws NoSuchElementException {
		try {
			
			List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
			WebElement currentRow = tableRows.get(rowIdx);
			List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			WebElement cell = tableCols.get(colIdx);
			return cell;
			
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}
	}
	
	
	public static String getalldata(){
		System.out.println("-----------------Print the All Item Name----------------------------------");
		List<WebElement> row = driver.findElements(By.tagName("//table[@class='order_items without_images']/tbody/tr"));

		List<WebElement> col = driver.findElements(By.tagName("td"));

		for(int i=2;i<=row.size();i++)
		{
			List <WebElement>allColumnsInRow=driver.findElements(By.xpath("//table[@class='order_items without_images']/tbody/tr["+i+"]/td"));
			for(int j=0;j<allColumnsInRow.size();j++)
			{
				System.out.print(allColumnsInRow.get(j).getText()+" ");
			}
			System.out.println();
		}
		return null;
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
		
		String beforexpath = "//table[@class='order_items without_images']/tbody/tr[";
		String afterxpath = "]/td[3]";
		
		for (int i =1;i<row.size();i++){
			
			String actualxpath = beforexpath+i+afterxpath;
			WebElement elements = driver.findElement(By.xpath(actualxpath));
			System.out.println("Print the Prize"+elements);
			
		}
		
		String beforxpath1 = "//table[@class='order_items without_images']/tbody/tr[";
		String afterxpath1 = "]/td[2]";
		
		for (int j=1;j<row.size();j++){
			
			String actualxpath1 = beforxpath1+j+afterxpath1;
			WebElement elements1 = driver.findElement(By.xpath(actualxpath1));
			System.out.println("Print the Prize"+elements1);

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
	
			
			
		
		
		
		
	
	
