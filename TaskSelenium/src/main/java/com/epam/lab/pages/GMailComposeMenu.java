package com.epam.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    public void clickAria(){
        ariaUsersAddres.click();
    }

    public WebElement getAddCc() {
        return addCc;
    }

    public WebElement getAddBcc() {
        return addBcc;
    }

    public WebElement getAriaTo() {
        return ariaTo;
    }

    public WebElement getAriaCc() {
        return ariaCc;
    }

    public WebElement getAriaBcc() {
        return ariaBcc;
    }

    public WebElement getAriaSubject() {
        return ariaSubject;
    }

    public WebElement getAriaMessage() {
        return ariaMessage;
    }

    public WebElement getButtonSaveAndClose() {
        return buttonSaveAndClose;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getUserTo() {
        return userTo;
    }

    public WebElement getUserCc() {
        return userCc;
    }

    public WebElement getUserBcc() {
        return userBcc;
    }
}
