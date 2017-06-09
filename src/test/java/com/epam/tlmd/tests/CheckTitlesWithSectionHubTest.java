package com.epam.tlmd.tests;

import org.testng.annotations.*;

import com.epam.tlmd.steps.Steps;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.Init;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	public Iterator<Object[]> sectionsData() {
		steps.setSections("Sections.json");
		ArrayList<JSONObject> sections = steps.getSections();
		List<Object[]> list = new ArrayList<Object[]>();
		int sectionNumber = 1;
		for (JSONObject section : sections) {
			list.add(new Object[]{sectionNumber, section.get("title")});
			sectionNumber++;
		}
		return list.iterator();
	}

	@Test (dataProvider = "sectionsData", groups = "withHub")
	public void checkTitle(int sectionNumber, String expTitle){
		steps.openPageFromHub(sectionNumber);
		steps.switchToWindow();
		Assert.assertTrue(steps.checkPageTitle(expTitle));
	}

    @AfterSuite(description = "Stop Browser", groups = "withHub")
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }
  
 

}
