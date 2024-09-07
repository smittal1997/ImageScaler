package scaler;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class invalidFileUpload extends BaseTest {
	
	@Test()
	public void uploadInvalidFile() throws InterruptedException, AWTException
	{
		driver.get(siteUrl);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		uploadButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uploadButtonXpath)));
		Thread.sleep(2000);
		
		uploadButton.click();
		//Thread.sleep(2000);
		
		uploadFile(invalidTextFilePath); //Uploading the invalid file
	} 
}
