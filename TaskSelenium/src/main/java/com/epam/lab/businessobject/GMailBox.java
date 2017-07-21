package com.epam.lab.businessobject;

import com.epam.lab.model.GMailLetter;
import com.epam.lab.pages.GMailComposeMenu;
import com.epam.lab.pages.GMailDraftPage;
import org.openqa.selenium.WebDriver;

public class GMailBox {

    GMailDraftPage draftPage ;
    GMailComposeMenu menu;

    public GMailBox(WebDriver driver){
        draftPage = new GMailDraftPage(driver);
        menu = new GMailComposeMenu(driver);
    }

    public void composeLetter(String to,String cc, String bcc,String subject,
                              String message){
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
