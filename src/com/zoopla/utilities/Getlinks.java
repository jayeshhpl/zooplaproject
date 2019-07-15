package com.zoopla.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Getlinks 
{
	public void fetchlinks(WebDriver driver,WebElement footerdriver) {
		List<WebElement> link  = footerdriver.findElements(By.tagName("a"));
//		for(int i =0 ;i <link.size();i++)
//		{
//			if (link.get(i).getAttribute("href").startsWith("https") || link.get(i).getAttribute("href").startsWith("http"))
//			{
//				String[] linkarray = new String[1000]; 
//				linkarray[i] = link.get(i).getAttribute("href");
//				//System.out.println(link.get(i).getAttribute("href"));
//			}
//		}
		System.out.println(link.size());
		for(int i =0 ;i <link.size();i++)
		{
			if (link.get(i).getAttribute("href").startsWith("https") || link.get(i).getAttribute("href").startsWith("http") )
			{
				try {
					String handle= driver.getWindowHandle();
					System.out.println(link.get(i).getAttribute("href"));
					String action = Keys.chord(Keys.CONTROL,Keys.RETURN);
					link.get(i).sendKeys(action);	
					//Thread.sleep(3000);
					ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(windowHandles.get(1));
					System.out.println(driver.getTitle());
					Thread.sleep(3000);
					driver.close();
					driver.switchTo().window(windowHandles.get(0));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}
			else
				continue;
		//System.out.println(link.get(i).getAttribute("href"));
		}
		
	}

	
}
