package com.epam.lab.bo;


import com.epam.lab.DriverProvider;
import com.epam.lab.models.User;
import com.epam.lab.pages.GmailHomePage;
import com.epam.lab.pages.GmailLoginPage;

public class GmailLoginPageBO {
    public static GmailHomePage login(String login, String password){
        GmailLoginPage loginPage = new GmailLoginPage(DriverProvider.getInstance());
        loginPage.typeLoginAndSubmit(login);
        return loginPage.typePasswordAndSubmit(password);
    }
}
