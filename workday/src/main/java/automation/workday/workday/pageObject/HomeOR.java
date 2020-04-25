package automation.workday.workday.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeOR {
	public HomeOR(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h1[@data-automation-id='landingPageWelcomeCardHeading']")
	protected WebElement userWelcomeCard;
	
	@FindBy(xpath="//div[@data-automation-id='landingPageWorkletSelectionOption' and @title='Personal Information']")
	protected WebElement personalInfoSelectionOption;
	
}