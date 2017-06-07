package com.epam.tlmd.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONObject;
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
	
	public JSONObject getSections(){
		JSONObject sections = (JSONObject) this.sectionsHub.get("Sections");
		return sections;
		
	}
	public void readSections(URL url){
		JSONParser parser = new JSONParser();
		String filePath = url.getPath();
		try {
			sectionsHub = (JSONObject) parser.parse(new FileReader(filePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
