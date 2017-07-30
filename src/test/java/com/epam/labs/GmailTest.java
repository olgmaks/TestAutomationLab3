package com.epam.labs;

import com.epam.labs.businessobject.LoginBO;
import com.epam.labs.businessobject.MessageBO;
import com.epam.labs.model.Message;
import com.epam.labs.model.User;
import com.epam.labs.provider.GmailTestData;
import com.epam.labs.util.GmailPropertyUtil;
import com.epam.labs.util.WebDriverUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GmailTest {

    private final static Logger logger = LogManager.getLogger(GmailTest.class);
    private GmailPropertyUtil gmailProperties;
    private final static String CHROME_DRIVER = "webdriver.chrome.driver";
    private final static String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";

    @BeforeMethod
    public void beforeMethod() {
        try {
            gmailProperties = new GmailPropertyUtil();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        WebDriverUtil.openURL(gmailProperties.getUrl());
    }

    @Test(dataProvider = "provideUsersAndMessages", dataProviderClass = GmailTestData.class, threadPoolSize = 5)
    public void testSend(User user, Message message) {
        LoginBO loginBO = new LoginBO(user);
        MessageBO messageBO = new MessageBO(message, loginBO.login());
        messageBO.sendEmail();
        messageBO.closeWarningDialogForWrongEmail();
        messageBO.getMessage().setTo(user.getEmail());
        messageBO.repeatSendingEmail();
        Assert.assertTrue(messageBO.isEmailSent());
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverUtil.close();
    }
}