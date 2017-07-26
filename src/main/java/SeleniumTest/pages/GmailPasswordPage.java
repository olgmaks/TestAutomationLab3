package SeleniumTest.pages;

import SeleniumTest.CustomFieldDecorator;
import SeleniumTest.DriverManager;
import SeleniumTest.elements.Button;
import SeleniumTest.elements.Input;
import SeleniumTest.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPasswordPage {
    @FindBy(name="password")
    private Input passwordInput;

    @FindBy (id="passwordNext")
    private Button nextButton;

    @FindBy (xpath = "//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]")
    private Label message;

    public GmailPasswordPage(){

        PageFactory.initElements(new CustomFieldDecorator(DriverManager.getInstance()),this);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
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
