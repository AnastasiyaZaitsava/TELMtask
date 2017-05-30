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
   // 	System.setProperty("webdriver.gecko.driver", "C:/Gecko/geckodriver.exe");
        if (null == driver){
        	
        	//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("platform", Platform.WINDOWS);
            try {
            	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
            			// TODO Auto-generated catch block
            	e.printStackTrace();
            }
           driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
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