package com.epam.tlmd.tests;

import com.epam.tlmd.steps.Steps;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.Init;
import com.epam.tlmd.util.SectionsJSON;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckTitlesWithLinksTest {

	private Steps steps = new Steps();
	private String enviroment;
	
	@BeforeSuite(description = "Init", alwaysRun = true)
     public void setUp()  {
		steps.initDriver();
		enviroment = Init.getEnviroment();
     }
	@DataProvider ()
	public Object[][] sectionsData() {
		steps.setSections("Sections.json");
		ArrayList<String> sectionsNames = steps.getSectionNames();
	    return new Object[][]{
	      {sectionsNames.get(0), steps.getSectionLink(sectionsNames.get(0)), steps.getExpectedTitle(sectionsNames.get(0))},
	      {sectionsNames.get(1), steps.getSectionLink(sectionsNames.get(1)), steps.getExpectedTitle(sectionsNames.get(1))},
	      {sectionsNames.get(2), steps.getSectionLink(sectionsNames.get(2)), steps.getExpectedTitle(sectionsNames.get(2))},
	      {sectionsNames.get(3), steps.getSectionLink(sectionsNames.get(3)), steps.getExpectedTitle(sectionsNames.get(3))},
	      {sectionsNames.get(4), steps.getSectionLink(sectionsNames.get(4)), steps.getExpectedTitle(sectionsNames.get(4))},
	      {sectionsNames.get(5), steps.getSectionLink(sectionsNames.get(5)), steps.getExpectedTitle(sectionsNames.get(5))},
	      {sectionsNames.get(6), steps.getSectionLink(sectionsNames.get(6)), steps.getExpectedTitle(sectionsNames.get(6))},
	      {sectionsNames.get(7), steps.getSectionLink(sectionsNames.get(7)), steps.getExpectedTitle(sectionsNames.get(7))},
	      {sectionsNames.get(8), steps.getSectionLink(sectionsNames.get(8)), steps.getExpectedTitle(sectionsNames.get(8))},
	    };
	  }
	
	@Test (dataProvider = "sectionsData", groups = "withLinks")
	public void checkTitle(String sectionName, String sectionLink, String expTitle){
		if(sectionName.equals("Deportes")){
			steps.openLink(sectionLink);
		}
		else{
			steps.openLink(enviroment + sectionLink);
		}
		Assert.assertTrue(steps.checkPageTitle(expTitle));
	}

    @AfterSuite(description = "Stop Browser", groups = "withLinks")
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }

   
 
}
