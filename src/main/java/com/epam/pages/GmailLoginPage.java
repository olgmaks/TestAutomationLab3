package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {

    private WebDriver driver;

    @FindBy(name="identifier")
    private WebElement loginInput;

    @FindBy(id="identifierNext")
    private WebElement nextButtonLogin;

    @FindBy(name="password")
    private WebElement passwordInput;

    @FindBy(id="passwordNext")
    private WebElement nextButtonPassword;

    public GmailLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public GmailPage typeLoginAndPassword(String login, String password){
        loginInput.sendKeys(login);
        nextButtonLogin.click();
        passwordInput.sendKeys(password);
        nextButtonPassword.click();
        return new GmailPage(driver);
    }
}
