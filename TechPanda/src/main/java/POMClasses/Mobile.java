package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mobile {
	@FindBy(xpath = "(//select[@title=\"Sort By\"])[1]") private WebElement sort;
	@FindBy(xpath = "//div/h2/a[contains(text(),\"Sony Xperia\")]//..//..//span[@class=\"price\"]") private WebElement amount;
	@FindBy(xpath = "//div/h2/a[contains(text(),\"Sony Xperia\")]") private WebElement XperiOpen;
	public Mobile(WebDriver POM) {
		PageFactory.initElements(POM, this);
	}

	public WebElement sortBy() {
		sort.click();
		return sort;

	}
	public String getAmount()
	{
		String t = amount.getText();
		return t;
	}

	public void OpenXperia()
	{
		XperiOpen.click();
	}


}
