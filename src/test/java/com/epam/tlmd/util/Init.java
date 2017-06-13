package com.epam.tlmd.util;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

public class Init {

	public Init(){}
	
	public static DesiredCapabilities setDesiredCapabilities(){
		DesiredCapabilities capabilities = setBrowser();
		String browserVersion = System.getProperty("browser.version");
		if (browserVersion != null){
			capabilities.setVersion(browserVersion);
		}
		capabilities.setCapability("platform", Platform.WINDOWS);		
        return capabilities;
	}
	
	private static DesiredCapabilities setBrowser(){
		DesiredCapabilities capability;
        String browserName = System.getProperty("browser.name");
        if(browserName != null){
        	browserName.toLowerCase();
        	if(browserName.contains("firefox")){
        		capability = DesiredCapabilities.firefox();
        	}
        	else if (browserName.contains("chrome")){
	            capability = DesiredCapabilities.chrome();
        	}
        	else{
	            capability = DesiredCapabilities.chrome();
	        }
        }
        else{
        	capability = DesiredCapabilities.chrome();
        }
        return capability;
	}
	
	public static String getEnviroment(){
		String enviroment  = System.getProperty("enviroment");
		if (enviroment == null){
			enviroment = getDefault("enviroment");
		}
		return enviroment;
	}
	
	public static String getRemoteWD(){
		String remoteWDurl  = System.getProperty("remoteWDurl");
		if (remoteWDurl == null){
			remoteWDurl = getDefault("remoteWDurl");
		}		
		return remoteWDurl;
	}
	
	public static String getDefault(String settingsName){
		JSONObject settings = readFile("DefaultSettings.json");
		String setting = (String) settings.get(settingsName);
		return setting;
	}
	
	public static JSONObject readFile(String fileName){
		JSONParser parser = new JSONParser();
		JSONObject fileObj = new JSONObject();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		String filePath = cl.getResource(fileName).getPath();
		try {
			fileObj = (JSONObject) parser.parse(new FileReader(filePath));
			
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		} 
		return fileObj;
	}
}
