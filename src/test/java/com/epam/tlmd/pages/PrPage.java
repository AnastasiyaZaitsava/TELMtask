package com.epam.tlmd.pages;

import org.openqa.selenium.WebDriver;

public class PrPage extends AbstractPage{
	private final String BASE_URL = "http://tlmd-XXXX.pr.telemundo.com/";


	public PrPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
	    driver.navigate().to(BASE_URL);
	}
	
	public boolean checkTitle(){
		String title = driver.getTitle();
		if (title.contains("Telemundo")){
			return true;
		}
		else{
			return false;
		}
	}

}
