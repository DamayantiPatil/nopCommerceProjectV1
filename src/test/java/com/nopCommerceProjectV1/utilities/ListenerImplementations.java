package com.nopCommerceProjectV1.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerImplementations extends ExtentSetup implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		//Before each Test case
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onStart(ITestContext context) {
		//Setup method call
		extent = ExtentSetup.setupExtentReport();
	}

	public void onFinish(ITestContext context) {
		//Close extent
		extent.flush();
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case: " +result.getMethod().getMethodName() + " is Passed.");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case: " +result.getMethod().getMethodName() + " is Failed.");
		test.log(Status.FAIL, result.getThrowable());
		
		// Add screenshot for failed testcase
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		//Get current Date
		Date date = new Date();
		String actualDate = format.format(date);
		
		String screenshotPath = System.getProperty("user.dir") 
				+"/Reports/Screenshots/"+actualDate+".jpeg";
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onTestStart()
	{
		
	}
	
}
