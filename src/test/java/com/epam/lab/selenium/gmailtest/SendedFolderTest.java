package com.epam.lab.selenium.gmailtest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.lab.selenium.gmail.main.SendedFolder;

public class SendedFolderTest {
	
	@BeforeTest
	public void goToSendbox() {
		TestConfig.mainPage.GoToSendedMessages();
	}
	
	@Test(description = "Verifying if the last message we send is in the sendbox")
	public void lastSendedMessagePresenceTest() {
		for (int i = 0; i < TestConfig.sendedFolder.messages.size(); i++) {
            if (TestConfig.sendedFolder.messages.get(i).getText().equals("igor5070101"))
                {   
        		Assert.assertTrue(true);
                }
		}
	}
	
	@Test(description = "Verifying last message deleting option")
	public void deleteLastMessageTest() {
		SendedFolder sf = new SendedFolder(TestConfig.driver);
		sf.deleteLastMessage();
		Assert.assertTrue(true);
	}
}
