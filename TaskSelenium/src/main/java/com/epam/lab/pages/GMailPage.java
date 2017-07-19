package com.epam.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class GMailPage {
    private WebDriver driver;
    @FindBy(css=".J-J5-Ji.T-I-KE.L3")
    private WebElement composeButton;
    @FindBy()
    private WebElement draftsLink;
    @FindBy(id="gbqfq")
    private WebElement ariaSearch;
    @FindBy(id="gbqfb")
    private WebElement searchButton;

    public void checkCompose(){
        getComposeButton().click();
    }

    public GMailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GMailComposeMenu createComposeMenu(){
        return new  GMailComposeMenu(driver);
    }

    public WebElement getComposeButton() {
        return composeButton;
    }

    public WebElement getDraftsLink() {
        return draftsLink;
    }

    public WebElement getAriaSearch() {
        return ariaSearch;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
