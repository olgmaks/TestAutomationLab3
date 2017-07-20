package com.epam.tests;

import com.epam.pages.GmailLoginPage;
import com.epam.pages.GmailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GmailTest {
    WebDriver driver;
    GmailLoginPage gmailLoginPage;
    GmailPage gmailPage;
    CrunchifyPropertyValues propertyValues;

    @BeforeClass
    public void before(){
        propertyValues = new CrunchifyPropertyValues();
        System.setProperty(propertyValues.getPropValuePropertyDriver(), propertyValues.getPropValuePropertySrc());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(propertyValues.getPropValueURL());
    }

    @Test
    public void testDeleteSelectedMessagesAndThanCancelDelete(){
        gmailLoginPage = new GmailLoginPage(driver);
        gmailPage = gmailLoginPage.typeLoginAndPassword(propertyValues.getPropValueLogin(), propertyValues.getPropValuePassword());
        Assert.assertTrue(gmailPage.verificationThatPageIsOpened().contains(propertyValues.getPropValueLogin()));

        gmailPage.selectTreeMessages();
        Assert.assertEquals(gmailPage.getCountOfSelectedMessages(), DataHelp.SELECTED_MESSAGES);

        gmailPage.deleteSelectedMessages();
        Assert.assertEquals(gmailPage.getCountOfSelectedMessages(), DataHelp.SELECTED_MESSAGES_AFTER_DELETE);

        Assert.assertEquals(gmailPage.getCancelDeleteSpan().getText(), DataHelp.CANCEL_DELETE_SPAN_TEXT);

        gmailPage.cancelDeleteMessages();
        Assert.assertEquals(gmailPage.verificationThatMessagesWereNotDeleted(), DataHelp.CONFIRMATION_CANCEL_DELETE);
    }

//    @Test
//    public void testTypeLoginAndPassword(){
//        gmailLoginPage = new GmailLoginPage(driver);
//        gmailPage = gmailLoginPage.typeLoginAndPassword(GmailLoginPage.LOGIN, GmailLoginPage.PASSWORD);
//        Assert.assertTrue(gmailPage.verificationThatPageIsOpened().contains(GmailLoginPage.LOGIN));
//    }

//    @Test(dependsOnMethods = "testTypeLoginAndPassword")
//    public void testSelectTreeMessages(){
//        gmailPage.selectTreeMessages();
//        Assert.assertEquals(gmailPage.getCountOfSelectedMessages(), GmailPage.SELECTED_MESSAGES);
//    }

//    @Test(dependsOnMethods = "testSelectTreeMessages")
//    public void testDeleteSelectedMessages(){
//        gmailPage.deleteSelectedMessages();
//        Assert.assertEquals(gmailPage.getCountOfSelectedMessages(), GmailPage.SELECTED_MESSAGES_AFTER_DELETE);
//        WebElement element = driver.findElement(By.id("link_undo"));
//        Assert.assertEquals(element.getText(), GmailPage.CANCEL_DELETE_SPAN_TEXT);
//    }

//    @Test(dependsOnMethods = "testDeleteSelectedMessages")
//    public void testCancelDeleteMessages(){
//        gmailPage.cancelDeleteMessages();
//        Assert.assertEquals(gmailPage.verificationThatMessagesWereNotDeleted(), GmailPage.CONFIRMATION_CANCEL_DELETE);
//    }

    @AfterClass
    public void after(){
        driver.quit();
    }
}
