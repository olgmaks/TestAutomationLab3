package com.epam.lab.pages;

import com.epam.lab.CustomFieldDecorator;
import com.epam.lab.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {

    private WebDriver driver;

    @FindBy(id = "identifierId")
    private WebElement loginInput;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement loginButton;

    @FindBy(id = "profileIdentifier")
    private WebElement profileIdentifierTitle;

    public GmailLoginPage(WebDriver driver) {
        driver.get("https://mail.google.com/");
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(DriverProvider.getInstance()), this);
    }

    public void typeLoginAndSubmit(String login) {
        loginInput.sendKeys(login);
        nextButton.click();
        (new WebDriverWait(driver, 10)).until((dr) -> (profileIdentifierTitle).getText().contains(login.toLowerCase()));
    }

    public GmailHomePage typePasswordAndSubmit(String password) {
        passwordInput.sendKeys(password);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(loginButton)).click();
        GmailHomePage homePage = new GmailHomePage(driver);
        return homePage;
    }
}
