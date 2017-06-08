package com.epam.tlmd.util;

import org.openqa.selenium.WebDriver;
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
        	String remoteWDurl = Init.getRemoteWD();
            try {
            	driver = new RemoteWebDriver(new URL(remoteWDurl), capabilities);
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
    
    public static void closeDriver()
    {
        driver.quit();
        driver = null;
    }
}