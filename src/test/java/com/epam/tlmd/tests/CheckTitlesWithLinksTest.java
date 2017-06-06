package com.epam.tlmd.tests;

import com.epam.tlmd.steps.Steps;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.SectionsJSON;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckTitlesWithLinksTest {

	
	private Steps steps;
	
	@BeforeSuite(description = "Init", alwaysRun = true)
     public void setUp()  {
		steps = new Steps();
		steps.initDriver();
		steps.setSections();
     }
  
	
	
	@Test (groups = "withLinks.oneWindow")
	public void checkTitleNovelasPage() {
		JSONObject section = steps.getSection("SeriesYNovelas");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withLinks.oneWindow")
	public void checkTitleSuperSeriesPage() {
		JSONObject section = steps.getSection("SuperSeries");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withLinks.oneWindow")
	public void checkTitleShowsPage() {
		JSONObject section = steps.getSection("Shows");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withLinks.oneWindow")
	public void checkTitleEntretenimientoPage() {
		JSONObject section = steps.getSection("Entretenimiento");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withLinks.oneWindow")
	public void checkTitleVideosPage() {
		JSONObject section = steps.getSection("Videos");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withLinks.oneWindow")
	public void checkTitleNoticiasPage() {
		JSONObject section = steps.getSection("Noticias");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withLinks.newWindow")
	public void checkTitleDeportesPage() {
		JSONObject section = steps.getSection("Deportes");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withLinks.oneWindow")
	public void checkTitleMujerPage() {
		JSONObject section = steps.getSection("Mujer");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
				
  }
	@Test (groups = "withLinks.oneWindow")
	public void checkTitleComunidadPage() {
		JSONObject section = steps.getSection("Comunidad");
		String pageLink = (String) section.get("link");
		String expTitle = (String) section.get("title");
		steps.openLink(pageLink);
		Assert.assertTrue(steps.checkPageTitle(expTitle));
				
  }

    @AfterSuite(description = "Stop Browser", alwaysRun = true)
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }

   
 
}
