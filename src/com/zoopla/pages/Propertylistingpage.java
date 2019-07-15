package com.zoopla.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Propertylistingpage{
	
	public WebDriver driver;
	public WebDriverWait wait ;
	public String agentName ;
	public String verifyagentName ;
	public Propertylistingpage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	// Elements on Propertylisting page
	
	@FindBy(how = How.XPATH, using = "//ul[@class='listing-results clearfix js-gtm-list']/li[@class!='dfp-srp-item clearfix'][4]//a[@class='listing-results-price text-price']")
	private WebElement fourthproperty;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='listing-results clearfix js-gtm-list']/li[@class!='dfp-srp-item clearfix'][5]//a[@class='listing-results-price text-price']")
	private WebElement fithproperty;

	@FindBy(how = How.XPATH, using = "//div[@class='dp-sidebar-wrapper']//h4")
	private WebElement agentlink;
	
	@FindBy(how = How.XPATH, using = "//div[@id='content']//b[1]")
	private WebElement verifyagentname;
	
	
	
	
	// Methods on Propertylisting page
	
	public void sortpropertiesbyfilterbutton() throws InterruptedException {
		System.out.println(driver.getTitle());
		Select sortfilter = new Select(driver.findElement(By.xpath("//select[@name='results_sort']")));
		sortfilter.selectByValue("highest_price");
		Thread.sleep(2000);
		List<WebElement> elementName = driver.findElements(By.xpath(
				"//ul[@class='listing-results clearfix js-gtm-list']/li[@class!='dfp-srp-item clearfix']//a[@class='listing-results-price text-price']"));

		for (int i = 0; i < elementName.size(); i++) {
			System.out.println(elementName.get(i).getText());
		}
	}
	
	public void sortpropertiesbySortfunction() {
		System.out.println(driver.getTitle());
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementName = driver.findElements(By.xpath(
				"//ul[@class='listing-results clearfix js-gtm-list']/li[@class!='dfp-srp-item clearfix']//a[@class='listing-results-price text-price']"));

		for (int i = 0; i < elementName.size(); i++) {
			obtainedList.add(elementName.get(i).getText());
		}
		Collections.sort(obtainedList);
		Collections.reverse(obtainedList);
		for (int i = 0; i < obtainedList.size(); i++) {
			System.out.println(obtainedList.get(i));
		}
	}
	
	public void sortpropertiesbyusingRegex() {
		System.out.println(driver.getTitle());
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementName = driver.findElements(By.xpath(
				"//ul[@class='listing-results clearfix js-gtm-list']/li[@class!='dfp-srp-item clearfix']//a[@class='listing-results-price text-price']"));

		for (int i = 0; i < elementName.size(); i++) {
			String s = elementName.get(i).getText();
			s=s.replaceAll("[^a-zA-Z0-9]", "");			
			obtainedList.add(s);
		}

		for (int i = 0; i < obtainedList.size(); i++) {		
			System.out.println(obtainedList.get(i));
			
		}	

	}
	public void getagent() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", fourthproperty);
		fithproperty.click();
		wait = new WebDriverWait(driver,20); 
		wait.until(ExpectedConditions.visibilityOf(agentlink));
		agentName = agentlink.getText();
		agentlink.click();
		wait.until(ExpectedConditions.visibilityOf(verifyagentname));
		verifyagentName = verifyagentname.getText();
	}
	public String getagentname()   {
		return agentName;
	}
	public String getagentNametoverify()   {
		return verifyagentName;
	}
}
