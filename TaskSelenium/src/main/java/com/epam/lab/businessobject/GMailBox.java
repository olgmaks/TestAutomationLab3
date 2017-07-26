package com.epam.lab.businessobject;

import com.epam.lab.model.GMailLetter;
import com.epam.lab.pages.GMailComposeMenu;
import com.epam.lab.pages.GMailDraftPage;
import org.openqa.selenium.WebDriver;

public class GMailBox {
    GMailComposeMenu menu;
    GMailDraftPage draftPage ;


    public GMailBox(){
        draftPage = new GMailDraftPage();
    }

    public void composeLetter(String to,String cc, String bcc,String subject,
                              String message){
        menu = new GMailComposeMenu();
        draftPage.checkCompose();
        menu.getAddBcc().click();
        menu.getAddCc().click();
        menu.getAriaTo().sendKeys(to);
        menu.getAriaCc().sendKeys(cc);
        menu.getAriaBcc().sendKeys(bcc);
        menu.getAriaSubject().sendKeys(subject);
        menu.getAriaMessage().sendKeys(message);
        menu.getButtonSaveAndClose().click();
    }

    public GMailLetter getDraftLetter(){
        menu = new GMailComposeMenu();
        draftPage.openDraft();
        draftPage.openLastDraftLetter();
        GMailLetter letter = new GMailLetter();
        menu.clickAria();
        letter.setTo(menu.getUserTo().getAttribute("email"));
        letter.setCc(menu.getUserCc().getAttribute("email"));
        letter.setBcc(menu.getUserBcc().getAttribute("email"));
        letter.setSubject(menu.getAriaSubject().getAttribute("value"));
        letter.setText(menu.getAriaMessage().getText());
        return letter;
    }
    public void send(){

        menu.getSendButton().click();
    }
}
