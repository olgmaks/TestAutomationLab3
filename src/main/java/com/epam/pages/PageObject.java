package com.epam.pages;

import com.epam.PropertyData;
import com.epam.control.CustomFieldDecorator;
import com.epam.webdriverutils.WebDriv;
import com.epam.webdriverutils.WebDriverUtils;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PageObject {

    public PageObject(){
        try {
            PropertyData.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(PropertyData.getDriverFromProperty(), PropertyData.getDriverSrcFromProperty());
        PageFactory.initElements(new CustomFieldDecorator(WebDriverUtils.getDriver()), this);
    }

}
