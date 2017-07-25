package com.epam.lab.selenium.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.selenium.gmail.controls.Button;
import com.epam.lab.selenium.gmail.controls.CustomFieldDecorator;
import com.epam.lab.selenium.gmail.controls.Label;
import com.epam.lab.selenium.gmail.controls.TextInput;

public class HomePage {
	
	@FindBy(css = "span.gbii")
	private WebElement accountMarker;
	
	@FindBy(xpath = "//div[@class='gb_Ec gb_hb gb_jg gb_R']")
	private Button accountIconButton;
	
	@FindBy(xpath = "//div[@class='Kj-JD-Jh']")
	private Button alternativeAccountIconButton;
	
	@FindBy(xpath = "//a[@class='gb_Fa gb_vf gb_Cf gb_le gb_xb']")
	private Button logoutButton;
	
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private Button writeButton;
	
	@FindBy(css = "textarea[name = 'to']")
	private TextInput receiverInput;

	@FindBy(css = "input[name = 'subjectbox']")
	private TextInput subjectInput;
	
	@FindBy(css = "div.LW-avf")
	private TextInput messageInput;
	
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
	private Button sendButton;
	
	@FindBy(xpath = "//a[@title='Отправленные']")
	private Label sendedMessagesLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(new CustomFieldDecorator(driver), this);
	}
	
	public void clickWriteButton() {
		writeButton.click();
	}

	public void sendKeysSendToReceiverInput(String value) {
		 receiverInput.sendKeys(value);
	}

	public void sendKeysToSubjectInput(String value) {
		subjectInput.sendKeys(value);
	}

	public void sendKeysToMessageInput(String value) {
		messageInput.sendKeys(value);
	}

	public void clickSendButton() {
		sendButton.click();
	}
	
	public boolean isMyAccountVisible() {
		return accountMarker!=null;
	}

	public void goToSentFolder() {
		sendedMessagesLink.click();
	}
	
	public void clickOnAccountIcon() {
		if(accountIconButton.isClickable())
			accountIconButton.click();
		else alternativeAccountIconButton.click();
	}

	public void clickOnLogoutButton() {
		logoutButton.click();
	}
}
