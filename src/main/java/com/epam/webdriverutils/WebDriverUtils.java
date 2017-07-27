package com.epam.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

    private WebDriverUtils(){
    }

    public static void close(){
        if(getDriver() != null){
            try{
                getDriver().quit();
            }catch (Exception e){
                e.printStackTrace();
            }
            threadLocalScope.remove();
        }
    }

    private static final ThreadLocal<WebDriver> threadLocalScope = new  ThreadLocal<WebDriver>(){
        @Override
        protected WebDriver initialValue() {
            System.out.println("Thread" +Thread.currentThread().getId());

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            return driver;
        }
    };
    public static WebDriver getDriver() {
        return threadLocalScope.get();
    }

}
