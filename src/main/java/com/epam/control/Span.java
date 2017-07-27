package com.epam.control;

import com.epam.webdriverutils.WebDriv;
import com.epam.webdriverutils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Span extends AbstractElement{
    public Span(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        return webElement.getText().trim();
    }

    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    public void click(){
        Actions builder = new Actions(WebDriverUtils.getDriver());
        builder.moveToElement(webElement).click().perform();
    }

    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }
}
