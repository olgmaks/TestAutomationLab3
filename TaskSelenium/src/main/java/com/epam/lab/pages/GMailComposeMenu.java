package com.epam.lab.pages;

import com.epam.lab.model.GMailLetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GMailComposeMenu  {
    @FindBy(css=".gQ.pE")
    private WebElement addCc;
    @FindBy(css=".gQ.pB")
    private WebElement addBcc;
    @FindBy(name="to")
    private WebElement ariaTo;
    @FindBy(name="cc")
    private WebElement ariaCc;
    @FindBy(name="bcc")
    private WebElement ariaBcc;
    @FindBy(name="subjectbox")
    private WebElement ariaSubject;
    @FindBy(css=".Al.editable.LW-avf")
    private WebElement ariaMessage;
    @FindBy(css="img[data-tooltip='Save & Close']")
    private WebElement buttonSaveAndClose;
    @FindBy(css="div[aria-label='Send \u202A(Ctrl-Enter)\u202C']")
    private WebElement sendButton;
    @FindBy(css=".vN.bfK.a3q")
    private WebElement userTo;
    @FindBy(css=".vN.bfK.a3p")
    private WebElement userCc;
    @FindBy(css=".vN.bfK")
    private WebElement userBcc;
    @FindBy(css=".aoD.hl")
    private WebElement ariaUsersAddres;

    public GMailComposeMenu(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void composeLetter(String to,String cc, String bcc,String subject,
                              String message){
        addBcc.click();
        addCc.click();
        ariaTo.sendKeys(to);
        ariaCc.sendKeys(cc);
        ariaBcc.sendKeys(bcc);
        ariaSubject.sendKeys(subject);
        ariaMessage.sendKeys(message);
        buttonSaveAndClose.click();
    }

    public GMailLetter getDraftLetter(){
        GMailLetter letter = new GMailLetter();
        letter.setTo(userTo.getAttribute("email"));
        letter.setCc(userCc.getAttribute("email"));
        letter.setBcc(userBcc.getAttribute("email"));
        letter.setSubject(ariaSubject.getAttribute("value"));
        letter.setText(ariaMessage.getText());
        return letter;
    }
    public void clickAria(){
        ariaUsersAddres.click();
    }
    public void send(){
        sendButton.click();
    }
}
