package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Homepage {

	public WebDriver driver;

	public Homepage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	// Elements on Home page
	@FindBy(how = How.XPATH, using = "//form[@name='search-form']//input[@id='search-input-location']")
	private WebElement searchpropertyname;

	@FindBy(how = How.ID, using = "search-submit")
	private WebElement searchpropertyBtn;

	// Methods on Home page

	public void navigatetopropertiesbycity(String city) {
		searchpropertyname.sendKeys(city);
		searchpropertyBtn.click();
		

	}

}
