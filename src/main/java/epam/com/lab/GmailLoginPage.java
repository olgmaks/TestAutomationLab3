package epam.com.lab;


import epam.com.lab.decoratorGmail.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GmailLoginPage {

    @FindBy(xpath = "//input[@name='identifier']")
    private TextInput loginInput;
    @FindBy(id = "identifierNext")
    private Button nextButton;
    @FindBy(css = "input[name='password']")
    private TextInput passwordInput;
    @FindBy(id = "passwordNext")
    private Button passwordNext;
    @FindBy(xpath = "//div[@class='dEOOab RxsGPe']")
    private Label wrongPassword;


    public GmailLoginPage() {

        PageFactory.initElements(new CustomFieldDecorator(ThreadDriverInstance.getDriver()), this);
    }


    public void getConnect(String email, String password) {
        loginInput.sendKeys(email);
        nextButton.click();
        passwordInput.sendKeys(password);
        passwordNext.click();

    }

    public boolean isMyAccountMessageVisible() {
        boolean b = true;
        if ((wrongPassword.getText()).equals("Неправильний пароль. Спробуйте ще раз.")) {
            b = false;
        }
        return b;
    }

}
