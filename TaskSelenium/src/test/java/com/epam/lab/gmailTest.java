package com.epam.lab;

import com.epam.lab.help.UserTestInfo;
import com.epam.lab.pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class gmailTest {

    static {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    }
    private WebDriver  driver = new ChromeDriver(){
        {
            manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            get("http://mail.google.com");
        }
    };

    @Before
    public void start(){
    }

    @After
    public void finish(){
        driver.quit();
    }

    @Test(priority = 1)
    public void loginTest(){
        GMailPageLogin login = new GMailPageLogin(driver);
        login.loginAndSubmit(UserTestInfo.LOGIN);
    }

    @Test(priority = 2)
    public void passwordTest(){
        GMailPagePassword password = new GMailPagePassword(driver);
        password.passwordAndSubmit(UserTestInfo.PASSWORD);
    }

    @Test(priority = 3)
    public void composeLetterTest(){
        GMailPage letter = new GMailPageDraft(driver);
        letter.checkCompose();
        letter.createComposeMenu().composeLetter(UserTestInfo.TO,UserTestInfo.CC,
                UserTestInfo.BCC,UserTestInfo.SUBJECT,UserTestInfo.TEXT);
    }


    @Test(priority = 4)
    public void findLastDraftLetterAndSendTest(){
        GMailPageDraft draft = new GMailPageDraft(driver);
        draft.openDraft();
        draft.openLastDraftLetter();
        GMailComposeMenu menu = draft.createComposeMenu();
        menu.clickAria();
        List<String> letterUser = menu.getDraftLetter();
        List<String> letter = new ArrayList<>();
        letter.add(UserTestInfo.TO);
        letter.add(UserTestInfo.CC);
        letter.add(UserTestInfo.BCC);
        letter.add(UserTestInfo.SUBJECT);
        letter.add(UserTestInfo.TEXT);
        Assert.assertEquals(letter,letterUser);
        menu.send();
    }
}
