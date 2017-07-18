package com.epam;

import com.epam.lab.GmailPage;
import com.epam.lab.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class GmailTest {

    WebDriver driver;
    private GmailPage gmailPage;


    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeClass
    public void driverInitialize(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        gmailPage=new GmailPage(driver);
    }

    @Test(priority =0)
    public void openGmail(){
        driver.get("http://www.gmail.com");
    }

    @Test(dependsOnMethods = "openGmail")
    public void loginToGmail(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.typeLoginAndSubmit("sofiia.mailfortesting@gmail.com");
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        loginPage.enterPasswordAndSubmit("hellow1987");
    }

    @Test(dependsOnMethods = "loginToGmail")
    public void writeMessageAndClose(){
        gmailPage.writeMessage("sofiya.sydorenko@gmail.com", "test", "test", driver);
    }

    @Test(dependsOnMethods = "writeMessageAndClose")
    public void verifyIfMessageIsSavedToDraft(){
        gmailPage.openDraftAndLastLetter();
        Assert.assertEquals(gmailPage.takeMessageFromField(), "test");
    }
    @Test(dependsOnMethods = "verifyIfMessageIsSavedToDraft")
    public void sendMessage(){
        gmailPage.sendMessageFromDraft();
    }

    @AfterClass
    public void driverQuit(){
        driver.quit();
    }
}
