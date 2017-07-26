package SeleniumTest.business_objects;

import SeleniumTest.pages.GmailLoginPage;
import SeleniumTest.pages.GmailPasswordPage;

public class GmailLoginBO {
    private GmailLoginPage loginPage;
    private GmailPasswordPage passwordPage;

    public boolean asUser(String login){
        loginPage = new GmailLoginPage();
        loginPage.enterLogin(login);
        loginPage.submit();
        return  (loginPage.hasntErrorMassage());
    }
    public boolean withPassword(String password){
        passwordPage = new GmailPasswordPage();
        passwordPage.enterPassword(password);
        passwordPage.submit();
        return  (passwordPage.hasntErrorMassage());
    }
}
