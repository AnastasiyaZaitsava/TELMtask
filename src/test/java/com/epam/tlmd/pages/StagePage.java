package com.epam.tlmd.pages;

import org.openqa.selenium.WebDriver;

public class StagePage extends AbstractPage{
	private final String BASE_URL = "http://stage.telemundo.com/";

	public StagePage(WebDriver driver) {
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
