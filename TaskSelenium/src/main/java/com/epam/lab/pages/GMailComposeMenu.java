package com.epam.lab.pages;

import com.epam.lab.controls.CustomFieldDecorator;
import com.epam.lab.controls.elements.Button;
import com.epam.lab.controls.elements.Label;
import com.epam.lab.controls.elements.TextInput;
import com.epam.lab.util.DriverConnectionUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GMailComposeMenu  {
    @FindBy(css=".gQ.pE")
    private Label addCc;
    @FindBy(css=".gQ.pB")
    private Label addBcc;
    @FindBy(name="to")
    private TextInput ariaTo;
    @FindBy(name="cc")
    private TextInput ariaCc;
    @FindBy(name="bcc")
    private TextInput ariaBcc;
    @FindBy(name="subjectbox")
    private TextInput ariaSubject;
    @FindBy(css=".Al.editable.LW-avf")
    private TextInput ariaMessage;
    @FindBy(css="img[data-tooltip='Save & Close']")
    private Button buttonSaveAndClose;
    @FindBy(css="div[aria-label='Send \u202A(Ctrl-Enter)\u202C']")
    private Button sendButton;
    @FindBy(css=".vN.bfK.a3q")
    private Label userTo;
    @FindBy(css=".vN.bfK.a3p")
    private Label userCc;
    @FindBy(css=".vN.bfK")
    private Label userBcc;
    @FindBy(css=".aoD.hl")
    private TextInput ariaUsersAddres;

    public GMailComposeMenu(){
        PageFactory.initElements(new CustomFieldDecorator(DriverConnectionUtil.getWebDriver()),
                this);
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
