package com.avactis.testdata;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.avactis.utilities.FileManager;

public class UserDataProvider {

	
	
	@DataProvider(name = "setLoginData")
	public Object[][] setLoginData() throws InvalidFormatException{
		Object data[][] = FileManager.getTestData("Login");
		return data ;
	}
}
