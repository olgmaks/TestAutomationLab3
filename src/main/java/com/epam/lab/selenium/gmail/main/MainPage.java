package com.epam.lab.selenium.gmail.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	public MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span.gbii")
	private WebElement accountVisibility;
	
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement writeButton;
	
	@FindBy(css = "textarea[name = 'to']")
	private WebElement sendToInput;
	
	@FindBy(css = "input[name = 'subjectbox']")
	private WebElement subjectInput;
	
	@FindBy(css = "div.LW-avf")
	private WebElement messageInput;
	
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
	private WebElement sendButton;
	
	@FindBy(xpath = "//a[@title='Отправленные']")
	private WebElement sendedMessagesLink;
	
	public boolean isMyAccountVisible() {
		return accountVisibility!=null;
	}
	
	public void writeMessage(String sendTo, String subject, String message) {
		writeButton.click();
		sendToInput.sendKeys(sendTo);
		subjectInput.sendKeys(subject);
		messageInput.sendKeys(message);
		sendButton.click();
	}
	
	public void GoToSendedMessages() {
		sendedMessagesLink.click();
	}
}
