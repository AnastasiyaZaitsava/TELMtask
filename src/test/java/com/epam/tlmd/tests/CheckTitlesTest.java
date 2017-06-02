package com.epam.tlmd.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.epam.tlmd.pages.*;
import com.epam.tlmd.util.DriverSingleton;

public class CheckTitlesTest {
	
	private static WebDriver driver;
	
	@BeforeTest(description = "Init browser")
     public void setUp()  {
		driver = DriverSingleton.getDriver();
     }
  
	@Test
	public void checkTitleMainPage() {
			MainPage mainPage = new MainPage(driver);
			mainPage.openPage();
			Assert.assertTrue(mainPage.checkTitle());
  }
	@Test
	public void checkTitleDevPage() {
			DevPage devPage = new DevPage(driver);
			devPage.openPage();
			Assert.assertTrue(devPage.checkTitle());	
  }
	@Test
	public void checkTitleStagePage() {
			StagePage stagePage = new StagePage(driver);
			stagePage.openPage();
			Assert.assertTrue(stagePage.checkTitle());	
  }
	@Test
	public void checkTitleAccPage() {
			AccPage accPage = new AccPage(driver);
			accPage.openPage();
			Assert.assertTrue(accPage.checkTitle());	
  }
	@Test
	public void checkTitlePrPage() {
			PrPage prPage = new PrPage(driver);
			prPage.openPage();
			Assert.assertTrue(prPage.checkTitle());	
  }

    @AfterTest(description = "Stop Browser")
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }
}
