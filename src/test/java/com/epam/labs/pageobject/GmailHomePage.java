package com.epam.labs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailHomePage {

    @FindBy(css = "div.aoD")
    private WebElement emailToDiv;

    @FindBy(css = "div.vM")
    private WebElement closeEmailToDiv;

    @FindBy(xpath = "//div[text() = 'COMPOSE']")
    private WebElement composeBtn;

    @FindBy(name = "to")
    private WebElement toBox;

    @FindBy(name = "subjectbox")
    private WebElement subjectBox;

    @FindBy(css = "div[aria-label='Message Body']")
    private WebElement bodyBox;

    @FindBy(xpath = "//div[text() = 'Send']")
    private WebElement sendBtn;

    @FindBy(css = "div[role='alertdialog']")
    private WebElement warningDialog;

    @FindBy(name = "ok")
    private WebElement okBtn;

    @FindBy(css = "a[title='Sent Mail']")
    private WebElement sentMailBtn;

    @FindBy(css = "span.yP")
    private WebElement emailSpan;

    @FindBy(css = "span.bog > b")
    private List<WebElement> subjSpans;

    public GmailHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendEmail(String email, String subject, String body, boolean repeateSend) {
        if (repeateSend) {
            emailToDiv.click();
            closeEmailToDiv.click();
        } else {
            composeBtn.click();
        }
        toBox.sendKeys(email);
        if (!repeateSend) {
            subjectBox.sendKeys(subject);
            bodyBox.sendKeys(body);
        }
        sendBtn.click();
    }

    public void closeWarningDialog() {
        warningDialog.isDisplayed();
        okBtn.click();
    }

    public boolean checkSentMails(String email, String subject) {
        sentMailBtn.click();
        return emailSpan.getAttribute("email").equals(email) && subjSpans.stream().anyMatch(s -> s.getText().equals(subject));
    }
}
