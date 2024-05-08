package com.tests;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{	
	
	@Test(priority=0)
	public void VerifyloginButtonDisplaying() throws InterruptedException {

//ivde login page ile Method vilikunnu athinu munp login paginte 
//object creat cheyyunnund athu BaseTest classil Befor methodil koduthitund.
		boolean button=login.loginButtonDisplaying();
		Assert.assertEquals(true,button);
		}
//	
	@Test(priority=1)
	public void PressloginButtonWithoutEnterCredentials() throws InterruptedException
	{
	
		String alertMessage=login.loginWithEmptyCredentials();
		Assert.assertEquals(alertMessage, "Epic sadface: Username is required");
	}
	
	@Test(priority=2)
	public void loginWithValidDatas() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
	
		boolean Menuiconpresent=login.loginWithValidCredentials();
		Assert.assertEquals(true,Menuiconpresent);	
	}
	
	@Test(priority=3)
	public void loginExcel() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		login.loginWithExcelTest();
		Assert.assertEquals(true,true);	
	}
	

	
	
	

}
