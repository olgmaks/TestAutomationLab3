import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GmailHomePage;
import pages.GmailLoginPage;
import pages.SentMailPage;

import javax.security.auth.Subject;
import java.util.concurrent.TimeUnit;


public class PageObjectTest {

    private WebDriver driver;
    public static final String WRONG_MAIL = "vovav3d3aed";
    public static final String EMAIL = "vova3d3@ukr.net";
    public static final String LOGIN = "";
    public static final String PASS = "";
    public static final String SUBJECT = "sub4";
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            }
        };
        driver.get("https://www.gmail.com");

    }
    @AfterTest
    public void tearDown() {
       driver.quit();


    }
    @Test(priority = 1)
    public void login() {
        GmailLoginPage loginPage = new GmailLoginPage(driver);
        GmailHomePage gmailHomePage =  loginPage.loginAndSubmit(LOGIN,PASS);

        Assert.assertTrue(gmailHomePage.isLogined());

    }
    @Test(priority = 2)
    public void compose(){

        GmailHomePage gmailHomePage = new GmailHomePage(driver);

        gmailHomePage.compose();
        gmailHomePage.writeMail(WRONG_MAIL,SUBJECT);
        gmailHomePage.verifyError();
        gmailHomePage.writeMail(EMAIL, SUBJECT);

    }
    @Test(priority = 3)
    public void checkSent(){

        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        SentMailPage sentMailPage =  gmailHomePage.getSentMail();
        Assert.assertTrue(sentMailPage.checkSent(EMAIL, SUBJECT));

    }



}
