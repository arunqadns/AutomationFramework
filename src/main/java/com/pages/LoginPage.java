package com.pages;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.Utilities;



public class LoginPage {
//  STATIC VARIABLES   Send keys vechu username,password nalkiyirunnathu ozhivakki ingane variable aayi nalki.benefit enthengilum changes undengil ivde change aaaakiyal mathi.
//	String validUserName="standard_user";
//	String validPassword="secret_sauce";	
	//lOGIN PAGE WEBELEMENTS
	By LOGINBUTTON=By.id("login-button");
	By ERROR_TOAST=By.xpath("//h3[@data-test='error']");
	By MENU_BUTTON=By.xpath("//button[normalize-space()='Open Menu']");
	By USERNAME_FEILD=By.name("user-name");
	By PASSWORD_FEILD=By.name("password");
	
		
	WebDriver driver; //INITIALISING WEB DRIVER
	
	
	public LoginPage(WebDriver driver1)//CONSTRUCTOR
	{
		this.driver=driver1;
	}
	

	public boolean loginButtonDisplaying() throws InterruptedException
	
	{	
		//return driver.findElement(LOGINBUTTON).isDisplayed();
		return Utilities.isElementDisplayed(driver, LOGINBUTTON);	
	}
	
	public String loginWithEmptyCredentials() throws InterruptedException
	{	
		driver.findElement(LOGINBUTTON).click();	
		//return driver.findElement(ERROR_TOAST).getText();
		return Utilities.getTextValue(driver, ERROR_TOAST);	
	}
	
	public void Enter_valid_username() throws FileNotFoundException, IOException, ParseException
	{
		//driver.findElement(By.name("user-name")).sendKeys(validUserName);  //ivde hard core aayi aanu username koduthath
//		Utilities.enterText(driver, USERNAME_FEILD, validUserName);  hard core matti "validUserNam" enna Static variablil koduthu.
		Utilities.enterText(driver, USERNAME_FEILD, Utilities.readJsonFIle("validusername","./src/main/resources/login.json")); //valid username oru JSON file il ezhuthi vechitund.ippolavide ninnum read cheyyunnu.
		
	}
	public void Enter_valid_password() throws FileNotFoundException, IOException, ParseException
	{
		//driver.findElement(By.name("password")).sendKeys(validPassword);  //ivde hard core aayi aanu password koduthath
		//Utilities.enterText(driver, PASSWORD_FEILD, validPassword); //hard core matti "validPassword" enna Static variablil koduthu.
		Utilities.enterText(driver, PASSWORD_FEILD, Utilities.readJsonFIle("validpassword","./src/main/resources/login.json")); //valid password oru JSON file il ezhuthi vechitund.ippolavide ninnum read cheyyunnu.
	}
	
	public void loginButtonClick()
	{
		//driver.findElement(LOGINBUTTON).click();	
		Utilities.clickElement(driver, LOGINBUTTON);
	}
	

	public boolean loginWithValidCredentials() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
//		Enter_valid_username();
		//Utilities.enterText(driver, USERNAME_FEILD, validUserName);  
        Enter_valid_username();  //pakaram alredy mukalil ullla valid password enter cheyyunnathinulla method call cheyyikunnu.
//		Enter_valid_password();	
//		Utilities.enterText(driver, PASSWORD_FEILD, validPassword);
		Enter_valid_password();	//pakaram alredy mukalil ullla valid password enter cheyyunnathinulla method call cheyyikunnu.
//		driver.findElement(LOGINBUTTON).click();
		Utilities.clickElement(driver, LOGINBUTTON);

	
		Thread.sleep(1000);
		String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
        String actualUrl= driver.getCurrentUrl();
        System.out.println(expectedUrl+"="+actualUrl);
        Boolean flag=true;
        if (actualUrl.equalsIgnoreCase(expectedUrl))
        {
        	flag=true;
        }
        else
        {
        	flag=false;
        }
        	
		return flag;
				
	}
	
		public void loginWithExcelTest() throws IOException, InterruptedException, ParseException
		{
			FileInputStream input = new FileInputStream("./src/main/resources/credentials.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(input);
			XSSFSheet sh=wb.getSheet("Sheet1");

		    for (int i=0; i<=sh.getLastRowNum();i++) 
		    {
	        driver.findElement(USERNAME_FEILD).clear();
	        String Value1=String.valueOf(sh.getRow(i).getCell(0).getStringCellValue());
	        System.out.println((sh.getRow(i).getCell(0).getStringCellValue()).getClass().getName());
	        String Value11=Value1.strip();
	        System.out.println(Value11);
	        driver.findElement(USERNAME_FEILD).sendKeys(Value11);
			        
			        
	        System.out.println(Value1.length());
	        System.out.println(Value11.length());
			       
	        driver.findElement(PASSWORD_FEILD).clear();
        	String Value2=String.valueOf(sh.getRow(i).getCell(1).getStringCellValue());
	        System.out.println((sh.getRow(i).getCell(1).getStringCellValue()).getClass().getName());
	        String Value22=Value2.strip();

	        System.out.println(Value22);
	        System.out.println(Value2.length());
	        System.out.println(Value22.length());
	        driver.findElement(PASSWORD_FEILD).sendKeys(Value22);

	        driver.findElement(LOGINBUTTON).click();

	        Thread.sleep(4000);

	        String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
	        String actualUrl= driver.getCurrentUrl();
	        System.out.println(expectedUrl+"="+actualUrl);
	        if (actualUrl.equalsIgnoreCase(expectedUrl)) 
	        {
            System.out.println("login successful");
            sh.getRow(i).createCell(2).setCellValue("pass");
    		} 
	        else {
        	System.out.println("login failed");
            sh.getRow(i).createCell(2).setCellValue("fail");
		        }

	        FileOutputStream output = new FileOutputStream("./src/main/resources/credentials.xlsx");
	        wb.write(output);
	        output.close(); // close the FileOutputStream
	        driver.get("https://www.saucedemo.com/v1/");
		    input.close(); // close the FileInputStream			
}
	}
}

