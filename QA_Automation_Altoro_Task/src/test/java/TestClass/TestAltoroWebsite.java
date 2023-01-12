package TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LibraryFile.BaseClass;
import LibraryFile.UtilityClass;
import LoginFile.AccountHistoryPage;
import LoginFile.ContactUsPage;
import LoginFile.LoginPage;
import LoginFile.MyAccount;
import LoginFile.OnlineForm;
import LoginFile.SignInPage;
import LoginFile.ThankYouFeedback;
import LoginFile.TransactionHistory;
import LoginFile.TransferFund;
import LoginFile.signOff;


public class TestAltoroWebsite extends BaseClass {

	SignInPage signIn;
	LoginPage login;
	MyAccount MyAcc;
	AccountHistoryPage AccountPage;
	TransferFund fund;
	TransactionHistory history;
	ContactUsPage contact;
	OnlineForm form;
	ThankYouFeedback feedback;
	signOff logout;
	SoftAssert soft;

	@BeforeClass
	public void OpenBrowser() throws IOException {
		initialiseBrowser(UtilityClass.getData("URL"));
		signIn = new SignInPage(driver);
		login = new LoginPage(driver);
		MyAcc = new MyAccount(driver);
		AccountPage = new AccountHistoryPage(driver);
		fund = new TransferFund(driver);
		history = new TransactionHistory(driver);
		contact = new ContactUsPage(driver);
		form = new OnlineForm(driver);
		feedback = new ThankYouFeedback(driver);
		logout = new signOff(driver);
		soft = new SoftAssert();
	}

	@BeforeMethod
	public void SignIn() throws InterruptedException, IOException {

		signIn.clickSignInLink();
		login.SendUserName(UtilityClass.getData("UserName"));
		login.SendPassWord(UtilityClass.getData("Password"));
		login.clickLoginInbtn();
		String currentUrl = driver.getCurrentUrl();
		boolean ExpectedFirst = currentUrl.contains("login");
		if (ExpectedFirst) {
			Reporter.log("Login Failed! Enter correct Credential", true);
			login.SendUserName(UtilityClass.getData("UserName2"));
			login.SendPassWord(UtilityClass.getData("Password2"));
			login.clickLoginInbtn();
			Thread.sleep(3000);
			String currentURL = driver.getCurrentUrl();
			boolean ExpectedSecond = currentURL.contains("login");
			if (ExpectedSecond == false) {

				String User = MyAcc.VerifyUserLogin();

				Reporter.log("Login Successful with " + User + "", true);

			}

			else {
				Reporter.log("Enter Correct Credentials", true);
			}

		}

	}

	@Test
	public void TestCaseId() throws IOException, InterruptedException {

		MyAcc.clickViewAccSummry();
		MyAcc.clickViewAccDetails();
		MyAcc.clickCheckingOpt();
		MyAcc.clickOnGoBtn();

		String EndBalance = AccountPage.getEndingBalance();
		String AvlBalnce = AccountPage.getAvlBalance();
		System.out.println("Ending Balance " + EndBalance);
		System.out.println("Available Balance " + AvlBalnce);
		Assert.assertEquals(EndBalance, AvlBalnce, "Failed : Both Amount are Different");
		soft.assertAll();

		AccountPage.TransferFundLink();

		fund.clickToAcc();
		fund.clickselectAccount();
		fund.SendAmount(UtilityClass.getData("Amount"));
		fund.clickTransferMoney();
		fund.getTransAmount();
		fund.clickTransactionHistory();

		String TextVal1row = history.ColumnAmountForFirstRow();
		String TextVal2row = history.ColumnAmountForSecondRow();
		boolean ExpText1Row = TextVal1row.contains(UtilityClass.getData("Amount"));
		boolean ExpText2Row = TextVal2row.contains(UtilityClass.getData("Amount"));
		if (ExpText1Row && ExpText2Row) {
			Reporter.log("Data Matched Successfull", true);
		} else {
			Reporter.log("Data Mismatched", true);
			
		}
		
		history.clickContactUs();

		contact.clickOnlineForm();
		form.sendEmail(UtilityClass.getData("Email"));
		form.sendSubject(UtilityClass.getData("Subject"));
		form.sendComment(UtilityClass.getData("Comment"));
		form.clickSubmit();

		String Validatemsg = feedback.validateMessage();
		if (Validatemsg.contains("Thank")) {
			Reporter.log("Message Displayed " + Validatemsg + "", true);
		} else {
			Reporter.log("Message Not Didplayed " + Validatemsg + "",true);
		}

		logout.clickLogOut();
		String logOutAccVerify = driver.getCurrentUrl();
		boolean logOutStatus = logOutAccVerify.contains("index");
		if (logOutStatus) {
			Reporter.log("Sign Off Sucessfully", true);
		} else {
			Reporter.log("Sign Off Not Success", true);
		}

		driver.close();
	}

}
