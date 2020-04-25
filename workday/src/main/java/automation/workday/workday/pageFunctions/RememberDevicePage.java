package automation.workday.workday.pageFunctions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import automation.workday.workday.helper.javascript.JavaScriptHelper;
import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.helper.wait.WaitHelper;
import automation.workday.workday.pageObject.RememberDeviceOR;
import automation.workday.workday.testBase.TestBase;

public class RememberDevicePage extends RememberDeviceOR {

	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	public RememberDevicePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waitHelper=new WaitHelper(driver); 
		waitHelper.WaitForElementClickable(skip, 30);
		new TestBase().getNavigationScreen(driver);
		logExtentReport("Remember Device Page object created");
	}
	
	public HomePage clickOnSkip() {
		log.info("clicking on skip option....");
		logExtentReport("clicking on skip option....");
		JavaScriptHelper javaScriptHelper=new JavaScriptHelper(driver);
		javaScriptHelper.clickElement(skip);
		return new HomePage(driver);
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO,s1);
		
	}

	
}
