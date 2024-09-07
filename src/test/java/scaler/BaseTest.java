package scaler;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
	
	public static WebDriver driver;
	public static String url = "https://www.spyne.ai/image-upscaler";
	public static WebDriverWait wait ;
	public static String browser = "chrome";
	public static String uploadImageOptionXpath = "//input[@accept='image/*']";
	public static String uploadButtonXpath = "//img[@alt='Upload Icon']";
	public static String validImageFilePath = "C:\\Users\\Ranosys\\Downloads\\images.jpg";
	public static String resizeSectionXpath = "//h3[text()='Resize']" ;
	public static String siteUrl = "https://www.spyne.ai/image-upscaler";
	public static WebElement uploadButton;
	public static String invalidTextFilePath = "C:\\Users\\Ranosys\\Downloads\\sm.txt";
	public static String processButtonXpath = "//label[@for='upload']/following::button[1]" ;
	public static String downloadButtonXpath = "(//button[contains(text(), 'Download')])[1]";
	public static String imageScaleUpXpath = "//div[@class='spinner z-10']";
	public static String afterImageXpath = "//img[@alt='After Image']";
	public ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	public static String ssname;
	public static Date d = new Date();
	public static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	
	@BeforeSuite
	public void setUp() 
	{	
		
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.get(siteUrl);
		driver.manage().window().maximize();
	}

	public static boolean isElementPresent(By by)
	{
		try {
		driver.findElement(by);
		return true;
		}catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	public void uploadFile(String filepath) throws InterruptedException, AWTException
	{
		 Robot robot = new Robot();
		 
		    // copying File path to Clipboard
		    StringSelection str = new StringSelection(filepath);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		    //Press Control&V to paste the above path
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    Thread.sleep(3000);
		    robot.keyPress(KeyEvent.VK_V);
		    Thread.sleep(3000);
		    
		    //Release Control & V buttons
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    
		    //Press Enter
		    robot.keyPress(KeyEvent.VK_ENTER);
		    //Release Enter
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		    //wait for the file to get uploaded
		    robot.delay(2000);
		    Thread.sleep(15000);
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}
}
