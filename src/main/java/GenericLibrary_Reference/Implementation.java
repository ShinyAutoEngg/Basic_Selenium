package GenericLibrary_Reference;

import java.io.File;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Implementation implements ITestListener{

	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	
	public void onTestFailure(ITestResult result)
	{
		String testData = result.getMethod().getMethodName();

		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.Sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(src, new File("./ScreenShot/"+testData+".png"));
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
	}

	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		Random random = new Random();
		int randNum = random.nextInt(1000);
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+randNum);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Testing");
		spark.config().setReportName("shobha");
		
	    report=new ExtentReports();
	    report.attachReporter(spark);
	    report.setSystemInfo("platform", "windows10");
	    report.setSystemInfo("Execuited by", "shobha");
	    report.setSystemInfo("reviewed By", "Ram");
	}

	
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
