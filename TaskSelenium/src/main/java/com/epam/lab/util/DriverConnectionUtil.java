package com.epam.lab.util;

import com.epam.lab.help.ConfigProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class DriverConnectionUtil {
    private static ThreadLocal <WebDriver> drivers = new InheritableThreadLocal<>() ;
    private static ConfigProperty property = new ConfigProperty();
    private static WebDriver driver;

   static  {
        System.setProperty(property.getPropertyValue("chrome.driver"),
                property.getPropertyValue("chrome.uri"));
    }

    public  static WebDriver getWebDriver(){
        if (drivers.get()== null){
            driver = new ChromeDriver() {
                {
                    manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                }
            };
            setWebDriver(driver);
        }
        return  drivers.get();
    }

    public static void setWebDriver(WebDriver driver){
        if(driver != null){
            drivers.set(driver);
        }
    }

    public static void load(String url){
        DriverConnectionUtil.getWebDriver().get(url);
    }

    public static void close(){

        drivers.get().quit();
    }
}
