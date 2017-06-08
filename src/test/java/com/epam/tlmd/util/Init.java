package com.epam.tlmd.util;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	        switch (browserName.toLowerCase()) {
	            case "firefox":
	                capability = DesiredCapabilities.firefox();
	                break;
	            case "chrome":
	                capability = DesiredCapabilities.chrome();
	                break;
	       
	            default:
	            	capability = DesiredCapabilities.chrome();
	                break;
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
		JSONParser parser = new JSONParser();
		JSONObject settings = new JSONObject();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		String filePath = cl.getResource("DefaultSettings.json").getPath();
		String setting = "";
		try {
			settings = (JSONObject) parser.parse(new FileReader(filePath));
			setting = (String) settings.get(settingsName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return setting;
	}
}
