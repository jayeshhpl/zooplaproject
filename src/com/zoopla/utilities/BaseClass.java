package com.zoopla.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	public WebDriver startbrowser() {
		

	try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./Resources//Config.properties"); 
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		
			if(browserName.equalsIgnoreCase("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver","//home//jayesh//d_drive//driver//chromedriver");
				driver = new ChromeDriver(); 
			}
			
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.chrome.driver","//home//jayesh//d_drive//driver//geckodriver");
				driver = new FirefoxDriver(); 
			}
			
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	return driver;
}
	
}
	
