package com.tests;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.configurations.Base;
import com.pages.HomePage;
import com.pages.LoginPage;

public class BaseTest extends Base {
	
//	WebDriver driver;
	LoginPage login;
	HomePage home;
	//----------------------
	
	@BeforeMethod
	public void setUp() throws IOException
	{
//		driver=new ChromeDriver();
//		driver.get("https://www.saucedemo.com/v1/");
//		driver.manage().window().maximize();
		
		initialisation();// mukalil kaanunnathellam initialisation enna Method Base clasil koduthu.
		 login= new LoginPage(driver);
		 home= new HomePage(driver);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}
	

}
