package com.epam.tlmd.steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.epam.tlmd.pages.QAPage;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.SectionsJSON;

public class Steps {
	
	private WebDriver driver;
	private static SectionsJSON sectionsHub;

    public void initDriver(){
        driver = DriverSingleton.getDriver();
    }
    
    public void openLink(String link){
    	driver.navigate().to(link);
    }
    
    public void setSections(String fileName)  {
  		sectionsHub = new SectionsJSON();
  		sectionsHub.readSections(fileName);
      }
    
    public JSONObject getSections()  {
  		return sectionsHub.getSections();

      }
    public String getSectionLink(String sectionName)  {
  		return (String) sectionsHub.getSection(sectionName).get("link");

      }
    public String getExpectedTitle(String sectionName)  {
  		return (String) sectionsHub.getSection(sectionName).get("title");

      }
    public JSONObject getSection(String sectionName){
		JSONObject section = sectionsHub.getSection(sectionName);
		return section;
	}
    public ArrayList<String> getSectionNames(){
		ArrayList<String> sectionNames = new ArrayList<String>();
		Set sections = sectionsHub.getSections().keySet();
		Iterator it = sections.iterator();
		while(it.hasNext()){
			sectionNames.add(it.next().toString());
		}
		return sectionNames;
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
    	QAPage qaPage = new QAPage(driver);
    	switch(sectionName) {
	    	case "SeriesYNovelas":
	    		qaPage.goToNovelas();
	    		break;
		    case "SuperSeries":
				qaPage.goToSeries();
				break;
			case "Shows":
				qaPage.goToShows();
				break;
			case "Entretenimiento":
				qaPage.goToEntretenimiento();
				break;
			case "Videos":
				qaPage.goToVideos();
				break;
			case "Noticias":
				qaPage.goToNoticias();
				break;
			case "Deportes":
				qaPage.goToDeportes();
				break;
			case "Mujer":
				qaPage.goToMujer();
				break;
			case "Comunidad":
				qaPage.goToComunidad();
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
    public void openQAPage() {
		QAPage qaPage = new QAPage(driver);
		qaPage.openPage();
	}
    
    public void closeDriver(){
        driver.close();
    }

	


}
