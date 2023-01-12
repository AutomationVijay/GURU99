package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartVerification {

	@FindBy(xpath = "(//*[@class=\"level0 \"])[1]") private WebElement mobile;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]") private WebElement cart;
	@FindBy(xpath = "//input[@title=\"Qty\"]") private WebElement quantity;
	@FindBy(xpath = "//button[@title=\"Update\"]") private WebElement update;
	@FindBy(xpath = "//span[text()='Some of the products cannot be ordered in requested quantity.']") private WebElement message;
	@FindBy(xpath = "//button[@title=\"Empty Cart\"]") private WebElement empty;
	@FindBy(xpath = "//div[@class=\"cart-empty\"]") private WebElement isEmpty;


	public CartVerification(WebDriver POM)
	{
		PageFactory.initElements(POM, this);
	}

	public void Mobiles()
	{
		mobile.click();
	}

	public void Cart()
	{
		cart.click();
	}

	public void Quantity(String Amount)
	{
		quantity.clear();
		quantity.sendKeys(Amount);
	}

	public void Updates()
	{
		update.click();
	}

	public WebElement Message()
	{
		message.getText();
		return message;
	}

	public void Empty()
	{
		isEmpty.getText();
	}




}
