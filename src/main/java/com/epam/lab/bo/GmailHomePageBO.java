package com.epam.lab.bo;


import com.epam.lab.DriverProvider;
import com.epam.lab.models.Message;
import com.epam.lab.pages.GmailHomePage;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePageBO {
    private static GmailHomePage homePage;

    public static void setHomePage (GmailHomePage page){
        homePage  = page;
    }
    public static void addNewDraftAndClose(Message message){
        GmailHomePage.MessageForm messageForm =  homePage.clickOnComposeButton();
        homePage.setFieldTo(messageForm, message);
        homePage.setFieldCc(messageForm, message);
        homePage.setFieldBcc(messageForm, message);
        homePage.setFieldSubject(messageForm, message);
        homePage.setMessageText(messageForm, message);
        homePage.clickSaveAndCloseButton(messageForm);
    }
    public static Message sendLastDraft(){
        homePage.clickOnDraftsButton();
        GmailHomePage.MessageForm lastDraft  = homePage.clickOnLastDraft();

        Message lastDraftedMessage = homePage.getMessageFromMessageForm(lastDraft);
        homePage.sendDraft();
        return lastDraftedMessage;
    }
}
