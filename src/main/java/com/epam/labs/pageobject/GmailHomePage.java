package com.epam.labs.pageobject;

import com.epam.labs.control.Button;
import com.epam.labs.util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailHomePage {

    @FindBy(css = "div.aoD")
    private WebElement emailToDiv;

    @FindBy(css = "div.vM")
    private WebElement closeEmailToDiv;

    @FindBy(xpath = "//div[text() = 'COMPOSE']")
    private Button composeBtn;

    @FindBy(name = "to")
    private WebElement toBox;

    @FindBy(name = "subjectbox")
    private WebElement subjectBox;

    @FindBy(css = "div[aria-label='Message Body']")
    private WebElement bodyBox;

    @FindBy(xpath = "//div[text() = 'Send']")
    private Button sendBtn;

    @FindBy(css = "div[role='alertdialog']")
    private WebElement warningDialog;

    @FindBy(name = "ok")
    private Button okBtn;

    @FindBy(css = "a[title='Sent Mail']")
    private Button sentMailBtn;

    @FindBy(css = "span.yP")
    private WebElement emailSpan;

    @FindBy(css = "span.bog > b")
    private List<WebElement> subjSpans;

    public GmailHomePage() {
        WebDriverUtil.initElements(this);
    }

    public void sendEmail(String email, String subject, String body) {
        composeBtn.click();
        toBox.sendKeys(email);
        subjectBox.sendKeys(subject);
        bodyBox.sendKeys(body);
        sendBtn.click();
    }

    public void sendEmail(String email) {
        emailToDiv.click();
        closeEmailToDiv.click();
        toBox.sendKeys(email);
        sendBtn.click();
    }

    public void closeWarningDialog() {
        warningDialog.isDisplayed();
        okBtn.click();
    }

    public boolean isEmailSent(String email, String subject) {
        sentMailBtn.click();
        return emailSpan.getAttribute("email").equals(email) &&
                subjSpans.stream().anyMatch(s -> s.getText().equals(subject));
    }
}
