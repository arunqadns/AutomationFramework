package com.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomeTest extends BaseTest {

//	WebDriver driver;
	

	@Test(priority = 0)

	public void Verify_Applogo() throws InterruptedException, FileNotFoundException, IOException, ParseException

	{
		
//		driver=new ChromeDriver();
//		driver.get("https://www.saucedemo.com/v1/");
//		driver.manage().window().maximize();
//		LoginPage login= new LoginPage(driver);
//		HomePage Home= new HomePage(driver);

		login.Enter_valid_username();
		login.Enter_valid_password();
		login.loginButtonClick();
		Assert.assertEquals(Home.ApplogoDisplaying(), true);
		
	

//		driver.close();
	}

	@Test(priority = 1)
	public void Veryfy_Menu_icon() throws InterruptedException, FileNotFoundException, IOException, ParseException {


//	driver=new ChromeDriver();
//	driver.get("https://www.saucedemo.com/v1/");
//	driver.manage().window().maximize();
//	LoginPage login= new LoginPage(driver);
//	HomePage Home= new HomePage(driver);

		login.Enter_valid_username();
		login.Enter_valid_password();
		login.loginButtonClick();
		Home.ApplogoDisplaying();

		
//	driver.close();
	}

	@Test(priority = 2)
	public void Veryfy_SideMenu_open() throws InterruptedException, FileNotFoundException, IOException, ParseException {

// driver=new ChromeDriver();
// driver.get("https://www.saucedemo.com/v1/");
// driver.manage().window().maximize();
// LoginPage login= new LoginPage(driver);
// HomePage Home= new HomePage(driver);

		login.Enter_valid_username();
		login.Enter_valid_password();
		login.loginButtonClick();

		boolean ww = Home.SideNavBarOpen();

		System.out.println("bool=" + ww);
		Assert.assertEquals(ww, true);
		

//driver.close();

	}

	@Test(priority = 3)
	public void Veryfy_SideMenu_close() throws InterruptedException, FileNotFoundException, IOException, ParseException {

//driver=new ChromeDriver();
//driver.get("https://www.saucedemo.com/v1/");
//driver.manage().window().maximize();
//LoginPage login= new LoginPage(driver);
//HomePage Home= new HomePage(driver);

		login.Enter_valid_username();
		login.Enter_valid_password();
		login.loginButtonClick();
		boolean ww = Home.SideNavBarclose();

		System.out.println(ww);
		Assert.assertEquals(ww, false);

	
//driver.close();
	}

}
