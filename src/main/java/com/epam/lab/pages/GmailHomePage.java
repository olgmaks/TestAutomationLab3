package com.epam.lab.pages;

import com.epam.lab.CustomFieldDecorator;
import com.epam.lab.DriverProvider;
import com.epam.lab.control.Button;
import com.epam.lab.control.Label;
import com.epam.lab.control.Textarea;
import com.epam.lab.models.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage  {

    private WebDriver driver;
    private Actions keyAction;

    @FindBy(xpath = "//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span/..")
    private Label profileIdentifier;

    @FindBy(xpath = "//div[@class='z0']/div[1]")
    private Button composeButton;

  /*  @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#drafts']")
    private Button draftsButton;
*/
    @FindBy(css = "tr[class ='zA yO']:first-child")
    private WebElement firstMessageNotPointedByCursor;

    @FindBy(css = "tr[class ='zA yO aqw']:first-child")
    private WebElement firstMessagePointedByCursor;

    @FindBy(css = "div.J-J5-Ji")
    private WebElement sendButton;


    public GmailHomePage(WebDriver driver) {
        this.driver = driver;
        keyAction = new Actions(driver);
        PageFactory.initElements(new CustomFieldDecorator(DriverProvider.getInstance()), this);
    }

    public Label getProfileIdentifier() {
        return profileIdentifier;
    }

    public void setProfileIdentifier(Label profileIdentifier) {
        this.profileIdentifier = profileIdentifier;
    }

    public MessageForm clickOnComposeButton() {
        composeButton.click();
        return new MessageForm();
    }

    public void setFieldTo(MessageForm messageForm , Message message){
            messageForm.toField.sendKeys(message.getTo());
    }
    public void setFieldCc(MessageForm messageForm , Message message){
        keyAction.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("c").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
        messageForm.ccField.sendKeys(message.getCc());
    }
    public void setFieldBcc(MessageForm messageForm, Message message ){
        keyAction.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("b").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
        messageForm.bccField.sendKeys(message.getBcc());
    }

    public void setFieldSubject(MessageForm messageForm, Message message){
        messageForm.subjectField.sendKeys(message.getSubject());
    }
    public void setMessageText(MessageForm messageForm , Message message){
        messageForm.messageBodyField.sendKeys(message.getMessage());
        (new WebDriverWait(driver, 10)).until((dr) -> messageForm.messageBodyField.getText().equals(message.getMessage()));
    }
    public void clickSaveAndCloseButton(MessageForm messageForm) {
        messageForm.saveAndCloseButton.click();
    }

    public void clickOnDraftsButton() {
        driver.navigate().to("https://mail.google.com/mail/u/0/#drafts");
    }

    public MessageForm clickOnLastDraft() {
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
        keyAction.keyDown(Keys.LEFT_CONTROL).sendKeys("\n").build().perform();
    }

    private String formatEmailToUnknownUsersMail(String email) {
        if (email.contains("<")) {
            email = email.substring(email.indexOf("<") + 1, email.indexOf(">"));
        }
        return email;
    }

    public class MessageForm {

        @FindBy(css = "div.aYF")
        private WebElement messageFormHeader;

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
            PageFactory.initElements(new CustomFieldDecorator(GmailHomePage.this.driver),
                    this);
        }

    }


}
