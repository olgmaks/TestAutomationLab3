package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage {

    @FindBy(xpath = "//body[@class='aAU']")
    private WebElement homePage;

    @FindBy(xpath="//div[@class='T-I J-J5-Ji T-I-KE L3'] ")
    private WebElement compose;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement sendButton;

    @FindBy(xpath="//textarea[@name='to']")
    private WebElement mailTo;

    @FindBy(xpath="//input[@name='subjectbox']")
    private WebElement subject;

    @FindBy(xpath="//*[@class='Kj-JD']")
    private WebElement errorWindow;

    @FindBy(xpath="//button[@name='ok']")
    private WebElement errorOkButton;

    @FindBy(xpath="//div[@class='aoD hl']")
    private WebElement textArea;

    @FindBy(xpath="//div[@class='vM']")
    private WebElement deleteMail;

    @FindBy(xpath="//div[@class='TO'][.//span[@class='nU']]")
    private WebElement sentMailLink;

    @FindBy(xpath="//input[@id='gbqfq']")
    private WebElement searchInput;

    @FindBy(xpath="//button[@class='gbqfb']")
    private WebElement searchButton;
   private WebDriver driver;
    public GmailHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

   public boolean isLogined(){

       return  homePage.isDisplayed();
         }

    public void compose() {
        compose.click();
    }

    public void writeMail(String to,String subjecti){



        mailTo.sendKeys(to);

       subject.sendKeys(subjecti);
        sendButton.click();
    }
    public void verifyError() {
        errorOkButton.click();
        subject.clear();
        new Actions(driver).moveToElement(textArea).click().perform();
        textArea.click();
        new Actions(driver).moveToElement(deleteMail).click().perform();

    }

    public SentMailPage getSentMail(){


        searchInput.sendKeys("in:sent");
        searchButton.click();

        SentMailPage sentMailPage = new SentMailPage(driver);
        return sentMailPage;
    }

}
