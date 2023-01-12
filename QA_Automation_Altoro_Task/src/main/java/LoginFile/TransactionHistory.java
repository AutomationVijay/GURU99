package LoginFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionHistory {
	
	@FindBy(xpath = "(//*[contains(@id,\"Main_MyTransactions\")]/tbody/tr[2]/td)[last()]") private WebElement TextAmountforColOne;
	@FindBy(xpath = "(//*[contains(@id,\"Main_MyTransactions\")]/tbody/tr[3]/td)[last()]") private WebElement TextAmountforColTwo;
	
	@FindBy(xpath = "//a[@id=\"HyperLink3\"]") private WebElement contactUs;
	
	public TransactionHistory(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	public String ColumnAmountForFirstRow()
	{
		String Text = TextAmountforColOne.getText();
		return Text;
    }
	public String ColumnAmountForSecondRow()
	{
		String Text = TextAmountforColTwo.getText();
		return Text;
    }	

	public void clickContactUs()
	{
		contactUs.click();
    }
	
}
