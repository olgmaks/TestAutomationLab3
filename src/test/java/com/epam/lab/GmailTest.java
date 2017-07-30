package com.epam.lab;


import com.epam.lab.bo.GmailHomePageBO;
import com.epam.lab.bo.GmailLoginPageBO;
import com.epam.lab.models.Message;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class GmailTest {

   @Test(dataProvider = "getExcelData", dataProviderClass = UsersAndMessagesDataProvider.class)
   public void gmailTest(String login, String password, String to, String cc, String bcc, String subject, String message) throws InterruptedException {
       Message expectedMsg = new Message(to, cc, bcc, subject, message);
       GmailHomePageBO homePageBO = new GmailHomePageBO(GmailLoginPageBO.login(login, password));
       homePageBO.addNewDraftAndClose(expectedMsg);
       Message rsMessage = homePageBO.sendLastDraft();
       assertEquals(rsMessage, expectedMsg);


   }

   @AfterMethod
   public void tearDown () throws InterruptedException{
       Thread.sleep(2000L);
       DriverProvider.getInstance().close();
   }
  }
