package com.zoopla.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class capturescreenshot2 {
	public static String dest;
	public static String screenshot(WebDriver driver, String Screenshot)
	{
		try {
				Thread.sleep(2000);
				TakesScreenshot ts = (TakesScreenshot)driver;
				File source1 =ts.getScreenshotAs(OutputType.FILE);
				Thread.sleep(2000);
				dest = System.getProperty("//home//jayesh//d_drive//workspace_eclipse//Caretime//screen"+Screenshot+".png");
				File Destination = new File(dest);
				FileUtils.copyFile(source1, Destination );
			}	
				catch (Exception e)
			{
					System.out.println("exeception"+ e.getMessage());
			}
		
		return dest;
	}	
}
