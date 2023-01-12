package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class UtilityClass
{
	public static String getData(String key) throws IOException
	{
			FileInputStream file = new FileInputStream("Property.properties");
			Properties property = new Properties();
			property.load(file);
			property.getProperty(key);
			String value = property.getProperty(key);
			return value;
	}

	public static void CaptureScreenShot(WebDriver driver, int TCID) throws IOException
	{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String rs = RandomString.make(2);
			System.out.println(TCID);
			File dest = new File("F:\\MyJAVA\\Eclipse\\TechPanda\\ScreenShot\\"+TCID+""+rs+".jpg");
			FileHandler.copy(src, dest);


	}


}
