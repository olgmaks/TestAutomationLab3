package com.epam.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GMailPageLogin {
    @FindBy(id ="identifierId")
    private WebElement loginInput;
    @FindBy(id="identifierNext")
    private WebElement nextLoginButton;

    public GMailPageLogin(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void loginAndSubmit(String login){
        loginInput.sendKeys(login);
        nextLoginButton.click();
    }
}
