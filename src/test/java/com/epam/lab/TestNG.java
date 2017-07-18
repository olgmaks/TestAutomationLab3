package com.epam.lab;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNG {

	final static String EMAIL = "olikxom@gmail.com";
	final static String PASS = "1qaz2wsx3edC";
	final static String SEND_TO = "inkognito007@i.ua";
	final static String SUBJECT = "Hello1";
	final static String TEXT = "Greetings from Selenium WebDriver";

	public WebDriver driver;

	@Test
	public void main() {
		WebElement element = driver.findElement(By.name("identifier"));
		element.sendKeys(EMAIL + Keys.RETURN);
		element = driver.findElement(By.name("password"));
		element.sendKeys(PASS + Keys.RETURN);
		
		// send message
		element = driver.findElement(By.xpath("//div[@gh='cm']"));
		element.click();
		element = driver.findElement(By.xpath("//textarea[@name='to']"));
		element.sendKeys(SEND_TO + Keys.RETURN);
		element = driver.findElement(By.name("subjectbox"));
		element.sendKeys(SUBJECT);
		element = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']"));
		element.sendKeys(TEXT);
		element = driver.findElement(By.cssSelector("div[aria-label*='(Ctrl –Enter)'][role='button']"));
		element.click();

		// in:sent
		element = driver.findElement(By.id("gbqfq"));
		element.sendKeys("in:sent" + Keys.RETURN);		

		// collect all messages, which send to email SEND_TO
		List<WebElement> a = driver.findElements(By.xpath("//table/tbody/tr[@class='zA yO']/td[@class='yX xY ']/div/span[@email='" + SEND_TO + "']"));
		
		// open and check each message for SUBJECT equals
		// open
		for (WebElement webElement : a) {
			if (webElement.isDisplayed() && webElement.isEnabled()) {
				webElement.click();				
				// check
				try {
					driver.findElement(By
							.xpath("//table[@role='presentation']/tr/td/div/div/div/div/h2[text()='" + SUBJECT + "']"));
					element = driver.findElement(By.xpath("//div[@act='10']"));
					List<WebElement> b = driver.findElements(By.xpath("//div[@act='10']"));
					for (WebElement webElement2 : b) {
						// click on available delete button
						if (webElement2.isDisplayed()) {
							webElement2.click();
						}
					}
					//Thread.sleep(3000);
				} catch (NoSuchElementException e) {
					// Back to in:sent if current message not equals SUBJECT
					driver.findElement(By.cssSelector("div[act='19'][role='button']")).click();				
				}

			}

		}
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://mail.google.com/mail/");
	}

	@AfterMethod
	public void afterMethod() {	
		driver.close();
	}

}
