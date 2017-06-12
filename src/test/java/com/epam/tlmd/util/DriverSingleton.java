package com.epam.tlmd.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverSingleton {

    private WebDriver driver;
    public DriverSingleton(){};


    public WebDriver getDriver()
    {
        	DesiredCapabilities capabilities = Init.setDesiredCapabilities();
        	String remoteWDurl = Init.getRemoteWD();
            try {
            	this.driver = new RemoteWebDriver(new URL(remoteWDurl), capabilities);
            } catch (MalformedURLException e) {
            	e.printStackTrace();
            	//Reporter.log(e.getMessage());
            }
            //not working with firefox
     //      driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);  
     //      driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
           driver.manage().window().maximize();

        return driver;
    }
    
    public void closeDriver()
    {
        driver.quit();
        driver = null;
    }
}