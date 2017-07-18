package com.epam.sel1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gmailpageobjects.HomePage;
import gmailpageobjects.LoginPage;
import junit.framework.Assert;

public class gmailTest {
	public String baseUrl = "https://accounts.google.com/AccountChooser/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AddSession";
	String driverPath = "resources/chromedriver.exe";
	public WebDriver driver;
	String login = "olegvovkanych@gmail.com";
	String password = "sittervovkanych";
	String incorrectEmail = "qweail.com";
	String subject = "I am a subject";
    String massage= "I am massage";
    String correctEmail= "anetswan@gmail.com";
    public WebDriverWait wait;
    
    @BeforeTest
	  public void first() {
	System.setProperty("webdriver.chrome.driver", driverPath);
   driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
    @Test(priority = 1)
    public void login() {
    	LoginPage loginPage = new LoginPage(driver);
    	driver.get(baseUrl);
    
    	loginPage.typeLoginAndSubmit("olegvovkanych@gmail.com");
//    	
    	loginPage.typePasswordAndSubmit(password);
    }
   @Test(priority = 2)
   public void sendEmailInrorrect() {
   HomePage home = new HomePage(driver);
        home.SendEmail(incorrectEmail, subject, massage);
        home.errorWindowOkButtonClick();
        }
   @Test(priority = 3)
   public void sendEmail() {
	   HomePage home = new HomePage(driver);
	   home.SendEmailAfterError(correctEmail);
        }
   
   @Test(priority = 4)
   public void verifyEmailIsSent() {
	   HomePage home = new HomePage(driver);
	   home.goToSentEmails();
	   String actual="";
	   String expected = "email was sent";
	     new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ae4.UI")));
	        List<WebElement> webElementList = driver.findElements(By.cssSelector("tr.zA.yO"));
	        for (WebElement el : webElementList)
	        {
	        	if (el.findElement(By.cssSelector("span.yP")).getAttribute("email").equals(correctEmail)
	                    && el.findElement(By.cssSelector("span.bog")).getText().equals(subject)) {
	                actual = "email was sent";
	               
	            }
	     
	        }
	        Assert.assertEquals(expected, actual);
        }
   
}
