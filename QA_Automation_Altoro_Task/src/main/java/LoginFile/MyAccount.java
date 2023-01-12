package LoginFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	

	@FindBy(xpath = "//a[@id=\"MenuHyperLink1\"]") private WebElement ViewAccSummary;
	@FindBy(xpath = "//*[@name=\"listAccounts\"]") private WebElement ClickAccDetails;
	@FindBy(xpath = "//option[@value=\"800001\"]") private WebElement SelectChecking  ;
	@FindBy(xpath = "//input[@id=\"btnGetAccount\"]") private WebElement GoBtn;
	@FindBy(xpath = "//h1[contains(text(),\"Hello\")]") private WebElement LoginStatus;
	
	public MyAccount(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	
	public void clickViewAccSummry()
	{
		ViewAccSummary.click();
    }
	public void clickViewAccDetails()
	{
		ClickAccDetails.click();
}
	public void clickCheckingOpt()
	{
		SelectChecking.click();
}
	public void clickOnGoBtn()
	{
		GoBtn.click();
    }
	
	public String VerifyUserLogin()
	{
		String Text = LoginStatus.getText();
		
		return Text;
		
	}
	
	
}
