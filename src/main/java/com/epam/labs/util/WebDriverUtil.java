package com.epam.labs.util;

import com.epam.labs.decorator.ExtendedFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class WebDriverUtil {
    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> new ChromeDriver() {
        {
            manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    });

    private WebDriverUtil() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void openURL(String url) {
        getDriver().get(url);
    }

    public static void initElements(Object page) {
        PageFactory.initElements(new ExtendedFieldDecorator(getDriver()), page);
    }

    public static void close() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        driver.remove();
    }
}