package com.epam.lab;

import com.epam.lab.businessobject.GMailBox;
import com.epam.lab.businessobject.GMailLogin;
import com.epam.lab.help.UserTestInfo;
import com.epam.lab.model.GMailLetter;
import com.epam.lab.util.DriverConnectionUtil;
import org.testng.Assert;
import org.testng.annotations.*;



public class GMailTest {

    @DataProvider(name = "UserInfo",parallel = true)
    public static Object[][] credentials(){
        return new Object[][]{
                {UserTestInfo.LOGIN_ONE, UserTestInfo.PASSWORD_ONE},
                {UserTestInfo.LOGIN_TWO, UserTestInfo.PASSWORD_TWO},
                {UserTestInfo.LOGIN_THREE, UserTestInfo.PASSWORD_THREE},
                {UserTestInfo.LOGIN_FOUR, UserTestInfo.PASSWORD_FOUR},
                {UserTestInfo.LOGIN_FIVE, UserTestInfo.PASSWORD_FIVE}
        };
    }

    @AfterMethod
    public void finish(){
        DriverConnectionUtil.close();
    }

    @Test(dataProvider = "UserInfo")
    public void mailTest(String login, String password){
        GMailLogin loginPage = new GMailLogin();
        GMailBox mailBox = new GMailBox();

        loginPage.loginInEmail(login,password);
        mailBox.composeLetter(UserTestInfo.TO,UserTestInfo.CC,
                UserTestInfo.BCC,UserTestInfo.SUBJECT,UserTestInfo.TEXT);

        GMailLetter letterUser = mailBox.getDraftLetter();

        Assert.assertEquals(UserTestInfo.TO,letterUser.getTo());
        Assert.assertEquals(UserTestInfo.CC,letterUser.getCc());
        Assert.assertEquals(UserTestInfo.BCC,letterUser.getBcc());
        Assert.assertEquals(UserTestInfo.SUBJECT,letterUser.getSubject());
        Assert.assertEquals(UserTestInfo.TEXT,letterUser.getText());

        mailBox.send();
    }
}
