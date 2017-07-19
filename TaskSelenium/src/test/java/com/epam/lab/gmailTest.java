package com.epam.lab;

import com.epam.lab.help.UserTestInfo;
import com.epam.lab.model.GMailLetter;
import com.epam.lab.pages.*;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GMailTest {
    WebDriver driver;

    @BeforeTest
    public void start(){
        driver = ConnectDriver.getChromeWebDriver();
    }

    @AfterTest
    public void finish(){
        driver.quit();
    }

    @Test
    public void loginTest(){

        GMailBox mailBox = new GMailBox();
        mailBox.loginInEmail(driver,UserTestInfo.LOGIN,UserTestInfo.PASSWORD);

        GMailPage letter = new GMailDraftPage(driver);
        letter.checkCompose();
        letter.createComposeMenu().composeLetter(UserTestInfo.TO,UserTestInfo.CC,
                UserTestInfo.BCC,UserTestInfo.SUBJECT,UserTestInfo.TEXT);

        GMailDraftPage draft = new GMailDraftPage(driver);
        draft.openDraft();
        draft.openLastDraftLetter();
        GMailComposeMenu menu = draft.createComposeMenu();
        menu.clickAria();
        GMailLetter letterUser = menu.getDraftLetter();

        Assert.assertEquals(UserTestInfo.TO,letterUser.getTo());
        Assert.assertEquals(UserTestInfo.CC,letterUser.getCc());
        Assert.assertEquals(UserTestInfo.BCC,letterUser.getBcc());
        Assert.assertEquals(UserTestInfo.SUBJECT,letterUser.getSubject());
        Assert.assertEquals(UserTestInfo.TEXT,letterUser.getText());

        menu.send();
    }
}
