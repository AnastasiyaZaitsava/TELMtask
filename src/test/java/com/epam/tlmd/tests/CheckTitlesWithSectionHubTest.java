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
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckTitlesWithSectionHubTest {
	private Steps steps = new Steps();
	private String enviroment;
	
/*	@BeforeMethod(description = "Init browser", groups = "withHub")
     public void setUp()  {
	//	Steps steps;
		steps.initDriver();
		enviroment = Init.getEnviroment();
		steps.openLink(enviroment);
     }
  
/*	@BeforeMethod(groups = "withHub")
	public void beforeMethod() {
		steps.openLink(enviroment);
	}*/

	@DataProvider ()
	public Iterator<Object[]> sectionsData() {
		Steps steps = new Steps();
		steps.setSections("Sections.json");
		ArrayList<JSONObject> sections = steps.getSections();
		List<Object[]> list = new ArrayList<Object[]>();
		for (JSONObject section : sections) {
			list.add(new Object[]{section.get("name"), section.get("link"), section.get("title")});
		}
		return list.iterator();
	}

	@Test (threadPoolSize = 3, dataProvider = "sectionsData", groups = "withHub")
	public void checkTitle(String sectionName, String sectionLink, String expTitle){
		Steps steps = new Steps();
		steps.initDriver();
		enviroment = Init.getEnviroment();
		steps.openLink(enviroment);
		Long id = Thread.currentThread().getId();
		System.out.println("Test method check titles executing on thread with id: " + id);
		steps.openLink(enviroment);
		steps.openPageFromHub(sectionLink);
		if(sectionName.equals("Deportes")){
			steps.switchToWindow();
		}
		Assert.assertTrue(steps.checkPageTitle(expTitle));
		steps.closeDriver();
	}

	@Test (threadPoolSize = 3, dataProvider = "sectionsData", groups = "withHub")
	public void checkSectionsNames(String sectionName, String sectionLink, String expTitle){
		Steps steps = new Steps();
		steps.initDriver();
		enviroment = Init.getEnviroment();
		steps.openLink(enviroment);
		Long id = Thread.currentThread().getId();
		System.out.println("Test method executing on thread with id: " + id);
		WebElement button = steps.getSectionButton(sectionLink);
		if (sectionName.contains("per Series")){
			sectionName = "per Series";
		}
		Assert.assertTrue(button.getText().contains(sectionName));
		steps.closeDriver();
	}

 /*  @AfterMethod(description = "Stop Browser", groups = "withHub")
     public void stopBrowser()  {
    	steps.closeDriver();
     }*/
  
 

}
