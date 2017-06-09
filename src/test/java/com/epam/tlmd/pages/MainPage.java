package com.epam.tlmd.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.tlmd.util.Init;

public class MainPage extends AbstractPage{
	
	//final static public String MENU_LINK_XPATH_TEMPLATE = "//a[@class='nav--menu-link' and contains(text(), '%s')]";

	final static public String MENU_LINK_XPATH_TEMPLATE = "(//a[@class='nav--menu-link'])[%s]";

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement menuLink(int sectionNumber){
		return driver.findElement(By.xpath(String.format(MENU_LINK_XPATH_TEMPLATE, sectionNumber)));
	}

	

	public void openPage() {
	    driver.navigate().to(Init.getEnviroment());
	}
	
}
