package com.epam.lab;


import com.epam.lab.bo.GmailHomePageBO;
import com.epam.lab.bo.GmailLoginPageBO;
import com.epam.lab.consts.Constants;
import com.epam.lab.models.Message;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;


public class GmailTest {



   @Test(dataProvider = "getData")
   public void gmailTest(String login, String password)throws InterruptedException{
       WebDriver driver = DriverProvider.getInstance();
       GmailHomePageBO.setHomePage(GmailLoginPageBO.login(login, password));
       Message expectedMsg = Constants.messages[new Random().nextInt(2)];
       GmailHomePageBO.addNewDraftAndClose(expectedMsg);
       Message message = GmailHomePageBO.sendLastDraft();
       assertEquals(message, expectedMsg);
       Thread.sleep(2000L);
       DriverProvider.getInstance().quit();
   }

    @DataProvider
    public Object [][] getData(){
       Object [][]result = new Object[Constants.users.length][2];

       for(int i = 0 ; i < Constants.users.length; i++){
           result[i][0] = Constants.users[i].getLogin();
           result[i][1] = Constants.users[i].getPassword();
       }
       return result;
    }
}
