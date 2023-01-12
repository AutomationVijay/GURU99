package LoginFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouFeedback {
		
	@FindBy(xpath = "//div[@class=\"fl\"]/h1") private WebElement message;
	
	public ThankYouFeedback(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	public String validateMessage()
	{
		String Text = message.getText();
		return Text;
    }
	
	

}
