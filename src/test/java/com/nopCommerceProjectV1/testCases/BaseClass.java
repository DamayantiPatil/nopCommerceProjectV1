package com.nopCommerceProjectV1.testCases;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.nopCommerceProjectV1.utilities.ReadConfig;

public class BaseClass {

	public static ExtentReports extent;
	public static ExtentTest test;
	
	ReadConfig readconfig = new ReadConfig(); 

	public String baseurl= readconfig.getApplicationURL();
	public String username= readconfig.getUserEmail() ;
	public String password= readconfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String br)
	{
		logger = Logger.getLogger("nopCommerceProject");
		PropertyConfigurator.configure("log4j.properties");

		if(br.equals("chrome"))
		{
			//Chrome Browser
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath() );
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		else if(br.equals("firefox"))
		{
			//Firefox Browser
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath() );
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

	}

	@AfterClass
	public void tearDown() throws Exception
	{
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Test executed successfully");
	}

	public void captureScreenshot(WebDriver driver, String tname) throws Exception
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots" +tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
