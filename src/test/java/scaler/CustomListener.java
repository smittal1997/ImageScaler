package scaler;
import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CustomListener extends BaseTest implements ITestListener,ISuiteListener {
	
	
	public void onTestStart(ITestResult result) {

		ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
	}	
	
	
	public void onTestFailure(ITestResult result)
	{
		System.setProperty("org.uncommons.reportng.escape-output","false");
		
		try {
			TestUtil.captureScreenshot();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		Reporter.log("Capturing Screenshot");
		Reporter.log("<img src ="+TestUtil.ssname+">Screenshot</img>");
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);

	}
	
	public void onTestSuccess(ITestResult result)
	{
		String methodName= result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
	} 
	
	public void onFinish(ITestContext context) {
		
		if (extent != null) {

			extent.flush();
		}

	}
	
}
	