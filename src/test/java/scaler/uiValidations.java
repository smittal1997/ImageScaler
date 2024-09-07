package scaler;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class uiValidations extends BaseTest {
	
	
	@Test
	public void TestCase5() throws IOException
	{
		WebElement uploadButton = driver.findElement(By.xpath(processButtonXpath));
		String getUploadButtonName = uploadButton.getText();
		try {
			Assert.assertEquals(getUploadButtonName , "Upload", "Upload Button is not present");
		
		} catch (Throwable t) {
			TestUtil.captureScreenshot();
			Reporter.log("verification failure"+t.getMessage());
			Reporter.log("<br>");
			Reporter.log("Verification Failure Screenshot");
			Reporter.log("<img src ="+BaseTest.ssname+">Screenshot</img>");
			Reporter.log("<br>");
		} 
		
		
		WebElement DownloadButton = driver.findElement(By.xpath(downloadButtonXpath));
		String getDownloadButtonName = DownloadButton.getText();
		try {
			
			Assert.assertEquals(getDownloadButtonName , "Upload", "Download Button is not present");

			
		} catch (Throwable t) {
			TestUtil.captureScreenshot();
			Reporter.log("verification failure"+t.getMessage());
			Reporter.log("<br>");
			Reporter.log("Verification Failure Screenshot");
			Reporter.log("<img src ="+BaseTest.ssname+">Screenshot</img>");
			Reporter.log("<br>");
		} 
	
		WebElement imagePreview = driver.findElement(By.xpath(afterImageXpath));
		String getimagePreviewAttr = imagePreview.getAttribute("alt");
		Assert.assertEquals(getimagePreviewAttr , "After Image", "After Image is not present");
	}
}
