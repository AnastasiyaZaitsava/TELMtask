package com.epam.tlmd.pages;

import org.openqa.selenium.WebDriver;

public class AccPage extends AbstractPage{
	private final String BASE_URL = "http://acc.telemundo.com/";

	public AccPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
	    driver.navigate().to(BASE_URL);
	}
}
