package epam.com.lab.bissness;


import epam.com.lab.*;
import epam.com.lab.model.Letter;
import epam.com.lab.model.User;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BWriteDraftMessage {
    private GmailWriteDraftMessage draftMessage;
    private GmailSendDraftMessage sendDraftMessage;


    public void writeDraftMessage(Letter letter){
        this.draftMessage = new GmailWriteDraftMessage();
        draftMessage.writeNewMessage(letter.getTo(), letter.getSubject(), letter.getShortContent());
    }

    public void sendMessageFromDraftFolder()   {
        this.sendDraftMessage = new GmailSendDraftMessage();
        sendDraftMessage.sendDraftMessage();
    }
    public int countFromDraftFolder(){
        this.sendDraftMessage =new GmailSendDraftMessage();
        return sendDraftMessage.countDraftMessage();
    }

    public String textFromDraftMessage() {
        this.sendDraftMessage = new GmailSendDraftMessage();
        return sendDraftMessage.getTextDraftMessage();


    }
}
