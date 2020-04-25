package automation.workday.workday.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import automation.workday.workday.helper.assertions.AssertionHelper;
import automation.workday.workday.helper.browserConfiguration.config.ObjectReader;
import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.pageFunctions.LoginPage;
import automation.workday.workday.testBase.TestBase;

public class LoginTest extends TestBase {
	
	private final Logger log=LoggerHelper.getLogger(LoginTest.class);
	
	@Test
	public void testLoginPage() {
		
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage login=new LoginPage(driver);
		
		login.loginToApplication(ObjectReader.reader.getEmail(),ObjectReader.reader.getPassword());
		
		AssertionHelper.verifyText(login.getTitleOfPage(),"Google Accounts");
	}

}
