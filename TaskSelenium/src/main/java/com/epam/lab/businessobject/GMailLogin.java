package com.epam.lab.businessobject;

import com.epam.lab.help.ConfigProperty;
import com.epam.lab.pages.GMailLoginPage;
import com.epam.lab.util.DriverConnectionUtil;


public class GMailLogin {
    private GMailLoginPage login;
    private ConfigProperty property= new ConfigProperty();

    public void loginInEmail(String login,String password) {
        this.load();
        this.login = new GMailLoginPage();
        this.login.loginAndSubmit(login);
        this.login.passwordAndSubmit(password);
    }
    public void load(){
        DriverConnectionUtil.load(property.getPropertyValue("chrome.url"));
    }


}
