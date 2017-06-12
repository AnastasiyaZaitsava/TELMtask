package com.epam.tlmd.steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.epam.tlmd.pages.MainPage;
import com.epam.tlmd.util.DriverSingleton;
import com.epam.tlmd.util.SectionsJSON;

public class Steps {
	
	private WebDriver driver;
	private static SectionsJSON sectionsHub;

    public void initDriver(){
    	DriverSingleton driverInstance = new DriverSingleton();
        driver = driverInstance.getDriver();
    }
    
    public void openLink(String link){
    	driver.navigate().to(link);
    	Reporter.log("Following a link: " + link);
    }
    
    public void setSections(String fileName)  {
  		sectionsHub = new SectionsJSON();
  		sectionsHub.readSections(fileName);
      }
    
    public ArrayList<JSONObject> getSections()  {
    	Iterator<?> it = sectionsHub.getSections(); 
    	ArrayList<JSONObject> sections = new ArrayList<JSONObject>(); 
        while (it.hasNext()) {
            JSONObject section = (JSONObject) it.next();
            sections.add(section);
        }
        return sections;
    }
  
    public boolean checkPageTitle(String expTitle){
    	String actTitle = driver.getTitle();
    	Reporter.log("EXPECTED TITLE CONTAINS:" + expTitle);
    	Reporter.log("ACTUAL TITLE: " + actTitle);
    	if (actTitle.contains(expTitle)){
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public void openPageFromHub(String sectionLink){
    	MainPage mainPage = new MainPage(driver);
    	WebElement button = mainPage.menuLink(sectionLink);
    	System.out.println("Found section and go to " + button.getText());
    	button.click(); 	
    }
    
    public WebElement getSectionButton(String sectionLink){
    	MainPage mainPage = new MainPage(driver);
    	WebElement button = mainPage.menuLink(sectionLink);
    	return button; 	
    }
    
    public void switchToWindow(){
    	
    	for(String winHandle : driver.getWindowHandles()){
    		driver.switchTo().window(winHandle);
    	}
    }
    
    public void closeDriver(){
        driver.quit();
        driver = null;
    }

}
