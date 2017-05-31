package com.epam.tlmd.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.epam.tlmd.pages.MainPage;
import com.epam.tlmd.util.DriverSingleton;

public class TestTitle {
	
	private static WebDriver driver;
	
	@BeforeTest(description = "Init browser")
     public void setUp()  {
		driver = DriverSingleton.getDriver();
     }
  
	@Test
	public void checkTitle() {
			MainPage mainPage = new MainPage(driver);
			mainPage.openPage();
			Assert.assertTrue(mainPage.checkTitle());
			
  }

    @AfterTest(description = "Stop Browser")
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }
}
