package avactis.testbase;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.sun.xml.internal.fastinfoset.sax.Properties;

import avactis.pages.user.Login;
import avactis.utilities.FileManager;
import avactis.utilities.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Testbase extends FileManager{

	
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger(Testbase.class);
	

	
	public Login login = new Login(driver);
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		
		//Files.copy(scrFile, new File(prjprop.getProperty("ScreenShotPath") + System.currentTimeMillis() + ".png"));
		
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		try{
		FileUtils.copyFile(scrFile, new File(prjprop.getProperty("SCREEN_SHOT_PATH") +  ".png"));
		}catch(IOException e){
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("Screenshot captured");
		}
	
	
	@BeforeClass
	@Parameters({"browserType","appUrl"})
	public WebDriver setup(String browserName,String applicationURL){
		// To Load Chrome driver Instance.
		if (browserName.equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		  log.debug("Chrome Browser loaded");
		}else if(browserName.equalsIgnoreCase("FireFox")){
			// To Load Firefox driver Instance.
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.debug("Firefox Browser loaded");
		}else if(browserName.equalsIgnoreCase("Safari")){
			// To Load Safari driver Instance.
			driver = new SafariDriver();
			log.debug("Safari Browser loaded ");
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener(); 
		e_driver.register(eventListener);
		driver = e_driver;
		
		if (driver != null){
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(applicationURL);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		}else{
			
			driver.close();
			log.debug("Browser closed");
			driver = null;	
		}
		return driver;
		
	}	
		/*public static void capture(WebDriver driver, String screenshotname) {
			try {

				DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
				DateFormat timeformat = new SimpleDateFormat("HHmmss");
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				Date date = new Date();
				//System.out.println(dateFormat.format(date));
				 FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\avactis\\TestReports\\ErrorScreenshot"
						+ dateFormat.format(date) + "\\" + screenshotname+"_"+timeformat.format(date)+ ".png"));
						
				// FileUtils.copyDirectory(source, new File(
				// "C:\\Users\\sanket\\git\\HMS_JAN_2019\\hms\\java\\screenshots" +
				// screenshotname + ".jpeg"));
				System.out.println("**********  ScreenShot taken for test " + screenshotname + "  **********");
			} catch (Exception e) {
				System.err.println(e);
			}

	
	
}
*/		
	
	
	
	@AfterClass
	public void teardown(){
		
		
		
		
		driver.close();
		
	}		
}
