package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Index {

	@FindBy(xpath = "(//*[@class=\"level0 \"])[1]") private WebElement mobile;

	public Index(WebDriver POM) {
		PageFactory.initElements(POM, this);
	}

	public void IndexPage() {
		mobile.click();
	}

}
