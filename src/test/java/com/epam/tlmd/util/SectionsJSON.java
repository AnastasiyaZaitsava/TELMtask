package com.epam.tlmd.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SectionsJSON {
	JSONObject sectionsHub;
	
	public SectionsJSON(){
		sectionsHub = new JSONObject(); 
	}
	
	public JSONObject getSection(String sectionName){
		JSONObject sections = (JSONObject) this.sectionsHub.get("Sections");
		return (JSONObject) sections.get(sectionName);
	}
	
	
	public Iterator<?> getSections(){
		 JSONArray sectionsArray = (JSONArray) sectionsHub.get("Sections");
		 Iterator<?> it = sectionsArray.iterator();
		 return it;
	}
	
	public void readSections(String fileName){
		JSONParser parser = new JSONParser();
		ClassLoader cl = this.getClass().getClassLoader();
		String filePath = cl.getResource(fileName).getPath();
		try {
			sectionsHub = (JSONObject) parser.parse(new FileReader(filePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
