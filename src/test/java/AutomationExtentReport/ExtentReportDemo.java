package AutomationExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportDemo {
	ExtentReports extent ;
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"//reports//report.html";
		ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results" );
		reporter.config().setDocumentTitle("Test Result");
		 extent =  new ExtentReports();
		 extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","ABC");
	}
	@Test
	public void initialDemo() {
		extent.createTest("Initial demo");
		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver.exe");
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		extent.flush();
	}
}
