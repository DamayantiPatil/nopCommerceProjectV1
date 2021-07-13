package com.nopCommerceProjectV1.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nopCommerceProjectV1.testCases.BaseClass;

public class ExtentSetup extends BaseClass{

	public static ExtentReports setupExtentReport()
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		
		//Get current Date
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir") 
				+"/Reports/ExecutionReport_"+actualDate+".html";
	
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("nopCommereceProject");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("nopCommereceProject_Reports");
		
		return extent;
		
	}
	
}
