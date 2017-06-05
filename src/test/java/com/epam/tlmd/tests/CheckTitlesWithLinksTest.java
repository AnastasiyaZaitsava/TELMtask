package com.epam.tlmd.tests;

import org.testng.annotations.Test;


import com.epam.tlmd.steps.Steps;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.SectionsJSON;

import org.testng.annotations.BeforeTest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckTitlesWithLinksTest {

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
	
	@Test
	public void checkTitleNovelasPage() {
		JSONObject section = sections.getSection("SeriesYNovelas");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test
	public void checkTitleSuperSeriesPage() {
		JSONObject section = sections.getSection("SuperSeries");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test
	public void checkTitleShowsPage() {
		JSONObject section = sections.getSection("Shows");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test
	public void checkTitleEntretenimientoPage() {
		JSONObject section = sections.getSection("Entretenimiento");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test 
	public void checkTitleVideosPage() {
		JSONObject section = sections.getSection("Videos");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test 
	public void checkTitleNoticiasPage() {
		JSONObject section = sections.getSection("Noticias");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test 
	public void checkTitleDeportesPage() {
		JSONObject section = sections.getSection("Deportes");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test 
	public void checkTitleMujerPage() {
		JSONObject section = sections.getSection("Mujer");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
				
  }
	@Test 
	public void checkTitleComunidadPage() {
		JSONObject section = sections.getSection("Comunidad");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
				
  }

    @AfterTest(description = "Stop Browser")
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }

}
