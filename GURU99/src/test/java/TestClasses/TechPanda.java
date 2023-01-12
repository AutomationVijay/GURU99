package TestClasses;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import LibraryClass.BaseClass;
import LibraryClass.UtilityClass;
import POMClasses.Index;

public class TechPanda extends BaseClass {

	ExtentReports extent;
	ExtentSparkReporter spark;

	Index ind;

	private static Logger logger = LogManager.getLogger(TechPanda.class);

	/*
	 * public static void main(String[] args) {
	 * System.out.println("logger Tech Panda");
	 * 
	 * logger.info("This is information message or Passed Tech Panda");
	 * logger.trace("This is trace message"); logger.error("This is error message");
	 * logger.debug("This is debug message"); logger.warn("This is warn message");
	 * logger.fatal("This is fatal message"); // logger.off("This is off message");
	 * 
	 * System.out.println("logger end");
	 */

	@BeforeSuite
	public void Extends() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtendReport.html");
		extent.attachReporter(spark);

	}

	@BeforeClass()
	public void OpenBrowser() throws IOException {
		ExtentTest test = extent.createTest("OpenBrowser");

		initialiseBrowser(UtilityClass.getData("URL"));
		logger.info("Browser Opened");
		test.pass("Browser Opened");
		Reporter.log("Browser Opened", true);

		ind = new Index(driver);

	}

	@Test()
	public void IndexPage() {
		try {
			ExtentTest test = extent.createTest("Check Login Function");
			String currentTitle = driver.getTitle();
			logger.info("Login Page Opened " + currentTitle);
			test.pass("Login Page Opened");
			Reporter.log("Login Page Opened", true);
			boolean ExpectedFirst = currentTitle.contains(UtilityClass.getData("homepage"));
			if (ExpectedFirst) {
				ind.IndexPage();
				logger.info("Current Page is Home Page as Expected");
				test.pass("Current Page is Home Page as Expected");
				Reporter.log("Current Page is Home Page as Expected", true);

			} else {
				logger.info("Current Page is Not Home Page as Expected");
				test.fail("Page is not Home Page as Expected");
				Reporter.log("Page is not Home Page as Expected", true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void Close() {
		ExtentTest test = extent.createTest("Close Browser");
		logger.info("Browser Closed");
		test.pass("Browser Closed");
		Reporter.log("Browser Closed", true);

	}

	@AfterSuite
	public void ExtendEnd() {
		driver.close();
		extent.flush();

	}

}
