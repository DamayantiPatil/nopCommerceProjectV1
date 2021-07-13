package com.nopCommerceProjectV1.testCases;

import org.junit.Assert;


//import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopCommerceProjectV1.pageObjects.LoginPage;
import com.nopCommerceProjectV1.utilities.ExcelUtils;

public class TC_LoginDataDrivenTest_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String password) throws Exception
	{
		driver.get(baseurl);
		
		test.log(Status.PASS, "URL is opened"); // logger message
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(user);
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
			//captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			test.log(Status.FAIL, "Login failed"); // logger message
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception
	{
		String path= System.getProperty("user.dir") +"/src/test/java/com/nopCommerceProjectV1/testData/LoginData.xlsx";
		
		int rowNum = ExcelUtils.getRowCount(path, "Sheet1");
		int colNum= ExcelUtils.getCellCount(path, "Sheet1",1);
		
		String loginData[][] = new String[rowNum][colNum];
		
		for(int i=1;i<rowNum;i++)
		{
			for(int j=0;j<colNum;j++)
			{
				loginData[i-1][j]= ExcelUtils.getCellData(path, "Sheet1",i, j);
			}
		}
		return loginData;
	}
}
