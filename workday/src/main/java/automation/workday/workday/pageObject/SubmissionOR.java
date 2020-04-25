package automation.workday.workday.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmissionOR {
	
	public SubmissionOR(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="//span[@data-automation-id='pageHeaderTitleText']")
	protected WebElement submittedheader;
}
