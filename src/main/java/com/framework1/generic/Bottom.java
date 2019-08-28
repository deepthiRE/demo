package com.framework1.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bottom {
	

	Bottom1 v=new Bottom1();
	public void vary() throws FileNotFoundException, IOException
	{

	v.browser = new Properties();
	
	String path=v.UserDir+"src\\main\resources\\browser.properties";
	
	v.browser.load(new FileInputStream(path));
}
	@BeforeTest
	public void invokepropertyfile() throws FileNotFoundException, IOException
	{
		vary();
	
	}
	@BeforeMethod
	public void invokebrowser() {
	
		String b=v.browser.getProperty("browser");
		if(b.equalsIgnoreCase("chrome "))
		{
			
		
			WebDriverManager.chromedriver().setup();
			v.driver=new ChromeDriver();
		}
		else if(b.equalsIgnoreCase("Firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		v.driver=new FirefoxDriver();
		}
		v.driver.manage().window().maximize();
		v.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		lanchurl();
	}
public void lanchurl()
{
	String url=v.browser.getProperty("URL");
	v.driver.get(url);
}
@AfterMethod
public void closeapp() {
}
{
	v.driver.close();
}
}
 
