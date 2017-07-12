package com.epam.labs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {

    private final WebDriver driver;

    @FindBy(id = "identifierId")
    private WebElement loginInput;

    @FindBy(id = "identifierNext")
    private WebElement loginNextBtn;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextBtn;

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeLoginAndSubmit(String login) {
        loginInput.sendKeys(login);
        loginNextBtn.click();
    }

    public GmailHomePage typePasswordAndSubmit(String pass) {
        passwordInput.sendKeys(pass);
        passwordNextBtn.click();
        return new GmailHomePage(driver);
    }
}
