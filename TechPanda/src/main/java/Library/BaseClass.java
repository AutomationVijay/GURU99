package Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	public void initialiseBrowser(String url) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notification");
		
		FirefoxProfile ffoption = new FirefoxProfile();
		ffoption.setPreference("dom.webnotifications.enabled", false);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
	//	driver = new FirefoxDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
	}

}
