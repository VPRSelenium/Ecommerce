package org.ecommerce.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners implements ITestListener {

	
	public ExtentSparkReporter sparkreport;
	public ExtentReports extentreports;
	public ExtentTest extenttest;

	public String timeStamp;
	public String  filename;

	public void onStart(ITestContext context)

	{
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		filename="report"+timeStamp+".html";
		
		
		sparkreport = new ExtentSparkReporter(System.getProperty("user-dir")+"/extentreports/"+filename);

		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setDocumentTitle("Regression Test case");
		sparkreport.config().setReportName("Ecommerce Report");
		sparkreport.config().setTimeStampFormat(timeStamp);
	
		
		
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreport);
		extentreports.setSystemInfo(timeStamp, filename)
       
		
		extentreports.a
		// started msg and start time
	}

	public void onTestStart(ITestResult result) {
		// test case name and time
	
		
		extenttest=extentreports.createTest(result.getClass().getName());
		extenttest.

		
	}

	public void onTestSuccess(ITestResult result) {
		// test case pass msg and tst case name
	}

	public void onTestFailure(ITestResult result)

	{
		// test case fail msg and screenshot
	}

	public void onTestSkipped(ITestResult result) {
		// test case skipped msg and test case details

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)

	{
	}

	public void onFinish(ITestContext context) {
		// completed msg and time

	}

}
