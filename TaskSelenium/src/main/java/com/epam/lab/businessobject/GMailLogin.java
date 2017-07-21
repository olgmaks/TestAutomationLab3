package com.epam.lab.businessobject;

import com.epam.lab.pages.GMailLoginPage;
import com.epam.lab.pages.GMailPasswordPage;
import org.openqa.selenium.WebDriver;

public class GMailLogin {
    private GMailLoginPage login;
    private GMailPasswordPage password;

    public void loginInEmail(WebDriver driver,String login,String password){
        this.login = new GMailLoginPage(driver);
        this.login.loginAndSubmit(login);
        this.password = new GMailPasswordPage(driver);
        this.password.passwordAndSubmit(password);
    }

}
