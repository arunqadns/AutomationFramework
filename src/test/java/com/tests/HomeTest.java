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
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Assert.assertEquals(true,home.IsApplogoDisplaying());

	}



	@Test(priority = 2)
	public void Veryfy_SideMenu_open() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{

		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		home.MenuButtonClick();
		Assert.assertEquals(true,home.IsSideNavBarOpen());


	}

	@Test(priority = 3)
	public void Veryfy_SideMenu_close() throws InterruptedException, FileNotFoundException, IOException, ParseException 
	{

		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		home.MenuButtonClick();
		Thread.sleep(1000);
		if(true==home.IsSideNavBarOpen())
		{
		home.CloseMenuButtonClick();
		}
		Thread.sleep(1000);
		Assert.assertEquals(false, home.IsSideNavBarclose());

	
//driver.close();
	}
	@Test(priority = 4)
	public void Verify_Inventory_Items_Container() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		boolean ww =home.InventoryContainer();
		Assert.assertEquals(ww, true);
		
	}

}
