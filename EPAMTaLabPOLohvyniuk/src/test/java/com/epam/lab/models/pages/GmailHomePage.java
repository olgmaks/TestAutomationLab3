package com.epam.lab.models.pages;

import com.epam.lab.PageLoader;
import com.epam.lab.models.Message;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage extends DrivenWebPage {

    private Actions keyAction;

    @FindBy(xpath = "//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span/..")
    private WebElement profileIdentifier;

    @FindBy(xpath = "//div[@class='z0']/div[1]")
    private WebElement composeButton;

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#drafts']")
    private WebElement draftsButton;

    @FindBy(css = "tr[class ='zA yO']:first-child")
    private WebElement firstMessageNotPointedByCursor;

    @FindBy(css = "tr[class ='zA yO aqw']:first-child")
    private WebElement firstMessagePointedByCursor;


    public GmailHomePage(WebDriver driver) {
        this.driver = driver;
        keyAction = new Actions(driver);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getProfileIdentifier() {
        return profileIdentifier;
    }

    public void setProfileIdentifier(WebElement profileIdentifier) {
        this.profileIdentifier = profileIdentifier;
    }

    public MessageForm openNewMessageForm() {
        composeButton.click();
        return new MessageForm();
    }

    public void writeNewDraft(MessageForm messageForm, Message message) {
        messageForm.toField.sendKeys(message.getTo());
        keyAction.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("c").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
        messageForm.ccField.sendKeys(message.getCc());
        keyAction.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("b").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
        messageForm.bccField.sendKeys(message.getBcc());
        messageForm.subjectField.sendKeys(message.getSubject());
        messageForm.messageBodyField.sendKeys(message.getMessage());
        messageForm.saveAndCloseButton.click();
    }

    public void openDrafts() {
        draftsButton.click();
        PageLoader.waitForLoad(this);
    }

    public MessageForm openLastDraft() {
        keyAction.moveToElement(firstMessageNotPointedByCursor).build().perform();
        firstMessagePointedByCursor.click();
        return new MessageForm();
    }

    public Message getMessageFromMessageForm(MessageForm messageForm) {
        Message resultMsg = new Message();
        resultMsg.setTo(formatEmailToUnknownUsersMail(messageForm.toField.getAttribute("value")));
        resultMsg.setCc(formatEmailToUnknownUsersMail(messageForm.ccField.getAttribute("value")));
        resultMsg.setBcc(formatEmailToUnknownUsersMail(messageForm.bccField.getAttribute("value")));
        resultMsg.setSubject(messageForm.subjectField.getAttribute("value"));
        resultMsg.setMessage(messageForm.messageBodyField.getText());
        return resultMsg;
    }

    public void sendDraft() {
        keyAction.keyDown(Keys.CONTROL).sendKeys("\n").keyUp(Keys.CONTROL).build().perform();
    }

    private String formatEmailToUnknownUsersMail(String email) {
        if (email.contains("<")) {
            email = email.substring(email.indexOf("<") + 1, email.indexOf(">"));
        }
        return email;
    }

    public class MessageForm {

        @FindBy(name = "to")
        private WebElement toField;

        @FindBy(name = "cc")
        private WebElement ccField;

        @FindBy(name = "bcc")
        private WebElement bccField;

        @FindBy(name = "subjectbox")
        private WebElement subjectField;

        @FindBy(xpath = "//div[@role='textbox']")
        private WebElement messageBodyField;

        @FindBy(xpath = "//td[@class='Hm']/img[last()]")
        private WebElement saveAndCloseButton;

        public MessageForm() {
            PageFactory.initElements(GmailHomePage.this.driver, this);
        }

    }


}
