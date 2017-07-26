package com.epam.labs.businessobject;

import com.epam.labs.model.User;
import com.epam.labs.pageobject.GmailHomePage;
import com.epam.labs.pageobject.GmailLoginPage;

public class LoginBO {

    private User user;
    private GmailLoginPage gmailLoginPage;

    public LoginBO(User user) {
        gmailLoginPage = new GmailLoginPage();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public GmailHomePage login() {
        gmailLoginPage.typeLoginAndSubmit(user.getEmail());
        return gmailLoginPage.typePasswordAndSubmit(user.getPassword());
    }
}