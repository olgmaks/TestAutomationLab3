package com.epam.lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage {
    @FindBy(xpath="//div[@class=\"z0\"]/div")
    private WebElement buttonWriteLetter;

    @FindBy(xpath = "//textarea[@name=\"to\"]")
    private WebElement to;

    @FindBy(name = "subjectbox")
    private WebElement subject;

    @FindBy(xpath = "//td[@class=\"Ap\"]/div[2]/div")
    private WebElement messageField;

    @FindBy(xpath = "//td[@class=\"Hm\"]/img[@class=\"Ha\"]")
    private WebElement close;

    @FindBy(xpath = "//div[@class=\"LrBjie\"]/div/div[4]")
    private WebElement draft;

    @FindBy(xpath = "//div[@class=\"BltHke nH oy8Mbf\"]//tr[1]/td[@class=\"yX xY \"]")
    private WebElement lastLetter;

    @FindBy(xpath = "//td[@class=\"gU Up\"]/div[1]/div[2] ")
    private WebElement buttonSend;

    public GmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void writeMessage(String to, String subject, String message, WebDriver driver){

        buttonWriteLetter.click();
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div>h2.a3E")));
        this.to.sendKeys(to);
        this.subject.sendKeys(subject);
        messageField.sendKeys(message);
        close.click();
        //closeMessage();
    }

    public void openDraftAndLastLetter(){
        this.draft.click();
        this.lastLetter.click();
    }

    public String takeMessageFromField(){
        return messageField.getText();
    }

    public void sendMessageFromDraft(){
        this.buttonSend.click();
    }
}
