package automation.workday.workday.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import automation.workday.workday.helper.resource.ResourceHelper;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			String location= ResourceHelper.getResourcePath("scr/main/resources/reports/extent.html");
			return createInstance(location);
		}
		else {
			return extent;
		}
	}

	public static ExtentReports createInstance(String fileName) {
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle(fileName);
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName("Automation Report");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			return extent;
		}
	
}
