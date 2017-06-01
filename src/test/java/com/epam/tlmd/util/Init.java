package com.epam.tlmd.util;

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
	
	public static String setEnviroment(){
		String enviroment;
		String enteredEnv = System.getProperty("enviroment");
		if (enteredEnv != null){
			enteredEnv.toLowerCase();
			if(enteredEnv.contains("acc")){
				enviroment = "http://acc.telemundo.com/";
			}
			else if (enteredEnv.contains("dev")){
				enviroment = "http://dev.telemundo.com/";
			}
			else if (enteredEnv.contains("stage")){
				enviroment = "http://stage.telemundo.com/";
			}
			else if (enteredEnv.contains("tlmd-XXXX.pr")){
				enviroment = "http://tlmd-XXXX.pr.telemundo.com/";
			}
			else{
				enviroment = "http://telemundo.com/";
			}
			
		}
		else{
			enviroment = "http://www.telemundo.com/";
		}
		return enviroment;
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
}
