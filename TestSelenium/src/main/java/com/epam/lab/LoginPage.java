package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name="identifier")
    private WebElement loginName;
    @FindBy(name="password")
    private WebElement passwordField;
    @FindBy(id="identifierNext")
    private WebElement buttonLoginNext;
    @FindBy(id="passwordNext")
    private WebElement buttonPasswordNext;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeLoginAndSubmit(String login){
        loginName.sendKeys(login);
        buttonLoginNext.click();
    }
    public void enterPasswordAndSubmit(String password){
        passwordField.sendKeys(password);
        buttonPasswordNext.click();
    }
}

