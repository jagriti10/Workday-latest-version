package automation.workday.workday.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser {
	

		public ChromeOptions getChromeOptions() {
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--test-type");
			option.addArguments("--disable-popup-blocking");
			
			DesiredCapabilities chrome = DesiredCapabilities.chrome();
			chrome.setJavascriptEnabled(true);
			
			option.setCapability(ChromeOptions.CAPABILITY, chrome);	
			//Linux
			if(System.getProperty("os.name").contains("Linux")){
				option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
			}
			return option;
		}
		
		public WebDriver getChromeDriver(ChromeOptions cap) {

			if (System.getProperty("os.name").contains("Mac")){
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver(cap);
			}
			else if(System.getProperty("os.name").contains("Window")){
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver(cap);
			}
			else if(System.getProperty("os.name").contains("Linux")){
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver(cap);
			}
			return null;
		}
	
		

	}


