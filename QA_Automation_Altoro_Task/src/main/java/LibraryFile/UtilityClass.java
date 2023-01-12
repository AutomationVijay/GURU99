package LibraryFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	

	public static String getData(String key) throws IOException {
		FileInputStream file = new FileInputStream(
				"PropertyFile.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}

}
