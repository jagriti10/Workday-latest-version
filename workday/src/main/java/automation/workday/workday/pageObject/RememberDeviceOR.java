package automation.workday.workday.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import automation.workday.workday.testBase.TestBase;

public class RememberDeviceOR {

	public RememberDeviceOR(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@data-automation-id='linkButton']")
	protected WebElement skip;

}
