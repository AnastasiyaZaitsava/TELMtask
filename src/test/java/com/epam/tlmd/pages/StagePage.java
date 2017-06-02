package com.epam.tlmd.pages;

import org.openqa.selenium.WebDriver;

public class StagePage extends AbstractPage{
	private final String BASE_URL = "http://stage.telemundo.com/";

	public StagePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openPage() {
		// TODO Auto-generated method stub
	    driver.navigate().to(BASE_URL);
	}

}
