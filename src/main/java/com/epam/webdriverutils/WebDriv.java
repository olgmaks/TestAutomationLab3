package com.epam.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriv {

    private static ThreadLocal<WebDriver> threadLocalScope = new  ThreadLocal<>();

    public static WebDriver getInstance() {
        if (threadLocalScope.get() == null) {
            WebDriver driver  = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            threadLocalScope.set(driver);
        }
        return threadLocalScope.get();
    }

    public static void close(){
        if(getInstance() != null){
            try{
                getInstance().quit();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        threadLocalScope.remove();
    }
}
