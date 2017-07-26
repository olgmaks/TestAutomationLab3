package com.epam.lab;


import com.epam.lab.bo.GmailHomePageBO;
import com.epam.lab.bo.GmailLoginPageBO;
import com.epam.lab.consts.Constants;
import com.epam.lab.models.Message;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class GmailTest {



   @Test(dataProvider = "getData")
   public void gmailTest(String login, String password, String to, String cc, String bcc, String subject, String message) throws InterruptedException {
       Message expectedMsg = new Message(to, cc, bcc, subject, message);
       GmailHomePageBO.setHomePage(GmailLoginPageBO.login(login, password));
       GmailHomePageBO.addNewDraftAndClose(expectedMsg);
       Message rsMessage = GmailHomePageBO.sendLastDraft();
       assertEquals(rsMessage, expectedMsg);
       Thread.sleep(2000L);
       DriverProvider.getInstance().close();
       DriverProvider.clear();

   }

/*   @AfterClass
   public void tearDown () throws InterruptedException{
       Thread.sleep(2000L);
       DriverProvider.getInstance().close();
   }*/

    @DataProvider(parallel = true)
    public Object [][] getData(){
        Object[][] result = new Object[Constants.users.size()][7];

        for (int i = 0; i < Constants.users.size(); i++) {
            result[i][0] = Constants.users.get(i).getLogin();
            result[i][1] = Constants.users.get(i).getPassword();
            result[i][2] = Constants.messages.get(i).getTo();
            result[i][3] = Constants.messages.get(i).getCc();
            result[i][4] = Constants.messages.get(i).getBcc();
            result[i][5] = Constants.messages.get(i).getSubject();
            result[i][6] = Constants.messages.get(i).getMessage();

        }
        return result;

    }
}
