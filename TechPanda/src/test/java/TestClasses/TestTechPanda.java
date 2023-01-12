package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Library.BaseClass;
import Library.UtilityClass;
import POMClasses.CartVerification;
import POMClasses.Index;
import POMClasses.Mobile;
import POMClasses.XperiaPage;

public class TestTechPanda extends BaseClass {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtendReport.html");

	//static final Logger logs = (Logger) LogManager.getLogger("TestTechPanda.class");

	Index ind;
	Mobile mob;
	XperiaPage exp;
	CartVerification cart;
	int TCID;

	@BeforeClass()
	public void OpenBrowser() {
		try {
			ExtentTest test = extent.createTest("Verify Report and Analytics");

			initialiseBrowser(UtilityClass.getData("URL"));
	//		logs.info("Browser Opened");
			test.pass("Browser Opened");
			Reporter.log("Browser Opened", true);

			ind = new Index(driver);
			mob = new Mobile(driver);
			exp = new XperiaPage(driver);
			cart = new CartVerification(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod()
	public void ExtendRep() {

		extent.attachReporter(spark);
	}

	@Test
	public void IndexPage() {
		try {
			ExtentTest test = extent.createTest("Verify Report and Analytics");
			TCID = 101;
			String currentTitle = driver.getTitle();
			System.out.println(currentTitle);
			boolean ExpectedFirst = currentTitle.contains(UtilityClass.getData("homepage"));
			if (ExpectedFirst) {
				ind.IndexPage();
				test.pass("Current Page is Home Page as Expected");
				Reporter.log("Current Page is Home Page as Expected", true);
			} else {
				test.fail("Page is not Home Page as Expected");
				Reporter.log("Page is not Home Page as Expected", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test()
	public void Mobile() {
		try {
			ExtentTest test = extent.createTest("Verify Report and Analytics");
			TCID = 102;
			String currentUrl = driver.getCurrentUrl();
			boolean ExpectedUrl = currentUrl.contains(UtilityClass.getData("Mobile"));
			if (ExpectedUrl) {
				test.pass("Current Page is Mobile Page as Expected ");
				Reporter.log("Current Page is Mobile Page as Expected", true);
				mob.sortBy();
				Select sorts = new Select(mob.sortBy());
				sorts.selectByVisibleText("Name");
				Thread.sleep(2000);
				String URLsort = driver.getCurrentUrl();
				boolean isSort = URLsort.contains("name");
				if (isSort) {
					test.pass("Current page is sorted as Name");
					Reporter.log("Current Page is sorted as Name", true);
				} else {
					test.pass("Current page is Not sorted as Name");
					Reporter.log("Current Page is Not sorted as Name");

				}
				// mob.OpenXperia();
			} else {
				test.fail("Page is not Mobile Page as Expected");
				Reporter.log("Page is not Mobile Page as Expected", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void XperiaMobile() {
		try {
			ExtentTest test = extent.createTest("Verify Report and Analytics");
			TCID = 103;
			String amnt = mob.getAmount();
			mob.OpenXperia();
			Thread.sleep(2000);
			String currentUrl = driver.getCurrentUrl();
			boolean ExpectedUrl = currentUrl.contains(UtilityClass.getData("Xperia"));

			if (ExpectedUrl) {
				test.pass("Current Page is Xperia Page as Expected ");
				Reporter.log("Current Page is Xperia Page as Expected", true);
				String currentExp = exp.GetPrice();

				if (amnt.equalsIgnoreCase(currentExp)) {
					test.pass("Price of Mobile is Equal ");
					Reporter.log("Price of Mobile is Equal", true);
				} else {
					test.pass("Price is not Equal");
					Reporter.log("Price is Not Equal", true);
				}
			} else {
				test.pass("Current Page is not Xperia Page as Expected ");
				Reporter.log("Current Page is Not Xperia Page as Expected", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void CartVerification() throws IOException {
		ExtentTest test = extent.createTest("Verify Report and Analytics");
		TCID = 104;
		driver.navigate().to(UtilityClass.getData("URL"));
		//driver.get(UtilityClass.getData("URL"));
		test.pass("Current Page is Card Verification as Expected ");
		cart.Mobiles();
		cart.Cart();
		cart.Quantity(UtilityClass.getData("Amount"));
		cart.Updates();
		WebElement ErrorMsg = cart.Message();
		String messages = ErrorMsg.toString();
		String ExpError = UtilityClass.getData("Error");
		Assert.assertEquals(messages, ExpError, "Got Error Message");
		cart.Empty();

	}

	@AfterMethod()
	public void FailedCase(ITestResult result) {
		try {
			if (ITestResult.FAILURE == result.getStatus()) {
				UtilityClass.CaptureScreenShot(driver, TCID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass()
	public void CloseBrowser() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@AfterTest()
	public void extRep() {
		extent.flush();

	}

}
