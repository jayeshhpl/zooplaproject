package com.zoopla.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class datepicker {
	public void selectdatefromcalendar(WebDriver driver, WebElement calendar, String tablexpath, int changedatebydays) {
		// to get date
		java.util.Date d = new Date();
		// date format
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String dat = sd.format(d);
		int date = 0;
		// Split the date to get only day
		String Split[] = dat.split("-");
		// System.out.println(Split[2]);
		int a = Integer.parseInt(Split[2]);
		date = a + changedatebydays;
		// to get date either before or after the current system date , datefromcurrent
		// will decide the +- no of days from current date
		String fromdate = Integer.toString(date);
		// String fromdate = Split[2];
		//System.out.println(date);

		// from date
		(calendar).click();
		// list out all dates available for from date field in calendar
		List<WebElement> numbers = driver.findElements(By.xpath(tablexpath));

		for (WebElement e : numbers) { 
										/* check with date which u want to get compare
										 elements from list are converrted to int beacuse when desired is converted to
										 int it gives "9" instead of "09" for which it fails
										 because of which now desired date can be choosen with alteration which will
										 be in integer and not in string so we have to convert calendar elemnets to
										 integer to*/
			int converted = Integer.parseInt(e.getText());
			if (converted == (date)) {
				e.click();
				break;
			}

		}
	}
}
