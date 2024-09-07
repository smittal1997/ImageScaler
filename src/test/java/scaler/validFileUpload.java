package scaler;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class validFileUpload extends BaseTest {
	
	@Test
	public void TestCase2() throws InterruptedException, AWTException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		uploadButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uploadButtonXpath)));
		Thread.sleep(5000);
		
		uploadButton.click();
		uploadFile(validImageFilePath);//Select & upload the file
		
		//Verifying if Resize section appears then image uploaded successfully 
		Assert.assertTrue(isElementPresent(By.xpath(resizeSectionXpath)), "File not uploaded");
		Reporter.log("File Upload Successfully");
	}
}