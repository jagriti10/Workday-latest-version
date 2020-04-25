package automation.workday.workday.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.workday.workday.helper.logger.LoggerHelper;

public class WaitHelper {
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
		log.info("WaitHelper object created");
	}
	
	public void setImplicitWait(long timeout,TimeUnit unit) {
		log.info("Implicit Wait has been set to:"+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	private WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec) {
		WebDriverWait wait=new WebDriverWait(driver,timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		return wait;
	}
	
	public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
			int pollingEveryInMiliSec) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	public void waitForElementVisible(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	
	public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now");
	}
	
	private Wait<WebDriver> getfluentWait(int timeOutInSeconds,int pollingEveryInSec){
		Wait<WebDriver> fWait=new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class);
		return fWait;
	}
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInSec){
		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void pageLoadTime(long timeout, TimeUnit unit){
		log.info("waiting for page to load for : "+ unit+ " seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
	}
	
	}


