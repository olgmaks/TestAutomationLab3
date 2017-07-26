package SeleniumTest.pages;

import SeleniumTest.CustomFieldDecorator;
import SeleniumTest.DriverManager;
import SeleniumTest.elements.Button;
import SeleniumTest.elements.Input;
import SeleniumTest.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
    @FindBy(id="identifierId")
    private Input loginInput;

    @FindBy (id="identifierNext")
    private Button nextButton;
    @FindBy (xpath = "//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]")
    private Label message;

    public GmailLoginPage(){
        PageFactory.initElements(new CustomFieldDecorator(DriverManager.getInstance()),this);
    }

    public void enterLogin(String login){
        loginInput.sendKeys(login);
    }
    public void submit(){
        nextButton.click();
    }
    public boolean hasntErrorMassage(){
        boolean hasntError =true;
        try {
            message.findElement(By.xpath(".//div"));
            hasntError = false;
        }finally {
            return hasntError;
        }
       }
}