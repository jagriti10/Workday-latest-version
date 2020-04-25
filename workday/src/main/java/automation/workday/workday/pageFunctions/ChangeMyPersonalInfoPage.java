package automation.workday.workday.pageFunctions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import automation.workday.workday.helper.assertions.VerificationHelper;
import automation.workday.workday.helper.javascript.JavaScriptHelper;
import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.helper.wait.WaitHelper;
import automation.workday.workday.pageObject.ChangeMyPersonalInfoOR;
import automation.workday.workday.testBase.TestBase;

public class ChangeMyPersonalInfoPage extends ChangeMyPersonalInfoOR  {

	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	public ChangeMyPersonalInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waitHelper=new WaitHelper(driver); 
		waitHelper.pageLoadTime(30, TimeUnit.SECONDS);
		new TestBase().getNavigationScreen(driver);
		logExtentReport("Login Page object created");
	}
	
	public String getTitleOfPage(){
		log.info("getting Title of MyAccount Page");
		logExtentReport("getting title of MyAccount page");
		return new VerificationHelper(driver).getTitleOfCurrentPage();
	}
	
	public void addcomment() {
		log.info("adding comment to the Personal Information");
		logExtentReport("adding comment to the Personal Information");
		JavaScriptHelper javascriptHelper=new JavaScriptHelper(driver);
		javascriptHelper.scrollDownVertically();
		textArea.sendKeys("This is for Automation");
				
	}
	
	public boolean verifyCommentTyped() {
	   return new VerificationHelper(driver).isDisplayed(textArea);
	}
	
	public void clearComment() {
		log.info("Clearing Comment added");
		logExtentReport("Clearing Comment added");
		textArea.clear();
	}
	
	public void clickOnSubmit() {
		log.info("clicking on submit button");
		logExtentReport("clicking on submit button");
		submit.click();
		
	}
	
	public SubmissionPage addCommentClearAndSubmit() {
		addcomment();
		verifyCommentTyped();
		clearComment();
		clickOnSubmit();
		return new SubmissionPage(driver);
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO,s1);
	}

}
