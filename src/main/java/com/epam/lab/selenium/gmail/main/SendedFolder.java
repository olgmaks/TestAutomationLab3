package com.epam.lab.selenium.gmail.main;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.selenium.gmailtest.TestConfig;

public class SendedFolder {
	
	public SendedFolder(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='yW']/span")
	public List<WebElement> messages;
	
	@FindBy(css = "button[name='ok']")
	private WebElement deleteDialogBoxOkButton;

	public void locateToSendedFolder(MainPage mp){
		mp.GoToSendedMessages();
	}
	
	public void deleteLastMessage() {
		for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getText().equals("igor5070101"))
                {    
            	Actions actions = new Actions(TestConfig.driver);
            	actions.contextClick(messages.get(i))
            	.sendKeys(Keys.ARROW_DOWN)
            	.sendKeys(Keys.ARROW_DOWN)
            	.sendKeys(Keys.ARROW_DOWN)
            	.sendKeys(Keys.RETURN)
            	.build().perform();
            	
            	deleteDialogBoxOkButton.click();
            	break;
                }
		}
	}
}
