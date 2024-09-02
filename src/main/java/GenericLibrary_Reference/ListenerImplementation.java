package GenericLibrary_Reference;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}
	public void onFinish(ITestContext context) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		String testData = result.getMethod().getMethodName();

		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.Sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(src, new File("./ScreenShot/"+testData+".png"));
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
		
	}

	
}
