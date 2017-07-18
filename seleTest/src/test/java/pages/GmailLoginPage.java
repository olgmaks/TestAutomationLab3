package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {

    private  WebDriver driver;
    @FindBy(id = "identifierId")
    private WebElement loginInput;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passInput;

    @FindBy(id = "passwordNext")
    private WebElement passButton;

    public GmailLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public GmailHomePage loginAndSubmit(String login, String pass) {

        loginInput.sendKeys(login);
        nextButton.click();
        new WebDriverWait(driver,45).until(ExpectedConditions.visibilityOf(passInput));
        passInput.sendKeys(pass);
        passButton.click();
        return new GmailHomePage(driver);

    }


}
