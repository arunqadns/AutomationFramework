package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.Utilities;


public class HomePage {
	
	By HOMEPAGE_APPLOGO=By.xpath("//div[@class='app_logo']");
	By MENU_ICON=By.xpath("//button[normalize-space()='Open Menu']");
	By CLOSE_MENU_ICON=By.xpath("//button[normalize-space()='Close Menu']");
	
	By ABOUTSIDEBAR_LINK=By.xpath("//a[@id='about_sidebar_link']");
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)//constructor
	{
		this.driver=driver;	
	}
	
	
	
	
	public boolean ApplogoDisplaying() throws InterruptedException
	
	{
		//return driver.findElement(HOMEPAGE_APPLOGO).isDisplayed();
		return Utilities.isElementDisplayed(driver, HOMEPAGE_APPLOGO);
	}
	
	public boolean MenuiconDisplaying()
	{
		//return driver.findElement(MENU_ICON).isDisplayed();
		return Utilities.isElementDisplayed(driver, MENU_ICON);
	}
	
	public boolean SideNavBarOpen() throws InterruptedException
	{
		//driver.findElement(MENU_ICON).click();
		Utilities.clickElement(driver, MENU_ICON);
		
		Thread.sleep(2000);
		//return driver.findElement(ABOUTSIDEBAR_LINK).isDisplayed();
		return Utilities.isElementDisplayed(driver, ABOUTSIDEBAR_LINK);
		
	}
	
	public boolean SideNavBarclose() throws InterruptedException
	{
		//driver.findElement(By.xpath("//button[normalize-space()='Open Menu']")).click();
		Utilities.clickElement(driver, MENU_ICON);
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[normalize-space()='Close Menu']")).click();
		Utilities.clickElement(driver, CLOSE_MENU_ICON);
		
		Thread.sleep(2000);
		//return driver.findElement(By.xpath("//button[normalize-space()='Open Menu']")).isDisplayed();
		
		return Utilities.isElementDisplayed(driver, ABOUTSIDEBAR_LINK);
	}
	
	
	

}
