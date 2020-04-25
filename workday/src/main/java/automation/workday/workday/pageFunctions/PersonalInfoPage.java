package automation.workday.workday.pageFunctions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import automation.workday.workday.helper.assertions.VerificationHelper;
import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.helper.wait.WaitHelper;
import automation.workday.workday.pageObject.PersonalInfoOR;
import automation.workday.workday.testBase.TestBase;

public class PersonalInfoPage extends PersonalInfoOR {
	
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	public PersonalInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waitHelper=new WaitHelper(driver); 
		waitHelper.WaitForElementClickable(personalInfoListItem, 30);
		new TestBase().getNavigationScreen(driver);
		logExtentReport("Personal Info Page object created");
	}
	
	public String getTitleOfPage(){
		log.info("getting Title of PersonalInfo Page");
		logExtentReport("getting title of PersonalInfo page");
		return new VerificationHelper(driver).getTitleOfCurrentPage();
	}
	
	public ChangeMyPersonalInfoPage clickOnPersonalInfoListItem() {
		log.info("clicking on personal Information list item");
		logExtentReport("clicking on personal Information list item");
		personalInfoListItem.click();
		return new ChangeMyPersonalInfoPage(driver);
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO,s1);
	}


}
