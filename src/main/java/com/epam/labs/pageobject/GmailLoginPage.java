package com.epam.labs.pageobject;

import com.epam.labs.control.Button;
import com.epam.labs.util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage {

    @FindBy(id = "identifierId")
    private WebElement loginInput;

    @FindBy(id = "identifierNext")
    private Button loginNextBtn;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private Button passwordNextBtn;

    public GmailLoginPage() {
        WebDriverUtil.initElements(this);
    }

    public void typeLoginAndSubmit(String login) {
        loginInput.sendKeys(login);
        loginNextBtn.click();
    }

    public GmailHomePage typePasswordAndSubmit(String pass) {
        passwordInput.sendKeys(pass);
        passwordNextBtn.click();
        return new GmailHomePage();
    }
}
