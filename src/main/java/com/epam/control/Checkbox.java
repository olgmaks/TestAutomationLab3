package com.epam.control;

import org.openqa.selenium.WebElement;

public class Checkbox extends AbstractElement {
    public Checkbox(WebElement webElement) {
        super(webElement);
    }

    public void click(){
        webElement.click();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }
}
