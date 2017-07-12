package com.epam.labs;

import com.epam.labs.pageobject.GmailHomePage;
import com.epam.labs.pageobject.GmailLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailTest {

    private WebDriver driver;
    private final static String EMAIL = "smarttestlab123@gmail.com";
    private final static String PASS = "smart123";
    private final static String INCORRECT_EMAIL = "wrongemail";
    private final static String EMAIL_SUBJECT = "Test Subject";
    private final static String EMAIL_BODY = "Test message.";

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        };
        driver.get("https://www.google.com/gmail");
    }

    @Test
    public void testSend() {
        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.typeLoginAndSubmit(EMAIL);
        GmailHomePage gmailHomePage = gmailLoginPage.typePasswordAndSubmit(PASS);
        gmailHomePage.sendEmail(INCORRECT_EMAIL, EMAIL_SUBJECT, EMAIL_BODY, false);
        gmailHomePage.closeWarningDialog();
        gmailHomePage.sendEmail(EMAIL, EMAIL_SUBJECT, EMAIL_BODY, true);
        Assert.assertTrue(gmailHomePage.checkSentMails(EMAIL, EMAIL_SUBJECT));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}