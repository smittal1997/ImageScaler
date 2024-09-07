package scaler;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadUpScaleImage extends BaseTest {
	
	@Test
	public void createAccount() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//button[contains(text(), 'Continue with Email')]")).click();
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("satyammittal@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.xpath("//input[@name='owner_name']")).sendKeys("satyammittal");
		driver.findElement(By.id("next")).click();	
		Thread.sleep(3000);
	}
	
	
	@Test
	public void DownloadFile() throws InterruptedException
	{
		String Filename = "output_image.jpeg";
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(), 'Download')])[1]"))).click();
		File file = new File("C:\\Users\\Ranosys\\Downloads\\"+Filename);
		Thread.sleep(3000);
		
		
		Assert.assertTrue(file.exists(), "Image file was not downloaded.");
	}
}
