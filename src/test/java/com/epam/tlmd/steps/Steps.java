package com.epam.tlmd.steps;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.epam.tlmd.pages.AccPage;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.SectionsJSON;

public class Steps {
	
	private WebDriver driver;
	private static SectionsJSON sections;

    public void initDriver(){
        driver = DriverSingleton.getDriver();
    }
    
    public void openLink(String link){
    	driver.navigate().to(link);
    }
    
    public void setSections()  {
  		sections = new SectionsJSON();
  		sections.readSections("Sections.json");
      }
    
    public JSONObject getSection(String sectionName){
		JSONObject section = sections.getSection(sectionName);
		return section;
		
	}
    public boolean checkPageTitle(String expTitle){
    	String actTitle = driver.getTitle();
    	System.out.println("ACTUAL TITLE: " + actTitle);
    	if (actTitle.contains(expTitle)){
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public void openPageFromHub(String sectionName){
    	AccPage accPage = new AccPage(driver);
    	switch(sectionName) {
	    	case "SeriesYNovelas":
	    		accPage.goToNovelas();
	    		break;
		    case "SuperSeries":
				accPage.goToSeries();
				break;
			case "Shows":
				accPage.goToShows();
				break;
			case "Entretenimiento":
				accPage.goToEntretenimiento();
				break;
			case "Videos":
				accPage.goToVideos();
				break;
			case "Noticias":
				accPage.goToNoticias();
				break;
			case "Deportes":
				accPage.goToDeportes();
				break;
			case "Mujer":
				accPage.goToMujer();
				break;
			case "Comunidad":
				accPage.goToComunidad();
				break;
			default:
				break;
    	}
    }
    
    public void switchToWindow(){
    	
    	for(String winHandle : driver.getWindowHandles()){
    		driver.switchTo().window(winHandle);
    	}

    }
    public void openAccPage() {
		AccPage accPage = new AccPage(driver);
		accPage.openPage();
	}
    
    public void closeDriver(){
        driver.close();
    }

	


}
