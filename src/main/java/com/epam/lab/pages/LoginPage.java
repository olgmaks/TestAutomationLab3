package com.epam.lab.pages;


import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.controls.CustomFieldDecorator;
import com.epam.lab.controls.InputArea;
import com.epam.lab.util.Driver;

public class LoginPage {

	
	@SuppressWarnings("unused")
	private LoginPage(){}
	
	public LoginPage(String driverName) throws IOException {
		PageFactory.initElements(new CustomFieldDecorator(getDriver(driverName)), this);
	}
	
	private WebDriver getDriver(String driverName) throws IOException{
		return Driver.getDriver(driverName);
	}

	@FindBy(name = "identifier")
	private InputArea loginInput;

	@FindBy(name = "password")
	private InputArea passwordInput;

	public void typeLoginAndSubmit(String login) {
		loginInput.sendKeys(login+Keys.RETURN);		
	}

	public void typePasswordAndSubmit(String pass) {
		passwordInput.sendKeys(pass + Keys.RETURN);		
	}

}
