package avactis.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.sun.xml.internal.fastinfoset.sax.Properties;

import avactis.pages.user.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(Testbase.class);

	
	public Login login = new Login(driver);
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
	
	
	@AfterClass
	public void teardown(){
		
		driver.close();
		
	}
	
}
