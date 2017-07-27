package com.epam.tests;

import com.epam.DataHelps;
import com.epam.ProjectProperty;
import com.epam.businessobject.GmailBO;
import com.epam.businessobject.GmailLoginBO;
import com.epam.models.MessageModel;
import com.epam.models.UserModel;
import com.epam.webdriverutils.WebDriverUtils;
import org.testng.*;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectThreeMessagesDeleteThemAndThanCancelDeleteTest {

    @DataProvider(parallel = true)
    public Object[][] loginingUsers() {
        ProjectProperty projectProperty = null;
        try {
            projectProperty = new ProjectProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[][]{
                {projectProperty.getUserOneLogin(), projectProperty.getUserOnePassword()},
                {projectProperty.getUserTwoLogin(), projectProperty.getUserTwoPassword()}
        };
    }

    @BeforeMethod
    public void before() {
        System.out.println("BeforeMethod");
    }

    @Test(dataProvider = "loginingUsers", threadPoolSize = 2)
    public void testDeleteSelectedMessagesAndThanCancelDelete(String login, String password){
        System.out.println("Test");
        GmailLoginBO loginBO = new GmailLoginBO();
        GmailBO gmailBO = new GmailBO();

        UserModel user = new UserModel(login, password);
        String userInformation = loginBO.login(user);
        Assert.assertTrue(userInformation.contains(user.getEmail()));

        MessageModel messageModelFirst = gmailBO.selectMessage("Василь", "rtw", "24 липня 2017 р. о 20:06");
        Assert.assertNotNull(messageModelFirst);
        MessageModel messageModelSecond = gmailBO.selectMessage("Василь Паславський", "three", "24 липня 2017 р. о 20:08");
        Assert.assertNotNull(messageModelSecond);
        MessageModel messageModelThird = gmailBO.selectMessage("Василь Паславський", "fack", "24 липня 2017 р. о 20:01");
        Assert.assertNotNull(messageModelThird);

        List<MessageModel> messageModelList = new ArrayList<>(Arrays.asList(messageModelFirst, messageModelSecond, messageModelThird));
        Assert.assertEquals(messageModelList.size(), DataHelps.SELECTED_MESSAGES);
        Assert.assertEquals(gmailBO.getCountOfSelectedMessages(), DataHelps.SELECTED_MESSAGES);

        gmailBO.deleteSelectedMessages();
        Assert.assertEquals(gmailBO.getCountOfSelectedMessages(), DataHelps.SELECTED_MESSAGES_AFTER_DELETE);

        Assert.assertEquals(gmailBO.getCancelDeleteLinkText(), DataHelps.CANCEL_DELETE_SPAN_TEXT);
        gmailBO.cancelDeleteMessages();

        Assert.assertEquals(gmailBO.verificationThatMessagesWereNotDeleted(), DataHelps.CONFIRMATION_CANCEL_DELETE);
    }

    @AfterMethod
    public void after(){
        System.out.println("AfterMethod");
        WebDriverUtils.close();
    }
}
