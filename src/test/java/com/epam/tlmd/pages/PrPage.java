package com.epam.tlmd.pages;

import org.openqa.selenium.WebDriver;

public class PrPage extends AbstractPage{
	private final String BASE_URL = "http://tlmd-XXXX.pr.telemundo.com/";


	public PrPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		// TODO Auto-generated method stub
	    driver.navigate().to(BASE_URL);
	}

}
