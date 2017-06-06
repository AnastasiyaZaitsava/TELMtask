package com.epam.tlmd.tests;

import org.testng.annotations.*;

import com.epam.tlmd.steps.Steps;
import com.epam.tlmd.util.DriverSingleton;

import org.testng.annotations.BeforeMethod;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class CheckTitlesWithSectionHubTest {
	private Steps steps;
	
	@BeforeTest(description = "Init browser", groups = {"withHub.oneWindow", "withHub.newWindow"})
     public void setUp()  {
		steps = new Steps();
		steps.initDriver();
		steps.setSections();
     }
  
		
	@BeforeMethod(groups = {"withHub.oneWindow", "withHub.newWindow"})
	public void beforeMethod() {
		steps.openAccPage();
	}


	
	@Test (groups = "withHub.oneWindow")
	public void checkTitleNovelasPage() {
		JSONObject section = steps.getSection("SeriesYNovelas");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("SeriesYNovelas");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withHub.oneWindow")
	public void checkTitleSuperSeriesPage() {
		JSONObject section = steps.getSection("SuperSeries");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("SuperSeries");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withHub.oneWindow")
	public void checkTitleShowsPage() {
		JSONObject section = steps.getSection("Shows");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Shows");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withHub.oneWindow")
	public void checkTitleEntretenimientoPage() {
		JSONObject section = steps.getSection("Entretenimiento");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Entretenimiento");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withHub.oneWindow")
	public void checkTitleVideosPage() {
		JSONObject section = steps.getSection("Videos");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Videos");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withHub.oneWindow")
	public void checkTitleNoticiasPage() {
		JSONObject section = steps.getSection("Noticias");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Noticias");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withHub.newWindow")
	public void checkTitleDeportesPage() {
		JSONObject section = steps.getSection("Deportes");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Deportes");
		steps.switchToWindow();
		Assert.assertTrue(steps.checkPageTitle(expTitle));
			
  }
	@Test (groups = "withHub.oneWindow")
	public void checkTitleMujerPage() {
		JSONObject section = steps.getSection("Mujer");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Mujer");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
				
  }
	@Test (groups = "withHub.oneWindow")
	public void checkTitleComunidadPage() {
		JSONObject section = steps.getSection("Comunidad");
		String expTitle = (String) section.get("title");
		steps.openPageFromHub("Comunidad");
		Assert.assertTrue(steps.checkPageTitle(expTitle));
				
  }

    @AfterTest(description = "Stop Browser", groups = {"withHub.oneWindow", "withHub.newWindow", "withHub.*"})
     public void stopBrowser()  {
    	DriverSingleton.closeDriver();
     }
  
 

}
