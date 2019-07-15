package com.zoopla.testcases;

import java.awt.AWTException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zoopla.pages.Homepage;
import com.zoopla.pages.Propertylistingpage;
import com.zoopla.utilities.BaseClass;


public class zooplatestcase {

public WebDriver driver;
public String agentName ;
public String verifyagentName ;	

		@BeforeMethod
		public void initiatetestcases()  {
		BaseClass base = new BaseClass();
		driver = base.startbrowser();
		driver.navigate().to(base.prop.getProperty("url"));
	}
		@Test
		public void AddFacility() throws AWTException, InterruptedException  {
			
			String actualTitle = "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents";
			Assert.assertEquals(driver.getTitle(), actualTitle);
			Homepage home = PageFactory.initElements(driver, Homepage.class);
			home.navigatetopropertiesbycity("London");
			Propertylistingpage prop = PageFactory.initElements(driver, Propertylistingpage.class);
			prop.sortpropertiesbyfilterbutton();
			prop.getagent();
			agentName = prop.getagentname();
			verifyagentName = prop.getagentNametoverify();
			Assert.assertEquals(agentName, verifyagentName);
			System.out.println("test case passed");
		}
		
		@Test
		public void Addsecondtest() {
			String actualtitle = "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents";
			String gettitle = driver.getTitle();
			Assert.assertEquals(actualtitle, gettitle);
		}
		@AfterMethod(enabled=true)
		public void teardown() {
			driver.quit();
		}

}