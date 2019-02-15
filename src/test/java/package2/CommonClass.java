package package2;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gargoylesoftware.htmlunit.javascript.host.event.MediaStreamEvent;

public class CommonClass {
	public String someScreenshotPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Windows.PNG";

	private static ExtentReports extentReports;
	ThreadLocal<ExtentTest> parentThread = new ThreadLocal<ExtentTest>();
	public ThreadLocal<ExtentTest> childThread = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void beforeSuite_in_CommonClass_in_package2() {
		System.out.println("beforeSuite_in_CommonClass_in_package2()");
		extentReports = new ExtentManager().getInstance();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

	}

	@BeforeTest
	public void beforeTest_in_CommonClass_in_package2() {
		System.out.println("\t beforeTest_in_CommonClass_in_package2()");
	}

	@BeforeClass
	public void beforeClass_in_CommonClass_in_package2() {
		System.out.println("\t \t beforeClass_in_CommonClass_in_package2()");
		ExtentTest parentTest = extentReports.createTest(getClass().getName());
		parentThread.set(parentTest);
	}

	@BeforeMethod
	public void beforeMethod_in_CommonClass_in_package2(Method method) {
		System.out.println("\t \t \t beforeMethod_in_CommonClass_in_package2()");
		ExtentTest childTest = parentThread.get().createNode(method.getName());
		childThread.set(childTest);

	}

	@AfterMethod
	public void afterMethod_in_CommonClass_in_package2(ITestResult testResult) throws Throwable {
		System.out.println("\t \t \t afterMethod_in_CommonClass_in_package2()");
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			childThread.get().pass("Test Passed");
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			childThread.get().fail("Test Failed with " + testResult.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(someScreenshotPath).build());
		} else if (testResult.getStatus() == ITestResult.SKIP) {
			childThread.get().skip("Test Skipped with " + testResult.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(someScreenshotPath).build());
		}
	}

	@AfterClass
	public void afterClass_in_CommonClass_in_package2() {
		System.out.println("\t \t afterClass_in_CommonClass_in_package2()");
	}

	@AfterTest
	public void aftertest_in_CommonClass_in_package2() {
		System.out.println("\t afterTest_in_CommonClass_in_package2()");
	}

	@AfterSuite
	public void afterSuite_in_CommonClass_in_package2() {
		System.out.println("afterSuite_in_CommonClass_in_package2()");
		extentReports.flush();
	}

	public static class ExtentManager {

		private static ExtentReports extentReports;

		public ExtentReports getInstance() {
			if (extentReports == null)
				createInstance(System.getProperty("user.dir") + "\\src\\test\\java\\package2\\extent.html");

			return extentReports;
		}

		public ExtentReports createInstance(String fileName) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("TestNG Extent Report");
			htmlReporter.config().setEncoding("UTF-8");
			htmlReporter.config().setReportName("Extent Reports for TestNG Tests");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);

			KlovReporter klovReporter = new KlovReporter();
			klovReporter.setKlovUrl("http://localhost:90");
			klovReporter.setProjectName("Parent Project");
			klovReporter.setReportName("Parent Project Report");
			klovReporter.initMongoDbConnection("localhost", 90);
			klovReporter.initKlovServerConnection("http://localhost:90");

			extentReports = new ExtentReports();
			extentReports.setSystemInfo("Host", System.getProperty("host"));
			extentReports.setSystemInfo("IP Address", System.getProperty("ip"));
			extentReports.setSystemInfo("Username", System.getProperty("user.name"));
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("OS Version", System.getProperty("os.version"));
			extentReports.setSystemInfo("Os Arch", System.getProperty("os.arch"));
			extentReports.setAnalysisStrategy(AnalysisStrategy.TEST);
			// extentReports.attachReporter(htmlReporter);
			// extentReports.attachReporter(klovReporter);
			extentReports.attachReporter(htmlReporter, klovReporter);

			return extentReports;
		}

	}
}
