package com.epam.lab;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNGPageObject {

	final static String EMAIL = "olikxom@gmail.com";
	final static String PASS = "1qaz2wsx3edC";
	final static String SEND_TO = "inkognito007@i.ua";
	final static String SUBJECT = "Hello1";
	final static String TEXT = "Greetings from Selenium WebDriver";

	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver() {
			{
				manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		};
		driver.get("https://mail.google.com/mail/");
	}

	@Test
	public void testSend() {
		LoginPage gmailLoginPage = new LoginPage(driver);
		gmailLoginPage.typeLoginAndSubmit(EMAIL);
		HomePage gmailHomePage = gmailLoginPage.typePasswordAndSubmit(PASS);
		gmailHomePage.sendEmail(SEND_TO, SUBJECT, TEXT);
		gmailHomePage.checkSentAndDelete(SEND_TO, SUBJECT);		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
