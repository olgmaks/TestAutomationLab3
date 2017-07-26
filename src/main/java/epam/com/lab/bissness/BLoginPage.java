package epam.com.lab.bissness;

import epam.com.lab.*;
import epam.com.lab.model.User;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class BLoginPage {
    private GmailLoginPage loginPage;

    public void login(User user) {

        this.loginPage = new GmailLoginPage();
        loginPage.getConnect(user.getLogin(), user.getPassword());

    }

    public boolean isCorrectPassword()  {
        this.loginPage = new GmailLoginPage();
        return loginPage.isMyAccountMessageVisible();
    }
}
