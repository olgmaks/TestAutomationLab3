package epam.com.lab;


import epam.com.lab.decoratorGmail.Button;
import epam.com.lab.decoratorGmail.CustomFieldDecorator;
import epam.com.lab.decoratorGmail.TextInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GmailWriteDraftMessage {

    @FindBy(xpath = "//div[@class=\"z0\"]/div")
    private Button writeNewMessage;
    @FindBy(css = ".oj div textarea")
    private TextInput writeTo;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private TextInput writeTheme;
    @FindBy(css = ".Ar.Au div ")
    private TextInput writeText;
    @FindBy(xpath = "//td[@class='Hm']/img[@class='Ha']")
    private Button buttonClose;


    public GmailWriteDraftMessage() {
        PageFactory.initElements(new CustomFieldDecorator(ThreadDriverInstance.getDriver()), this);
    }


    public void writeNewMessage(String emailTo, String subject, String content) {
        writeNewMessage.click();
        writeTo.sendKeys(emailTo);
        writeTheme.sendKeys(subject);
        writeText.sendKeys(content);
        buttonClose.click();
    }


}
