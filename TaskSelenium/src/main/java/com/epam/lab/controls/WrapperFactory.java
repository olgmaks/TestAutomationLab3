package com.epam.lab.controls;

import org.openqa.selenium.WebElement;

public class WrapperFactory {
    public static MailElement createInstance(Class<MailElement> clazz, WebElement element) {
        System.out.println(element.toString());
        try {
            return clazz.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }
}
