package com.epam.lab.util;

import com.epam.lab.help.ConfigProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DriverConnectionUtil {
    private static WebDriver driver ;
    private static ConfigProperty property = new ConfigProperty();

   static  {
        System.setProperty(property.getPropertyValue("chrome.driver"),
                property.getPropertyValue("chrome.uri"));
    }
    private DriverConnectionUtil(){ }

    public static WebDriver getChromeWebDriver(){

        if(driver == null){
            driver = new ChromeDriver() {
                {
                    manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                }
            };
            setDriverUrl(property.getPropertyValue("chrome.url"));
        }
        return  driver;
    }

    public static  void setDriverUrl(String url){
        getChromeWebDriver().get(url);
    }
}
