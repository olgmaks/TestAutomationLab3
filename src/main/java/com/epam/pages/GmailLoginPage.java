package com.epam.pages;

import com.epam.PropertyData;
import com.epam.control.Button;
import com.epam.control.TextInput;
import com.epam.webdriverutils.WebDriv;
import com.epam.webdriverutils.WebDriverUtils;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class GmailLoginPage extends PageObject{

    @FindBy(name="identifier")
    private TextInput loginInput;

    @FindBy(id="identifierNext")
    private Button nextButtonLogin;

    @FindBy(name="password")
    private TextInput passwordInput;

    @FindBy(id="passwordNext")
    private Button nextButtonPassword;

    public GmailLoginPage() throws IOException {
        super();
        PropertyData.loadData();
        WebDriverUtils.getDriver().get(PropertyData.getURLFromProperty());
    }

    public GmailLoginPage typeLoginAndSubmit(String login){
        loginInput.sendKeys(login);
        nextButtonLogin.click();
        return this;
    }

    public GmailPage typePasswordAndSubmit(String password){
        passwordInput.sendKeys(password);
        nextButtonPassword.click();
        return new GmailPage();
    }
}
