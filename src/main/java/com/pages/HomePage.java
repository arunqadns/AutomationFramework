package com.pages;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.Utilities;


public class HomePage {
	
	//changes i made 
	
	By HOMEPAGE_APPLOGO=By.xpath("//div[@class='app_logo']");
	By SORT_OPTION=By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/select[1]");
	By PRODUCT_TITLE=By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]");
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
	
	
	
	public boolean IsProductTitleDisplaying() throws InterruptedException
	{
		//return driver.findElement(HOMEPAGE_APPLOGO).isDisplayed();
		return Utilities.isElementDisplayed(driver, PRODUCT_TITLE);
	}
	
	public boolean IsMenuiconDisplaying()
	{
		//return driver.findElement(MENU_ICON).isDisplayed();
		return Utilities.isElementDisplayed(driver, MENU_ICON);
	}
	
	public boolean IsSortOptionDisplaying()
	{
		//return driver.findElement(MENU_ICON).isDisplayed();
		return Utilities.isElementDisplayed(driver,SORT_OPTION);
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
		Thread.sleep(1000);
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
