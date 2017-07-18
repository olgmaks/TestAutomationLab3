package com.epam.lab;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "identifier")
	private WebElement loginInput;

	@FindBy(name = "password")
	private WebElement passwordInput;

	public void typeLoginAndSubmit(String login) {
		loginInput.sendKeys(login+Keys.RETURN);		
	}

	public HomePage typePasswordAndSubmit(String pass) {
		passwordInput.sendKeys(pass + Keys.RETURN);		
		return new HomePage(driver);
	}

}
