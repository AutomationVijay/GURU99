package LoginFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
		
	@FindBy(xpath = "//a[text()=\"online form\"]") private WebElement feedbackForm;
	
	public ContactUsPage(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	public void clickOnlineForm()
	{
		feedbackForm.click();
    }

}
