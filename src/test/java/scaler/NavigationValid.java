package scaler;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationValid extends BaseTest {

	@Test
	public void TestCase1()
	{

		String getUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, getUrl); //Verifying the Same Correct URL Loaded
		
		//Verify the Main Element Upload is displayed
		Assert.assertTrue(isElementPresent(By.xpath(uploadImageOptionXpath)), "Image Upload Section Not Present");
	}
	
}
