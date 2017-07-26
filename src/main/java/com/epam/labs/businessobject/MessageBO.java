package com.epam.labs.businessobject;

import com.epam.labs.model.Message;
import com.epam.labs.pageobject.GmailHomePage;

public class MessageBO {

    private GmailHomePage gmailHomePage;

    private Message message;

    public MessageBO(Message message, GmailHomePage gmailHomePage) {
        this.message = message;
        this.gmailHomePage = gmailHomePage;
    }

    public Message getMessage() {
        return message;
    }

    public void sendEmail() {
        gmailHomePage.sendEmail(message.getTo(), message.getSubject(), message.getBody());
    }

    public void repeatSendingEmail() {
        gmailHomePage.sendEmail(message.getTo());
    }

    public void closeWarningDialogForWrongEmail() {
        gmailHomePage.closeWarningDialog();
    }

    public boolean isEmailSent() {
        return gmailHomePage.isEmailSent(message.getTo(), message.getSubject());
    }
}
