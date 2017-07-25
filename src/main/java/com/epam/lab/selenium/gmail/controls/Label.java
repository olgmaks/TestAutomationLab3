package com.epam.lab.selenium.gmail.controls;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.epam.lab.selenium.gmail.core.Driver;

public class Label extends Element {
	
	public Label(WebElement webElement) {
		super(webElement);
	}
	
	public int getSizeIfVisible() {
		if(webElement.isDisplayed())
			return webElement.getSize().height * webElement.getSize().width;
		else System.out.println("Label is not visible"); return 0;
	}

	public int getValueLength() {
		return webElement.getAttribute("value").length();
	}
	
	public void click() {
		webElement.click();
	}

	public String getText() {
		return webElement.getText();
	}
	
	public Actions contextClick() {
		Actions actions = new Actions(Driver.getInstance());
    	return actions.contextClick(webElement);
	}
}
