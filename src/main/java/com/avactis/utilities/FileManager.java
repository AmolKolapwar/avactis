package com.avactis.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;






public class FileManager {

	public static Properties prjprop;
	static Workbook book;
	static Sheet sheet;
	
	
	

	public FileManager() {

		File projprop = new File(System.getProperty("user.dir") + "/src/main/resources/avactis.properties");

		System.out.println("Project Properties Path: " + projprop);

		try {

			FileInputStream fis = new FileInputStream(projprop);
			prjprop = new Properties();
			prjprop.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is ======" + e.getMessage());
		}
	}
		
		public static Object[][] getTestData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {
			FileInputStream file = null;
			try {
				
			//	String testDataPath = System.getProperty("user.dir") +prjprop.getProperty("TESTDATA_PATH")+fileName+".xlsx";
				String testDataPath = System.getProperty("user.dir") + "\\TestData\\Testing.xlsx";//prjprop.getProperty("TESTDATA_PATH");
				
				System.out.println("########### EXCEL FILE PATH :"+testDataPath+" ###########");
				
				file = new FileInputStream(testDataPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
			
			System.out.println(data);
			return data;
		}

	}


	
	


