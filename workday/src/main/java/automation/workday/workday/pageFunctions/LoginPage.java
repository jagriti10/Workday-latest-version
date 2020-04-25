package automation.workday.workday.pageFunctions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import automation.workday.workday.helper.assertions.VerificationHelper;
import automation.workday.workday.helper.browserConfiguration.config.ObjectReader;
import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.helper.wait.WaitHelper;
import automation.workday.workday.pageObject.LoginOR;
import automation.workday.workday.testBase.TestBase;

public class LoginPage extends LoginOR {


	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

		waitHelper=new WaitHelper(driver); 
		waitHelper.waitForElementVisible(email,ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		logExtentReport("Login Page object created");
	}

	public void enterEmailAddress(String emailAddress) {
		log.info("entering email address"+emailAddress);
		logExtentReport("entering email address"+emailAddress);
		email.sendKeys(emailAddress);
		next1.click();
	}

//	public boolean verifyEmailTyped() {
//		return new VerificationHelper(driver).isDisplayed(email);
//	}

	public void enterPassword(String password) {
		log.info("entering password "+password);
		logExtentReport("entering password"+password);
		this.password.sendKeys(password);
	}

//	public boolean verifyPasswordTyped() {
//		return new VerificationHelper(driver).isDisplayed(password);
//	}

	public void clickOnSubmitButton(){
		log.info("clicking on submit button....");
		logExtentReport("clicking on submit button....");
		next2.click();
		
	}
	
	public RememberDevicePage loginToApplication(String emailAddress,String password) {
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
		return new RememberDevicePage(driver) ;
	}
	
	public String getTitleOfPage(){
		log.info("getting Title of Home Page");
		logExtentReport("getting title of Home page");
		return new VerificationHelper(driver).getTitleOfCurrentPage();
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO,s1);
	}

}
