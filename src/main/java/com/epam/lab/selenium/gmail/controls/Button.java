package com.epam.lab.selenium.gmail.controls;

import org.openqa.selenium.WebElement;

public class Button extends Element {
	
	public Button(WebElement webElement) {
		super(webElement);
	}
	
	public void DisplayText() {
		System.out.println(webElement.toString() + " have text: " + webElement.getText());
	}
	
	public boolean isClickable() {
		return webElement.isEnabled();
	}

	public void click() {
		webElement.click();
	}
	
	public boolean isDisplayed() {
		return webElement.isDisplayed();
	}
}
