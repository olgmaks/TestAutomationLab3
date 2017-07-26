package com.epam.lab.pages;

import com.epam.lab.controls.elements.Button;
import com.epam.lab.controls.CustomFieldDecorator;
import com.epam.lab.controls.elements.TextInput;
import com.epam.lab.util.DriverConnectionUtil;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GMailLoginPage {
    @FindBy(id ="identifierId")
    private TextInput loginInput;
    @FindBy(id="identifierNext")
    private Button nextLoginButton;
    @FindBy(name="password")
    private TextInput passwordInput;
    @FindBy(css = "#passwordNext")
    private Button nextPasswordButton;

    public  GMailLoginPage(){
        PageFactory.initElements(
                new CustomFieldDecorator(DriverConnectionUtil.getWebDriver()),
                this);
    }

    public void passwordAndSubmit(String password){
        passwordInput.sendKeys(password);
                new WebDriverWait(DriverConnectionUtil.getWebDriver(), 30).
                        until(ExpectedConditions.visibilityOf(nextPasswordButton));
                nextPasswordButton.click();
    }

    public void loginAndSubmit(String login){
        loginInput.sendKeys(login);
            nextLoginButton.click();
    }
}
