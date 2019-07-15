package com.zoopla.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class capturescreenshot {
	public static void screenshot(WebDriver driver, String Screenshot)
	{
		try {
			
				TakesScreenshot ts = (TakesScreenshot)driver;
				File source1 =ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source1, new File("./screen/"+Screenshot+".png"));
			}	
				catch (Exception e)
			{
					System.out.println("exeception"+ e.getMessage());
			}
	}	
}
