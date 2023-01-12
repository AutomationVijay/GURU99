package LoginFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFund {
		
	
	@FindBy(xpath = "//select[@id=\"toAccount\"]") private WebElement toAccount;
	@FindBy(xpath = "(//select[@id=\"toAccount\"])/option[2]") private WebElement selectAcc;
	@FindBy(xpath = "//input[@id=\"transferAmount\"]") private WebElement AmountToBeTranfer;
	@FindBy(xpath = "(//select[@id=\"toAccount\"])/option[2]") private WebElement AmountCheck;
	@FindBy(xpath = "//input[@id=\"transfer\"]") private WebElement AmountTransfer;
	@FindBy(xpath = "//span[contains(text(),\"9876\")]") private WebElement AmountVerify;
	
	@FindBy(xpath = "//a[@id=\"MenuHyperLink2\"]") private WebElement recentTransaction;
	
	public TransferFund(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	
	public void clickToAcc()
	{
		toAccount.click();
    }

	
	public void clickselectAccount()
	{
		selectAcc.click();
    }
	
	public void SendAmount(String TransferAmt )
	{
		AmountToBeTranfer.sendKeys(TransferAmt);	
	}
	
	public String AmountVerify()
	{
		String Text = AmountCheck.getText();
		return Text;
    }
	
	public void clickTransferMoney()
	{
		AmountTransfer.click();
    }
	
	public String getTransAmount()
	{
		String Text = AmountVerify.getText();
		return Text;
    }
	
	public void clickTransactionHistory()
	{
		recentTransaction.click();
    }
}
