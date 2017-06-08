package com.epam.tlmd.tests;

import org.testng.annotations.*;

import com.epam.tlmd.steps.Steps;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.Init;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.Assert;

public class CheckTitlesWithSectionHubTest {
	private Steps steps= new Steps();
	private String enviroment;
	
	@BeforeSuite(description = "Init browser", groups = "withHub")
     public void setUp()  {
		steps.initDriver();
		enviroment = Init.getEnviroment();
     }
  
	@BeforeMethod(groups = "withHub")
	public void beforeMethod() {
		steps.openLink(enviroment);
	}

	@DataProvider ()
	public Object[][] sectionsData() {
		steps.setSections("Sections.json");
		ArrayList<String> sectionsNames = steps.getSectionNames();
	    return new Object[][]{
	      {sectionsNames.get(0), steps.getExpectedTitle(sectionsNames.get(0))},
	      {sectionsNames.get(1), steps.getExpectedTitle(sectionsNames.get(1))},
	      {sectionsNames.get(2), steps.getExpectedTitle(sectionsNames.get(2))},
	      {sectionsNames.get(3), steps.getExpectedTitle(sectionsNames.get(3))},
	      {sectionsNames.get(4), steps.getExpectedTitle(sectionsNames.get(4))},
	      {sectionsNames.get(5), steps.getExpectedTitle(sectionsNames.get(5))},
	      {sectionsNames.get(6), steps.getExpectedTitle(sectionsNames.get(6))},
	      {sectionsNames.get(7), steps.getExpectedTitle(sectionsNames.get(7))},
	      {sectionsNames.get(8), steps.getExpectedTitle(sectionsNames.get(8))},
	    };
	  }

	@Test (dataProvider = "sectionsData", groups = "withHub")
	public void checkTitle(String sectionName, String expTitle){
		steps.openPageFromHub(sectionName);
		steps.switchToWindow();
		Assert.assertTrue(steps.checkPageTitle(expTitle));
	}

    @AfterSuite(description = "Stop Browser", groups = "withHub")
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }
  
 

}
