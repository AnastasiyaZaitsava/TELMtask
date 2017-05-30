package com.epam.tlmd.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.tlmd.pages.MainPage;
import com.epam.tlmd.util.DriverSingleton;

public class Test {
	
	private static WebDriver driver;
	
	public static boolean checkTitle(){
		driver = DriverSingleton.getDriver();
	//	driver = new FirefoxDriver();
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		boolean rightTitle = mainPage.checkTitle();
		DriverSingleton.closeDriver();
		return rightTitle;
	}

}
