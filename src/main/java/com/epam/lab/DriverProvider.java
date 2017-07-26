package com.epam.lab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DriverProvider {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<Actions> actionsThreadLocal = new ThreadLocal<>();
    public static WebDriver getInstance(){
        if (driver.get() == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver.set(new ChromeDriver(options));
            driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
        }
        return driver.get();
    }

    public static Actions getActionsInstance() {
        if (actionsThreadLocal.get() == null) {
            actionsThreadLocal.set(new Actions(getInstance()));
        }
        return actionsThreadLocal.get();
    }

    public static void clear() {
        if (driver.get() != null) {
            driver.remove();
        }
    }
}
