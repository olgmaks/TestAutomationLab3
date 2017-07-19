package com.epam.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GMailPasswordPage {
    @FindBy(name="password")
    private WebElement passwordInput;
    @FindBy(id="passwordNext")
    private WebElement nextPasswordButton;

    public GMailPasswordPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    public void passwordAndSubmit(String password){
        passwordInput.sendKeys(password);
        nextPasswordButton.click();
    }
}
