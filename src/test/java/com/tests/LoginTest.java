package com.tests;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.utilities.Utilities;


public class LoginTest extends BaseTest{	

	
	//Check the Login Functionality
	
		
	

	
	@Test(priority=0,enabled=true)
	public void VerifyloginButtonDisplaying() throws InterruptedException {
//ivde login page ile Method vilikunnu athinu munp login paginte 
//object creat cheyyunnund athu BaseTest classil Befor methodil koduthitund.
		Assert.assertEquals(true,login.IsLoginButtonDisplayed());
		}
	@Test(priority=1)
	public void UsernameFieldsDisplaying() throws InterruptedException {
		Assert.assertEquals(true,login.IsUsernameFieldsDisplayed());
		}
	
	@Test(priority=2)
	public void PasswordFieldsDisplaying() throws InterruptedException {
		Assert.assertEquals(true,login.IsPasswordFieldsDisplayed());
		}
	
	
	@Test(priority=3)
	public void loginWithValidCredentials() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		Assert.assertEquals(true,home.IsThisHomePage());	
	}
	
	@Test(priority=4)
	public void loginWithInvalidCredentials() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.Enter_invalid_username();
		login.Enter_invalid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		Assert.assertEquals(true,login.IsThisLoginPage());	
	}

	
	@Test(priority=5)
	public void LoginWithInvalidUserNameAndValidPassword() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.Enter_invalid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		Assert.assertEquals(true,login.IsThisLoginPage());	
	}	
	
	@Test(priority=6)
	public void LoginWithValidUserNameAndInvalidPassword() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.Enter_invalid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		Assert.assertEquals(true,login.IsThisLoginPage());	
	}
	
	

	
//	Display login error messages	
//	
	@Test(priority=7)
	public void PressloginButtonWithoutEnterCredentialsAlert() throws InterruptedException
	{
		login.LoginButtonClick();
		String alertMessage=login.GetErrorToastMessage();
		Assert.assertEquals(alertMessage, "Epic sadface: Username is required");
	}
	
	
	@Test(priority=8)
	public void PressloginButtonWithoutUserNameWithPasswordAlert() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
	
		login.Enter_invalid_password();
		login.LoginButtonClick();
		String alertMessage=login.GetErrorToastMessage();
		Assert.assertEquals(alertMessage, "Epic sadface: Username is required");
	}

	@Test(priority=9)
	public void PressloginButtonWithUserNameWithoutPasswordAlert() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.Enter_invalid_username();
		login.LoginButtonClick();
		String alertMessage=login.GetErrorToastMessage();
		Assert.assertEquals(alertMessage, "Epic sadface: Password is required");
	}
	
	@Test(priority=10)
	public void PressloginButtonWithInvalidUserNameInvalidPasswordAlert() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.Enter_valid_username();
		login.Enter_invalid_password();
		login.LoginButtonClick();
		String alertMessage=login.GetErrorToastMessage();
		Assert.assertEquals(alertMessage, "Epic sadface: Username and password do not match any user in this service");
	}	
	
	
	
	
	
	
	

	
	@Test(priority=11)
	public void LogOutCheck() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(2000);
		login.MenuButtonClick();
		Thread.sleep(2000);
		login.LogOutButtonClick();
		Thread.sleep(2000);
		Assert.assertEquals(true,login.IsLoginButtonDisplayed());	
	}	
	
	
	
	
		
	
	@Test(priority=12)
	public void loginExcel() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.loginWithExcelTest();
		Assert.assertEquals(true,true);	
	}
	

	
	
	}


