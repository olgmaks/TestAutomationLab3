package com.epam.businessobject;

import com.epam.models.UserModel;
import com.epam.pages.GmailLoginPage;
import com.epam.pages.GmailPage;

import java.io.IOException;

public class GmailLoginBO{

    public String login(UserModel user){
        GmailLoginPage gmailLoginPage = null;
        try {
            gmailLoginPage = new GmailLoginPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gmailLoginPage.typeLoginAndSubmit(user.getEmail());
        GmailPage gmailHomePage = gmailLoginPage.typePasswordAndSubmit(user.getPassword());
        return gmailHomePage.verificationThatPageIsOpened();
    }
}
