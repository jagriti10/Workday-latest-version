package automation.workday.workday.helper.browserConfiguration.config;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public automation.workday.workday.helper.browserConfiguration.BrowserType getBrowserType();
	public String getUrl();
	public String getEmail();
	public String getPassword();


}
