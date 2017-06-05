package com.epam.tlmd.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SectionsJSON {
	JSONObject sectionsJson;
	
	public SectionsJSON(){
		sectionsJson = new JSONObject(); 
	}
	
	public JSONObject getSection(String sectionName){
		JSONObject section = (JSONObject) this.sectionsJson.get(sectionName);
		return section;
		
	}
	public void readSections(String fileName){
		JSONParser parser = new JSONParser();
		try {
			sectionsJson = (JSONObject) parser.parse(new FileReader(fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
