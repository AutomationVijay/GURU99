package LoginFile;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {
	
	@FindBy(xpath="//a[@id=\"LoginLink\"]") private WebElement SignInLink;
	
	public SignInPage(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	public void clickSignInLink()
	{
		SignInLink.click();
	}
}