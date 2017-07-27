package com.epam.control;

import org.openqa.selenium.WebElement;

public class Button extends AbstractElement{
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click(){
        webElement.click();
    }

    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }
}
