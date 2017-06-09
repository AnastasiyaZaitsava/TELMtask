package com.epam.tlmd.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.epam.tlmd.util.Init;

public class MainPage extends AbstractPage{
	
	final static public String MENU_LINK_XPATH_TEMPLATE = "//a[@class='nav--menu-link' and contains(@href, '%s')]";

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement menuLink(String sectionLink){
		return driver.findElement(By.xpath(String.format(MENU_LINK_XPATH_TEMPLATE, sectionLink)));
	}

	public void openPage() {
	    driver.navigate().to(Init.getEnviroment());
	    Reporter.log("Test enviroment: " + Init.getEnviroment());
	}
	
}
