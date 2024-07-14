package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.Utilities;


public class HomePage {
	
	//changes i made 
	
	By HOMEPAGE_APPLOGO=By.xpath("//div[@class='app_logo']");
	By CLOSE_MENU_ICON=By.xpath("//button[normalize-space()='Close Menu']");
	By ABOUTSIDEBAR_LINK=By.xpath("//a[@id='about_sidebar_link']");
	By INVENTORY_CONTAINER=By.id("inventory_container");
	By MENU_ICON=By.cssSelector("div[class='bm-burger-button'] button");
	By LOGOUTBUTTON=By.id("logout_sidebar_link");
	WebDriver driver;
	String HOMEPAGEURL="https://www.saucedemo.com/v1/inventory.html";
	
	
	public HomePage(WebDriver driver)//constructor
	{
		this.driver=driver;	
	}
	
	
	
	public boolean IsApplogoDisplaying() throws InterruptedException
	{
		//return driver.findElement(HOMEPAGE_APPLOGO).isDisplayed();
		return Utilities.isElementDisplayed(driver, HOMEPAGE_APPLOGO);
	}
	
	public boolean IsMenuiconDisplaying()
	{
		//return driver.findElement(MENU_ICON).isDisplayed();
		return Utilities.isElementDisplayed(driver, MENU_ICON);
	}
	
	public void MenuButtonClick()
	{	
		Utilities.clickElement(driver, MENU_ICON);
	}
	
	public void CloseMenuButtonClick()
	{	
		Utilities.clickElement(driver, CLOSE_MENU_ICON);
	}
	
	
	public boolean IsThisHomePage()
	{
		boolean result=false;
		if(driver.getCurrentUrl().equalsIgnoreCase(HOMEPAGEURL))
		{
			result=true;
		}
		return result;
	}
	

	
	public boolean IsSideNavBarOpen() throws InterruptedException
	{
		return Utilities.isElementDisplayed(driver, ABOUTSIDEBAR_LINK);
		
	}
	
	public boolean IsSideNavBarclose() throws InterruptedException
	{
		
		return Utilities.isElementDisplayed(driver, ABOUTSIDEBAR_LINK);
	}
	
	public boolean InventoryContainer() throws InterruptedException
	{

		Thread.sleep(2000);
		//return driver.findElement(ABOUTSIDEBAR_LINK).isDisplayed();
		return Utilities.isElementDisplayed(driver, INVENTORY_CONTAINER);
		
	}
	
	
	

}
