package com.epam.lab.selenium.gmail.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.selenium.gmail.controls.Button;
import com.epam.lab.selenium.gmail.controls.CustomFieldDecorator;

public class SentFolderPage {
	
	@FindBy(xpath = "//*[@class='yW']/span")
	public List<WebElement> messages;
	
	@FindBy(css = "button[name='ok']")
	private Button deleteDialogBoxOkButton;
	
	public SentFolderPage(WebDriver driver) {
		PageFactory.initElements(new CustomFieldDecorator(driver), this);
	}
	
	public void clickDeleteDialogBoxOkButton() {
		deleteDialogBoxOkButton.click();
	}
	
}
