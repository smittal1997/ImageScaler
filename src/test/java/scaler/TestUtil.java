package scaler;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class TestUtil extends BaseTest {
	
public static String ssname;
	
	public static void captureScreenshot() throws IOException
	{
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		ssname = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(System.getProperty("user.dir"));
		Files.copy(screenshot, new File(System.getProperty("user.dir")+"\\test-output\\html\\"+ssname));
	} 


}
