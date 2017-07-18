package com.epam.lab;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private final String SEND_TO = "inkognito007@i.ua";
	private String subject;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@gh='cm']")
	private WebElement createButton;

	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement emailTo;

	@FindBy(name = "subjectbox")
	private WebElement subjectName;

	@FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
	private WebElement text;

	@FindBy(css = "div[aria-label*='(Ctrl –Enter)'][role='button']")
	private WebElement sendButton;

	@FindBy(id = "gbqfq")
	private WebElement toSentList;

	@FindBy(xpath = "//table/tbody/tr[@class='zA yO']/td[@class='yX xY ']/div/span[@email='" + SEND_TO + "']")
	private List<WebElement> filterByEmail;
	
	@FindBy(xpath = "//table[@role='presentation']/tr/td/div/div/div/div/h2[text()]")
	private WebElement checkForSubject;
	
	@FindBy(xpath = "//div[@act='10']")
	private List<WebElement> deleteButton;
	
	@FindBy(css = "div[act='19'][role='button']")
	private WebElement undoButton;

	public void sendEmail(String sendTo, String subject, String text) {
		this.subject = subject;
		createButton.click();
		emailTo.sendKeys(sendTo);
		this.subjectName.sendKeys(subject);
		this.text.sendKeys(text);
		sendButton.click();
	}

	public void checkSentAndDelete(String email, String subject) {
		this.subject = subject;
		toSentList.sendKeys("in:sent" + Keys.RETURN);
		// open and check each message for SUBJECT equals
		// open
		for (WebElement webElement : filterByEmail) {
			if (webElement.isDisplayed() && webElement.isEnabled()) {
				webElement.click();				
				// check
				try {
					if (!checkForSubject.getText().equals(subject)) {
						throw new NoSuchElementException(subject);
					}
					for (WebElement webElement2 : deleteButton) {
						// click on available delete button
						if (webElement2.isDisplayed()) {
							webElement2.click();
						}
					}							
				} catch (NoSuchElementException e) {
					// Back to in:sent if current message not equals SUBJECT
					undoButton.click();				
				}

			}

		}
	}

}
