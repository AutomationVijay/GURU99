package LoginFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountHistoryPage {

	
	
	@FindBy(xpath = "(//td[contains(text(),\"Ending \")]//..//..)[last()]") private WebElement EndingBal;
	@FindBy(xpath = "(//td[contains(text(),\"Available \")]//..//..)[last()]") private WebElement availableBal;
	
	@FindBy(xpath = "//a[@id=\"MenuHyperLink3\"]") private WebElement TranFundLink;
	
	

	public AccountHistoryPage(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	
	public String getEndingBalance()
	{
		String Text = EndingBal.getText();
		return Text;
    }
	public String getAvlBalance()
	{
		String Text = availableBal.getText();
		return Text;
    }
	
	public void TransferFundLink()
	{
		TranFundLink.click();
    }
}
