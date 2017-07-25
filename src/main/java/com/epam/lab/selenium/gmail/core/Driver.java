package com.epam.lab.selenium.gmail.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
    private static WebDriver instance;
    
    private Driver() {
    }
    
    public static WebDriver getInstance() { 
    	if(instance == null) {
    		instance = new ChromeDriver();
    		instance.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	}
    	return instance;
    }
    
	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>(){
	    @Override
	    protected WebDriver initialValue() {
			System.setProperty(Constants.CHROME_DRIVER_NAME, Constants.CHROME_DRIVER_PATH);
			WebDriver webDriver = new ChromeDriver();     
			webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			webDriver.get(Constants.GMAIL_DOMAIN);
			return webDriver;	    
			}

	    @Override
	    public void remove() {
	        WebDriver driver = get();
	        if (driver != null) driver.close();
	        super.remove();
	    }

	    @Override
	    public void set(WebDriver value) {
	        throw new UnsupportedOperationException();
	    }
	};
}
