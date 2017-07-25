package com.epam.lab.selenium.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.selenium.gmail.controls.Button;
import com.epam.lab.selenium.gmail.controls.CustomFieldDecorator;
import com.epam.lab.selenium.gmail.controls.Label;
import com.epam.lab.selenium.gmail.controls.TextInput;
import com.epam.lab.selenium.gmail.core.Driver;

public class LoginPage {
	
	@FindBy(id = "identifierId")
	private TextInput loginInput;

	@FindBy(xpath = "//*[text()='Forgot email?']")
	private Label forgotEmailLink;

	@FindBy(xpath = "//*[text()='More Options']")
	private Label moreOptionsLink;
	
	@FindBy(id = "identifierNext")
	private Button loginNextButton;
	
	@FindBy(css = "input[name='password']")
	private TextInput passwordInput;
	
	@FindBy(css = "div.IMH1vc")
	private Label forgotPasswordLink;
	
	@FindBy(id = "passwordNext")
	private Button passwordNextButton;
	
	@FindBy(xpath = "//div[@class = 'ANuIbb IdAqtf']")
	private Button passwordNextButtonAlternative;
	
	@FindBy(xpath = "//path[@d = 'M7.41 7.84L12 12.42l4.59-4.58L18 9.25l-6 6-6-6z']")
	private Button chooseAccountButton;
	
	@FindBy(xpath = "//div[@class = 'TnvOCe k6Zj8d XraQ3b bLzI3e']")
	private Button changeAccountOption;
	
	@FindBy(xpath = "//div[@class = 'IMH1vc lUHSR Hj2jlf']")
	private Button forgotPasswordLinkAddit;
	
	@FindBy(xpath = "//a[@class = 'vHOx3b']")
	private Button useAnotherAccountLink;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(new CustomFieldDecorator(driver), this);
	}

	public void enterLogin(String login) {
		loginInput.sendKeys(login);
		loginNextButton.click();
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
		if(passwordNextButton.isClickable()) {
			passwordNextButton.click();
		} else passwordNextButtonAlternative.click();
	}
	
	public void clickForgotPasswordLink() {
		if(forgotPasswordLinkAddit.isClickable())
			System.out.println("forgotPasswordLinkAddit is clickable! before click.");
		forgotPasswordLinkAddit.click();
	}
	
	public void clickUseAnotherAccount() {
		useAnotherAccountLink.click();
	}
	
	public void clickChangeAccountOption() {
		changeAccountOption.click();
	}
	
	public boolean isChangeAccountOptionDisplayed() {
		boolean isPresent = Driver.getInstance().findElements(By.xpath("//div[@class = 'TnvOCe k6Zj8d XraQ3b bLzI3e']")).size() > 0;
		return isPresent;
	}
}
