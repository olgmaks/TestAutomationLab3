package com.epam.lab.selenium.gmail.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "identifierId")
	private WebElement loginInput;
	
	@FindBy(xpath = "//*[text()='Forgot email?']")
	private WebElement forgotEmailLink;

	@FindBy(xpath = "//*[text()='More Options']")
	private WebElement moreOptionsLink;
	
	@FindBy(id = "identifierNext")
	private WebElement loginNextButton;
	
	@FindBy(css = "input[name='password']")
	private WebElement passwordInput;
	
	@FindBy(css = "div.IMH1vc")
	private WebElement forgotPasswordLink;
	
	@FindBy(id = "passwordNext")
	private WebElement passwordNextButton;
	
	public void logInGmail(String login, String password) {
		loginInput.sendKeys(login);
		loginNextButton.click();
		
		passwordInput.sendKeys(password);
		passwordNextButton.click();
	}
}
