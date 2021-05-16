package testUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Constants;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentHtmlReporter report;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeTest
	public void beforeTestMethod() {

		// Set Report Properties
		report = new ExtentHtmlReporter(
				System.getProperty("user.dir") + File.separator + "reports" + File.separator + "HTMLReport.html");
		report.config().setEncoding("utf-8");
		report.config().setDocumentTitle("Automation Report");
		report.config().setReportName("Sample Automation Test Report");
		report.config().setTheme(Theme.STANDARD);

		// 1. Create Extent Report Object
		// 2. Attach HTML Report
		// 3. Set System Info
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Author", "Dibya Saha");
	}

	@BeforeMethod
	@Parameters(value = { "browserName" })
	public void beforeMethodMethod(String browserName, Method testMethod) {

		// Create Test
		logger = extent.createTest(testMethod.getName());

		setUp(browserName);
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethodMethod(ITestResult result) {

		String methodName = result.getMethod().getMethodName();

		if (result.getStatus() == ITestResult.SUCCESS) {
			String logText = "TestCase: " + methodName + " passed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String logText = "TestCase: " + methodName + " failed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL, m);
		} else if (result.getStatus() == ITestResult.SKIP) {
			String logText = "TestCase: " + methodName + " skipped";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
			logger.log(Status.SKIP, m);
		}

		driver.quit();
	}

	@AfterTest
	public void afterTestMethod() {

		extent.flush();
	}

	public void setUp(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
			driver = new ChromeDriver();
		}
	}
}