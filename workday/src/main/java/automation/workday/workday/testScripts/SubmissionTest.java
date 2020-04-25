package automation.workday.workday.testScripts;

import org.testng.annotations.Test;

import automation.workday.workday.helper.assertions.AssertionHelper;
import automation.workday.workday.helper.browserConfiguration.config.ObjectReader;
import automation.workday.workday.pageFunctions.ChangeMyPersonalInfoPage;
import automation.workday.workday.pageFunctions.HomePage;
import automation.workday.workday.pageFunctions.LoginPage;
import automation.workday.workday.pageFunctions.PersonalInfoPage;
import automation.workday.workday.pageFunctions.RememberDevicePage;
import automation.workday.workday.pageFunctions.SubmissionPage;
import automation.workday.workday.testBase.TestBase;

public class SubmissionTest extends TestBase {

	LoginPage login;
	RememberDevicePage rememberDevice;
	HomePage home;
	PersonalInfoPage personalInfo;
	ChangeMyPersonalInfoPage changeMyInfo;
	SubmissionPage submission;
	
	@Test
	public void testPersonalInfoPage() {
		
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPage login=new LoginPage(driver);
		RememberDevicePage rememberDevice=new RememberDevicePage(driver);
		HomePage home=new HomePage(driver);
		PersonalInfoPage personalInfo=new PersonalInfoPage(driver);
		ChangeMyPersonalInfoPage changeMyInfo=new ChangeMyPersonalInfoPage(driver);
		SubmissionPage submission=new SubmissionPage(driver);
		
		login.loginToApplication(ObjectReader.reader.getEmail(),ObjectReader.reader.getPassword());
		rememberDevice.clickOnSkip();
		home.actionsOnHomePage();
		personalInfo.clickOnPersonalInfoListItem();
		submission=changeMyInfo.addCommentClearAndSubmit();
		
		submission=submission.getSubmissionHeader();
	
		AssertionHelper.verifyNotNull(submission);
		AssertionHelper.verifyText(submission.getTitleOfPage(),"Change My Personal Information - Workday");
	}
}
