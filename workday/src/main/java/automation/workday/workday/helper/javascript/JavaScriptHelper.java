package automation.workday.workday.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.workday.workday.helper.logger.LoggerHelper;

public class JavaScriptHelper {
	
	private WebDriver driver;
	
	private Logger log=LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JavaScriptHelper has been initialised");
	}
	
	public Object executeScript(String script) {
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	public Object executeScript(String script,Object...args) {
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		return exe.executeScript(script, args);
	}
	
	public void scrollDownVertically(){
		log.info("scrolling down vertically...");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public void zoomInBy100Percentage(){
		executeScript("document.body.style.zoom='100%'");
	}
	
	public void zoomInBy60Percentage(){
		executeScript("document.body.style.zoom='40%'");
	}
	
	public void clickElement(WebElement element){
		executeScript("arguments[0].click();", element);
	}
	
//	public String getTextfromPage(WebElement element) {
//		//JavascriptExecutor exe = (JavascriptExecutor)driver;
//		String text = executeScript("return document.getElementById('some_id').innerHTML").toString();
//		return text;
//	}
	

}
