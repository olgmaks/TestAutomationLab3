package epam.com.lab;

import epam.com.lab.decoratorGmail.Button;
import epam.com.lab.decoratorGmail.CustomFieldDecorator;
import epam.com.lab.decoratorGmail.Label;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class GmailSendDraftMessage {
    @FindBy(xpath = "//div[@class=\"LrBjie\"]/div/div[4]")
    private Button draftFolder;
    @FindBy(xpath = "//div[@class=\"BltHke nH oy8Mbf\"]//tr[1]/td[@class=\"yX xY \"]")
    private Button messageFromDraftFolder;
    @FindBy(xpath = "//td[@class='gU Up']/div[1]/div[2]")
    private Button sendButton;
    @FindBy(css = ".Ar.Au div ")
    private Label writeText;
    @FindBy(xpath = "//div[@class=\"LrBjie\"]/div/div[4]//span[@class='nU n1']")
    private Label draftCountFolder;

    public GmailSendDraftMessage(){

        PageFactory.initElements(new CustomFieldDecorator(ThreadDriverInstance.getDriver()), this);
    }

    public String getTextDraftMessage() {
        draftFolder.click();
        messageFromDraftFolder.click();
        return writeText.getText();
    }

    public void sendDraftMessage() {
        sendButton.click();
    }


    public int countDraftMessage(){
        int sum=0;
        String str  = draftCountFolder.getText();
        sum =Integer.parseInt(str.substring(str.indexOf('(')+1, str.indexOf(')')));
        return sum;
    }
}
