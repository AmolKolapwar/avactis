package com.avactis.testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.avactis.pages.user.Cart;
import com.avactis.pages.user.Login;
import com.avactis.pages.user.Registration;
import com.avactis.test.listener.WebEventListener;
import com.avactis.utilities.FileManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.java2d.cmm.Profile;
public class Testbase extends FileManager{

	
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger(Testbase.class);
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;


	
	public Login login;
	public Registration registration;
	
	public Cart cart;
//	public Checkout checkout;
	
	
	/*public static void takeScreenshotAtEndOfTest() throws IOException {
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
	*/
	
	@BeforeClass
	@Parameters({"browserType","appUrl"})
	public WebDriver setup(String browserName,String applicationURL){
		// To Load Chrome driver Instance.
		
		
		//ChromeOptions options = new ChromeOptions();
		if (browserName.equalsIgnoreCase("Chrome") ){
		
			WebDriverManager.chromedriver().setup();
			//disableImagesChrome(options);
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
			
			
		}/*else{
			
			driver.close();
			log.debug("Browser closed");
			driver = null;	
		}*/
		return driver;
		
	
			

		
	}	
	@BeforeSuite
	
	public void extentSetUp() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + prjprop.getProperty("REPORT_LOCATION"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	

		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Host Name", "Amol");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "AMOL KOLAPWAR");
        
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AvactisTest Automation Report");
		htmlReporter.config().setReportName("Test Execution Report ");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}
			
			
		
	
	
	@AfterClass
	public void teardown(){
		
		
		driver.quit();
	}
		/*public static String captureScreenshot(WebDriver driver, String screenShotName) throws Exception {

			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);

			String dest = System.getProperty("user.dir") + prjprop.getProperty("SCREEN_SHOT_PATH") + screenShotName
					+ System.currentTimeMillis() + ".png";

			System.out.println("Screenshot captured at location: " + dest);
			log.debug(" ########### Screenshot captured at location: ########### " + dest);

			ImageIO.write(screenshot.getImage(), "PNG", new File(dest));

			return dest;
			
			
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			DateFormat timeformat = new SimpleDateFormat("HHmmss");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			Date date = new Date();
			//System.out.println(dateFormat.format(date));
			FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\java\\screenshots\\"
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
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		Date date = new Date();

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" +"\\"+ screenshotName +"_" +dateName
				+ ".png";
		
		System.out.println("Screenshot captured at location: " + destination);

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		log.debug(" ########### Screenshot captured at location: ########### " + destination);

		return destination;
		
	}
	
	
	public static void disableImagesChrome(ChromeOptions options){
		HashMap<String, Object> images = new HashMap<String, Object>();
		images.put("images", 2);
		
		HashMap<String, Object> perfs = new HashMap<String, Object>();
		perfs.put("profile.default_content_setting_values",images);
		options.setExperimentalOption("perfs", perfs);
		
	}
	
	
			
}
