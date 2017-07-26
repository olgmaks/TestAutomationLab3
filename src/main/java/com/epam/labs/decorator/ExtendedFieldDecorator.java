package com.epam.labs.decorator;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class ExtendedFieldDecorator extends DefaultFieldDecorator {

    public ExtendedFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    // invokes for each field in the class
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decoratableClass = decoratableClass(field);
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            return createElement(loader, locator, decoratableClass);
        }
        return super.decorate(loader, field);
    }

    private Class<?> decoratableClass(Field field) {
        Class<?> clazz = field.getType();
        // element should have a constructor which takes a WebElement as an argument
        try {
            clazz.getConstructor(WebElement.class);
        } catch (Exception e) {
            return null;
        }
        return clazz;
    }

    // finds WebElement and pass it to the custom class
    protected <T> T createElement(ClassLoader loader,
                                  ElementLocator locator, Class<T> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return createInstance(clazz, proxy);
    }

    // creates an instance of the class by invoking the constructor with the WebElement argument
    private <T> T createInstance(Class<T> clazz, WebElement element) {
        try {
            return (T) clazz.getConstructor(WebElement.class)
                    .newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }
}