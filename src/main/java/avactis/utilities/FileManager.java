package avactis.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class FileManager {

	public static Properties prjprop;
	
	
	

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


	
	

}
