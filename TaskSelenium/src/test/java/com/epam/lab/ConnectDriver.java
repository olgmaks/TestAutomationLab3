package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ConnectDriver {
    private static WebDriver driver ;
    private static Properties properties = new Properties();

   static  {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
    }
    private ConnectDriver(){ }

    public static WebDriver getChromeWebDriver(){

        if(driver == null){
            driver = new ChromeDriver() {
                {
                    manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    get("http://mail.google.com");
                }
            };
        }
        return  driver;
    }
}
