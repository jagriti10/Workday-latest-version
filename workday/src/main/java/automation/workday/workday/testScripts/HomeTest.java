package automation.workday.workday.testScripts;

import org.testng.annotations.Test;

import automation.workday.workday.helper.assertions.AssertionHelper;
import automation.workday.workday.helper.browserConfiguration.config.ObjectReader;
import automation.workday.workday.pageFunctions.HomePage;
import automation.workday.workday.pageFunctions.LoginPage;
import automation.workday.workday.pageFunctions.PersonalInfoPage;
import automation.workday.workday.pageFunctions.RememberDevicePage;
import automation.workday.workday.testBase.TestBase;

public class HomeTest extends TestBase{
	
	LoginPage login;
	RememberDevicePage rememberDevice;
	HomePage home;
	PersonalInfoPage personalInfo;
	
	@Test
	public void testHomePage() {
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage login=new LoginPage(driver);
		RememberDevicePage rememberDevice=new RememberDevicePage(driver);
		HomePage home=new HomePage(driver);
		
		//get previous pages
		login.loginToApplication(ObjectReader.reader.getEmail(),ObjectReader.reader.getPassword());
		home=rememberDevice.clickOnSkip();
		
		//check welcome card and click on personal info selection option
		home.actionsOnHomePage();
		
		AssertionHelper.verifyText(home.getUserWelcomeCard(),"Welcome, Jagriti Sharma (41785JS)");
	}
}
