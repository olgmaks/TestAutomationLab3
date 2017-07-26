package com.epam.labs;

import com.epam.labs.businessobject.LoginBO;
import com.epam.labs.businessobject.MessageBO;
import com.epam.labs.model.Message;
import com.epam.labs.model.User;
import com.epam.labs.util.GmailPropertyUtil;
import com.epam.labs.util.WebDriverUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GmailTest {

    private final static Logger logger = LogManager.getLogger(GmailTest.class);
    private GmailPropertyUtil gmailProperties;
    private final static String CHROME_DRIVER = "webdriver.chrome.driver";
    private final static String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
    private final static String USERS_DATA_PATH = "src/main/resources/users.json";

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

    @DataProvider(parallel = true)
    public static Object[][] provideUsers() {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(USERS_DATA_PATH));
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray usersData = (JSONArray) jsonObject.get("users");
        ArrayList<User> users = (ArrayList<User>) usersData.stream()
                .map(u -> new User(((JSONObject) u).get("email").toString(), ((JSONObject) u).get("pass").toString()))
                .collect(Collectors.toList());
        Object[][] usersTwoDimList = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++) {
            usersTwoDimList[i][0] = users.get(i);
        }
        return usersTwoDimList;
    }

    @Test(threadPoolSize = 5, dataProvider = "provideUsers")
    public void testSend(User user) {
        LoginBO loginBO = new LoginBO(user);
        Message message = new Message(gmailProperties.getEmail(), gmailProperties.getSubject(), gmailProperties.getBody());
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