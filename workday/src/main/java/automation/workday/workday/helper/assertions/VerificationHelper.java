package automation.workday.workday.helper.assertions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.workday.workday.helper.logger.LoggerHelper;
import automation.workday.workday.testBase.TestBase;

public class VerificationHelper {
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDisplayed(WebElement element) {
			try {
				element.isDisplayed();
				log.info("element is displayed.."+element.getText());
				TestBase.logExtentReport("element is Displayed..."+element.getText());
				return true;
			}
			catch(Exception e) {
				log.error("element is not displayed.."+ e.getCause());
				TestBase.logExtentReport("element is not displayed.."+e.getMessage());
				return false;
			}
	}
	
	public String readValueFromElementAndCheckForEqual(WebElement element,String s) {
		if(null==element) {
			log.info("WebElement is null..");
			return null;
		}
		boolean status=isDisplayed(element);
		if(status) {
			if(element.getText()==s) {
				log.info("element text is ..."+element.getText());
				return element.getText();
				}
			else {
				return null;
			}
			}
		else {
			return null;
		}
	}
	
	public String getTitleOfCurrentPage() {
		log.info("page title is.."+driver.getTitle());
		return driver.getTitle();
	}
	

}
