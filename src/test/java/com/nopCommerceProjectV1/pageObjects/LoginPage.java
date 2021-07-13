package com.nopCommerceProjectV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	@CacheLookup
	WebElement btnLogin;
	
	//@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;

	public void setUsername(String uname) throws Exception
	{
		txtEmail.clear();
		Thread.sleep(3000);
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) throws Exception
	{
		txtPassword.clear();
		Thread.sleep(3000);
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
