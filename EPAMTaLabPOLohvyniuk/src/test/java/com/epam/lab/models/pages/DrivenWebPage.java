package com.epam.lab.models.pages;

import org.openqa.selenium.WebDriver;


public abstract class DrivenWebPage {
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
}
