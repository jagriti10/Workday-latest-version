package automation.workday.workday.testScripts;

import org.testng.annotations.Test;

import automation.workday.workday.helper.assertions.AssertionHelper;
import automation.workday.workday.helper.browserConfiguration.config.ObjectReader;
import automation.workday.workday.pageFunctions.HomePage;
import automation.workday.workday.pageFunctions.LoginPage;
import automation.workday.workday.pageFunctions.RememberDevicePage;
import automation.workday.workday.testBase.TestBase;

public class RememberDeviceTest extends TestBase {
	
	LoginPage login;
	RememberDevicePage rememberDevice;
	HomePage home;
	
	@Test
	public void testRememberDevice() {
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage login=new LoginPage(driver);
		RememberDevicePage rememberDevice=new RememberDevicePage(driver);

		rememberDevice=login.loginToApplication(ObjectReader.reader.getEmail(),ObjectReader.reader.getPassword());
		
		//click on skip on rememberdevicepage
		home = rememberDevice.clickOnSkip();
		
		AssertionHelper.verifyNotNull(home);
		
	}

}
