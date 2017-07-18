package com.epam.lab;


import com.epam.lab.consts.Constants;
import com.epam.lab.models.Message;
import com.epam.lab.models.pages.GmailHomePage;
import com.epam.lab.models.pages.GmailLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class GmailTest {

    Actions keyAction = null;
    private WebDriver driver;
    private GmailLoginPage loginPage;
    private GmailHomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        keyAction = new Actions(driver);
    }

    @Test(priority = 0)
    public void openMailPageTest() {
        driver.get("https://www.google.com/gmail/");
    }

    @Test(dependsOnMethods = "openMailPageTest")
    public void loginTest() {
        loginPage = new GmailLoginPage(driver);
        loginPage.typeLoginAndSubmit(Constants.DEFAULT_USER.getLogin());
        homePage = loginPage.typePasswordAndSubmit(Constants.DEFAULT_USER.getPassword());
        assertNotNull(homePage);
    }

    @Test(dependsOnMethods = "loginTest")
    public void writeNewDraftTest() {
        GmailHomePage.MessageForm messageForm = homePage.openNewMessageForm();
        assertNotNull(messageForm);
        homePage.writeNewDraft(messageForm, Constants.WHATS_UP_MESSAGE);
    }

    @Test(dependsOnMethods = "writeNewDraftTest")
    public void getPreviousDraftAndSendItTest() {
        homePage.openDrafts();
        Message message = homePage.getMessageFromMessageForm(homePage.openLastDraft());
        assertNotNull(message);
        assertEquals(Constants.WHATS_UP_MESSAGE, message);
        homePage.sendDraft();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
