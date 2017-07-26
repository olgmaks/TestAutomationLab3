package com.epam.lab.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.controls.Button;
import com.epam.lab.controls.CustomFieldDecorator;
import com.epam.lab.controls.InputArea;
import com.epam.lab.controls.Label;
import com.epam.lab.util.Driver;

public class HomePage {
	
	
	@SuppressWarnings("unused")
	private HomePage() {}
		
	public HomePage(String driverName) throws IOException {
		PageFactory.initElements(new CustomFieldDecorator(getDriver(driverName)), this);
	}
	
	private WebDriver getDriver(String driverName) throws IOException{
		return Driver.getDriver(driverName);
	}

	@FindBy(xpath = "//div[@gh='cm']")
	private Button createButton;

	@FindBy(xpath = "//textarea[@name='to']")
	private InputArea emailTo;

	@FindBy(name = "subjectbox")
	private InputArea subjectName;

	@FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
	private InputArea text;

	@FindBy(css = "div[aria-label*='Enter'][role='button']")
	private Button sendButton;

	@FindBy(id = "gbqfq")
	private InputArea searchArea;

	@FindBy(xpath = "//table/tbody/tr[@class='zA yO']/td[@class='yX xY ']/div/span[@email]")
	private List<Label> filterByEmail;

	@FindBy(xpath = "//table[@role='presentation']/tr/td/div/div/div/div/h2[text()]")
	private Label checkForSubject;

	@FindBy(xpath = "//div[@act='10']")
	private List<Button> deleteButton;

	@FindBy(css = "div[act='19'][role='button']")
	private Button undoButton;

	public void sendEmail(String sendTo, String subject, String text) {
		createButton.click();
		emailTo.sendKeys(sendTo);
		this.subjectName.sendKeys(subject);
		this.text.sendKeys(text);
		sendButton.click();
	}

	public void checkSentAndDelete(String email, String subject) {
		searchArea.sendKeys("in:sent" + Keys.RETURN);
		// open and check each message for SUBJECT equals
		// open		
		for (WebElement webElement : filterByEmail) {
			if (webElement.isDisplayed() && webElement.isEnabled() && webElement.getAttribute("email").equals(email)) {
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
