package automation.workday.workday.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automation.workday.workday.helper.browserConfiguration.BrowserType;
import automation.workday.workday.helper.browserConfiguration.ChromeBrowser;
import automation.workday.workday.helper.browserConfiguration.config.ObjectReader;
import automation.workday.workday.helper.browserConfiguration.config.PropertyReader;
import automation.workday.workday.helper.javascript.JavaScriptHelper;
import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.helper.resource.ResourceHelper;
import automation.workday.workday.helper.wait.WaitHelper;
import automation.workday.workday.utils.ExtentManager;


public class TestBase {
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public static File reportDirectery;

	@BeforeSuite
	public void beforeSuite() throws Exception{
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest() throws Exception{
		ObjectReader.reader = new PropertyReader();
		reportDirectery = new File(ResourceHelper.getResourcePath("src/main/resources/screenShots"));
		setUpDriver(ObjectReader.reader .getBrowserType());
		test = extent.createTest(getClass().getSimpleName());
	}


	@BeforeMethod
	public void beforeMethod(Method method){
		test.log(Status.INFO, method.getName()+"**************test started***************");
		log.info("**************"+method.getName()+"Started***************");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreen(result.getName(),driver);
			test.addScreenCaptureFromPath(imagePath);
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, result.getName()+" is pass");
			//String imagePath = captureScreen(result.getName(),driver);
			//test.addScreenCaptureFromPath(imagePath);
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, result.getThrowable());
		}
		log.info("**************"+result.getName()+"Finished***************");
		extent.flush();
	}

	@AfterTest
	public void afterTest() throws Exception{
		if(driver!=null){
			driver.quit();
		}
	}

	public WebDriver getBrowserObject(BrowserType btype) throws Exception{

		try{
			switch(btype){
			case Chrome:
				/** 
				 * get object of ChromeBrowser class
				 */
				ChromeBrowser chrome = ChromeBrowser.class.getDeclaredConstructor().newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				/**
				 * This will return the chrome driver
				 */
				return chrome.getChromeDriver(option);
			case Firefox:
				System.out.println("Firefox driver not avialable");
			default:
				throw new Exception("Driver not Found: "+btype.name());
			}
		}
		catch(Exception e){
			log.info(e.getMessage());
			throw e;
		}
	}

	public void setUpDriver(BrowserType btype) throws Exception{
		
		driver = getBrowserObject(btype);
		log.info("Initialize Web driver: "+driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		
		/**
		 *Can be written as 
		 *wait.setImplicitWait(30, TimeUnit.SECONDS);
		 *wait.pageLoadTime(30, TimeUnit.SECONDS);
		 */
		wait.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String captureScreen(String fileName, WebDriver driver){
		if(driver == null){
			log.info("driver is null..");
			return null;
		}
		if(fileName==""){
			fileName = "SS";
		}
		Reporter.log("captureScreen method called");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			String saveLocation =ResourceHelper.getResourcePath("src/main/resources/screenShots/")+".png";
			FileUtils.copyFile(src, new File(saveLocation));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return fileName;
	}

	public void getNavigationScreen(WebDriver driver) {
		log.info("capturing ui navigation screen...");
		new JavaScriptHelper(driver).zoomInBy60Percentage();
		 String screen = captureScreen("", driver);
		 new JavaScriptHelper(driver).zoomInBy100Percentage();
		 try {
			test.addScreenCaptureFromPath(screen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logExtentReport(String s1){
		test.log(Status.INFO, s1);
	}

	public void getApplicationUrl(String url){
		driver.get(url);
		logExtentReport("navigating to ..."+url);
	}

}
