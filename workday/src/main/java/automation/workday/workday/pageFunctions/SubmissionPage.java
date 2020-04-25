package automation.workday.workday.pageFunctions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import automation.workday.workday.helper.assertions.VerificationHelper;
import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.helper.wait.WaitHelper;
import automation.workday.workday.pageObject.SubmissionOR;
import automation.workday.workday.testBase.TestBase;

public class SubmissionPage extends SubmissionOR {
	
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	public SubmissionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waitHelper=new WaitHelper(driver); 
		waitHelper.pageLoadTime(30, TimeUnit.SECONDS);
		new TestBase().getNavigationScreen(driver);
		logExtentReport("Submission Page object created");
	}
	
	public String getTitleOfPage(){
		log.info("getting Title of Submission Page");
		logExtentReport("getting title of Submission page");
		return new VerificationHelper(driver).getTitleOfCurrentPage();
	}
	
	public SubmissionPage getSubmissionHeader() {
		log.info("getting submission header of Home Page");
		logExtentReport("getting submission header of Home page");
		submittedheader.getText();
		return new SubmissionPage(driver);
		
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO,s1);
	}


}
