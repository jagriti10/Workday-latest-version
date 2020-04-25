package automation.workday.workday.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOR {

	public LoginOR(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	@FindAll({
//		@FindBy(xpath="//input[@type='text'])"),
//		@FindBy(id="Email")
//	})
//	protected WebElement email;
//	
//	@FindAll({
//		@FindBy(xpath="//input[@type='password']"),
//		@FindBy(id="password")
//	})
//	protected WebElement password;
//	
//	@FindBy(xpath="//input[@id='next']")
//	protected WebElement gmailNext;
//	
//	@FindAll({
//		@FindBy(xpath="//button[@data-automation-id='goButton']"),
//		@FindBy(xpath="//input[@id='password']")
//	})
//	protected WebElement submit;
//	
	
	@FindBy(xpath="//input[@id='Email']")
	protected WebElement email;
	
	@FindBy(id="password")
	protected WebElement password;
	
	@FindBy(id="next")
	protected WebElement next1;
	
	@FindBy(id="submit")
	protected WebElement next2;
	
}