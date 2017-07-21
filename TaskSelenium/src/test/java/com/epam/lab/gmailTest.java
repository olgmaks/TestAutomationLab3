package com.epam.lab;

import com.epam.lab.businessobject.GMailBox;
import com.epam.lab.businessobject.GMailLogin;
import com.epam.lab.help.UserTestInfo;
import com.epam.lab.model.GMailLetter;

import com.epam.lab.util.DriverConnectionUtil;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GMailTest {
    WebDriver driver;

    @BeforeTest
    public void start(){
        driver = DriverConnectionUtil.getChromeWebDriver();
    }

    @AfterTest
    public void finish(){
        driver.quit();
    }

    @Test
    public void loginTest(){

        GMailLogin login = new GMailLogin();
        GMailBox mailBox = new GMailBox(driver);

        login.loginInEmail(driver,UserTestInfo.LOGIN,UserTestInfo.PASSWORD);
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
