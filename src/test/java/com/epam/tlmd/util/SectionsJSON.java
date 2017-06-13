package com.epam.tlmd.util;

import java.util.Iterator;
import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.json.simple.JSONArray;


public class SectionsJSON {
	JSONObject sectionsHub;
	
	public SectionsJSON()  {
		sectionsHub = new JSONObject(); 
	}
	
	public Iterator<?> getSections()  {
		 JSONArray sectionsArray = (JSONArray) sectionsHub.get("Sections");
		 Iterator<?> it = sectionsArray.iterator();
		 return it;
	}
	
	public void readSections(String fileName)  {
		sectionsHub = Init.readFile(fileName);
		Reporter.log("Reading sections data from file " + fileName);
	}
}
