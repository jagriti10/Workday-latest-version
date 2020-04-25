package automation.workday.workday.pageFunctions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import automation.workday.workday.helper.assertions.VerificationHelper;
import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.helper.wait.WaitHelper;
import automation.workday.workday.pageObject.HomeOR;
import automation.workday.workday.testBase.TestBase;

public class HomePage extends HomeOR {
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waitHelper=new WaitHelper(driver); 
		waitHelper.pageLoadTime(30, TimeUnit.SECONDS);
		new TestBase().getNavigationScreen(driver);
		logExtentReport("Home Page object created");
	}
	
	public String getTitleOfPage(){
		log.info("getting Title of Home Page");
		logExtentReport("getting title of Home page");
		return new VerificationHelper(driver).getTitleOfCurrentPage();
	}
	
	public String getUserWelcomeCard() {
		log.info("verifying user from welcome card");
		logExtentReport("verifying user from welcome card");
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript("return document.getElementByClassName('workdayHome-j').innerHTML").toString();
	}
	
	public void clickOnPersonalInfo() {
		log.info("clicking on personal information selection option");
		logExtentReport("clicking on personal information selection option");
		personalInfoSelectionOption.click();
	}
	
	public PersonalInfoPage actionsOnHomePage() {
		getUserWelcomeCard();
		clickOnPersonalInfo();
		return new PersonalInfoPage(driver);
	}
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO,s1);
	}

	

}
