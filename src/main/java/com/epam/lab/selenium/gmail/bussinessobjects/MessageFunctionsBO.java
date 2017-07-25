package com.epam.lab.selenium.gmail.bussinessobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.epam.lab.selenium.gmail.core.Driver;
import com.epam.lab.selenium.gmail.models.MessageModel;
import com.epam.lab.selenium.gmail.pages.HomePage;
import com.epam.lab.selenium.gmail.pages.SentFolderPage;

public class MessageFunctionsBO {
	
	public static void writeMessage(HomePage homePage, MessageModel message) {
		homePage.clickWriteButton();
		homePage.sendKeysSendToReceiverInput(message.getReceiver());
		homePage.sendKeysToSubjectInput(message.getSubject());
		homePage.sendKeysToMessageInput(message.getContent());
		homePage.clickSendButton();
	}
	
	public static boolean compareToLastMessageSent(HomePage homePage, SentFolderPage sentFolderPage, MessageModel message) throws InterruptedException {
		homePage.goToSentFolder();
		MessageModel lastMessage = new MessageModel();
		Thread.sleep(3000);
		for(int i = 0; i < sentFolderPage.messages.size(); i++)
			if(sentFolderPage.messages.get(i).getText().equals(message.getReceiverShortened()))
		lastMessage.setReceiverShortened(sentFolderPage.messages.get(i).getText());
		return lastMessage.getReceiverShortened().equals(message.getReceiverShortened());
	}
	
	public static void deleteMessage(SentFolderPage sentFolderPage, MessageModel message) {
		for (int i = 0; i < sentFolderPage.messages.size(); i++) {
			if (sentFolderPage.messages.get(i).getText().equals(message.getReceiverShortened()))
                {    
				Actions actions = new Actions(Driver.getInstance());
            	actions.contextClick(sentFolderPage.messages.get(i))
            	.sendKeys(Keys.ARROW_DOWN)
            	.sendKeys(Keys.ARROW_DOWN)
            	.sendKeys(Keys.ARROW_DOWN)
            	.sendKeys(Keys.RETURN)
            	.build().perform();
            	
            	sentFolderPage.clickDeleteDialogBoxOkButton();
            	break;
                }
		}
	}
}
