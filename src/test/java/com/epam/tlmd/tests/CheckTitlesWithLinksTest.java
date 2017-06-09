package com.epam.tlmd.tests;

import com.epam.tlmd.steps.Steps;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.Init;


import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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
	public Iterator<Object[]> sectionsData() {
		steps.setSections("Sections.json");
		ArrayList<JSONObject> sections = steps.getSections();
		List<Object[]> list = new ArrayList<Object[]>();
		for (JSONObject section : sections) {
			list.add(new Object[]{section.get("name"), section.get("link"), section.get("title")});
		}
	    return list.iterator();
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
