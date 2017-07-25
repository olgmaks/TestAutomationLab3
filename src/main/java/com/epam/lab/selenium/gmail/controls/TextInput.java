package com.epam.lab.selenium.gmail.controls;

import org.openqa.selenium.WebElement;

public class TextInput extends Element{

	public TextInput(WebElement webElement) {
		super(webElement);
	}
	
	public void sendKeys(String str) {
		webElement.sendKeys(str);
	}
	
	public void convertToLowerCase() {
		String lowerCase = webElement.getAttribute("value").toLowerCase();
		webElement.clear();
		webElement.sendKeys(lowerCase);
	}
}
