package LoginFile;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "uid")private WebElement UserName;
	@FindBy(id = "passw")private WebElement PassWord;
	@FindBy(name = "btnSubmit")private WebElement LoginBtn;
	@FindBy(xpath = "//span[contains(text(),\"Login Failed\")]") private WebElement FailedMsgVerify;
	
	
	public LoginPage(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	public void SendUserName(String UserNmae)
	{
		UserName.sendKeys(UserNmae);
	}
	
	public void SendPassWord(String PassWordUser)
	{
		PassWord.sendKeys(PassWordUser);
	}
	
	public void clickLoginInbtn()
	{
		LoginBtn.click();
     }
	public boolean  VerifyFailedMessageIsDisplayed()
	{
		boolean Status = FailedMsgVerify.isDisplayed();
		return Status;
	
     }
	
	
}
