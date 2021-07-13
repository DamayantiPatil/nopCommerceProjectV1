package com.nopCommerceProjectV1.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopCommerceProjectV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws Exception
	{
		driver.get(baseurl);
		
		test.log(Status.PASS, "URL is opened"); // logger message
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		test.log(Status.PASS, "User provided"); // logger message
		
		lp.setPassword(password);
		test.log(Status.PASS, "Password provided"); // logger message
		
		lp.clickLogin();
		test.log(Status.PASS, "Login button clicked"); // logger message
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			test.log(Status.PASS, "Login passed");
		}
		else
		{
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			test.log(Status.FAIL, "Login failed"); // logger message
		}
	}
	
	//Following test method is created to check the failure one and to take screenshot of it. 
//	@Test
//	public void loginTestFail() throws Exception
//	{
//		driver.get(baseurl);
//		
//		test.log(Status.PASS, "URL is opened"); // logger message
//		
//		LoginPage lp = new LoginPage(driver);
//		lp.setUsername(username);
//		test.log(Status.PASS, "User provided"); // logger message
//		
//		lp.setPassword(password);
//		test.log(Status.PASS, "Password provided"); // logger message
//		
//		lp.clickLogin();
//		test.log(Status.PASS, "LogIn button clicked"); // logger message
//		
//		Thread.sleep(5000);
//		//Here deliberately failing the test case
//		if(driver.getTitle().equals("Dashboard / nopCommerce administrati")) //administration
//		{
//			Assert.assertTrue(true);
//			lp.clickLogout();
//			test.log(Status.PASS, "Login passed");
//		}
//		else
//		{
//			captureScreenshot(driver, "loginTest");
//			Assert.assertTrue(false);
//			test.log(Status.FAIL, "Login failed"); // logger message
//		}
//	}
}
