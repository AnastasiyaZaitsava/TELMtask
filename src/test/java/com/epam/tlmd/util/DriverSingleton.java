package com.epam.tlmd.util;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverSingleton {

    private static WebDriver driver;
    private DriverSingleton(){};


    public static WebDriver getDriver()
    {
        if (null == driver){
        	DesiredCapabilities capabilities = Init.setDesiredCapabilities();
            try {
            	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
            	e.printStackTrace();
            }
            //not working with firefox
     //      driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);  
     //      driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
           driver.manage().window().maximize();
        }
        return driver;
    }
    
    private static DesiredCapabilities setDesireCapabilities() {
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
	            	capability = DesiredCapabilities.firefox();
	                break;
	        }
        }
        else{
        	capability = DesiredCapabilities.firefox();
        }

        return capability;
    }

    public static void closeDriver()
    {
        driver.quit();
        driver = null;
    }
}