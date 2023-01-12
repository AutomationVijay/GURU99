package LoginFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signOff {
	
	
	@FindBy(xpath = "//a[@id=\"LoginLink\"]") private WebElement logOut;
	
	public signOff(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	public void clickLogOut()
	{
		logOut.click();
	}

}
