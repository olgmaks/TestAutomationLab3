package com.epam.lab.pages;

import com.epam.lab.controls.Button;
import com.epam.lab.controls.CustomFieldDecorator;
import com.epam.lab.controls.TextInput;
import com.epam.lab.controls.WrapperFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.Buffer;

public class GMailLoginPage {
    @FindBy(id ="identifierId")
    private TextInput loginInput;
    @FindBy(id="identifierNext")
    private Button nextLoginButton;

    public GMailLoginPage(WebDriver driver){

        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void loginAndSubmit(String login){
        loginInput.sendKeys(login);
        nextLoginButton.click();
    }
}
