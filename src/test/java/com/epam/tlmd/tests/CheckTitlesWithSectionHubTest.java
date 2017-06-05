package com.epam.tlmd.tests;

import org.testng.annotations.Test;

import com.epam.tlmd.steps.Steps;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.SectionsJSON;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckTitlesWithSectionHubTest {
	private static SectionsJSON sections;
	private Steps steps;
	
	@BeforeTest(description = "Init browser")
     public void setUp()  {
		steps = new Steps();
		steps.initDriver();
     }
  
	@BeforeTest(description = "Read json with sections")
    public void getSections()  {
		sections = new SectionsJSON();
		sections.readSections("Sections.json");
    }
	
	@BeforeMethod
	public void beforeMethod() {
		steps.openAccPage();
	}


	
	@Test
	public void checkTitleNovelasPage() {
		JSONObject section = sections.getSection("SeriesYNovelas");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("SeriesYNovelas");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	/*@Test
	public void checkTitleSuperSeriesPage() {
		JSONObject section = sections.getSection("SuperSeries");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("SuperSeries");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test
	public void checkTitleShowsPage() {
		JSONObject section = sections.getSection("Shows");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Shows");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test
	public void checkTitleEntretenimientoPage() {
		JSONObject section = sections.getSection("Entretenimiento");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Entretenimiento");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test 
	public void checkTitleVideosPage() {
		JSONObject section = sections.getSection("Videos");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Videos");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test 
	public void checkTitleNoticiasPage() {
		JSONObject section = sections.getSection("Noticias");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Noticias");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test 
	public void checkTitleDeportesPage() {
		JSONObject section = sections.getSection("Deportes");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Deportes");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test 
	public void checkTitleMujerPage() {
		JSONObject section = sections.getSection("Mujer");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Mujer");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
				
  }
	@Test 
	public void checkTitleComunidadPage() {
		JSONObject section = sections.getSection("Comunidad");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Comunidad");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
				
  }*/

    @AfterTest(description = "Stop Browser")
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }
  
 

}
