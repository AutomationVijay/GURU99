package LoginFile;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineForm {
	
	@FindBy(xpath = "//input[@name=\"email_addr\"]") private WebElement email;
	@FindBy(xpath = "//input[@name=\"subject\"]") private WebElement subject;
	@FindBy(xpath = "//textarea[@name=\"comments\"]") private WebElement comment;
	@FindBy(xpath = "//input[@name=\"submit\"]") private WebElement submit;

	public OnlineForm(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}
	public void sendEmail(String emailID )
	{
		email.sendKeys(emailID);	
	}
	
	public void sendSubject(String sub )
	{
		subject.sendKeys(sub);	
	}
	
	public void sendComment(String comments )
	{
		comment.sendKeys(comments);	
	}
	
	public void clickSubmit()
	{
		submit.click();
    }
}
