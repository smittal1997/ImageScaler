package scaler;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ImgeUpScaling extends BaseTest {
	
	@Test
	public void verifyImageUpsacling() throws InterruptedException, AWTException, IOException
	{
		driver.get(siteUrl);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		uploadButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Upload Icon']")));
		Thread.sleep(2000);
		
		uploadButton.click();
		Thread.sleep(2000);
			
		uploadFile(validImageFilePath); //Upload the valid file

		driver.findElement(By.xpath(processButtonXpath)).click(); // click on process button for upscaling
		Thread.sleep(2000);
		
		Assert.assertTrue(isElementPresent(By.xpath(imageScaleUpXpath)), "Start Image ScaleUp");
		Thread.sleep(3000);
		
		//Checking Image has been scaleup then download button appears
	//	Assert.assertTrue(isElementPresent(By.xpath(downloadButtonXpath)), "File ScaledUp Successfully");
		
		try {
			Assert.assertTrue(isElementPresent(By.xpath(downloadButtonXpath)), "File ScaledUp Successfully");
			
		} catch (Throwable t) {
			TestUtil.captureScreenshot();
			Reporter.log("verification failure"+t.getMessage());
			Reporter.log("<br>");
			Reporter.log("Verification Failure Screenshot");
			Reporter.log("<img src ="+BaseTest.ssname+">Screenshot</img>");
			Reporter.log("<br>");
		} 
	}

}
