package com.epam.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GMailDraftPage extends GMailPage {
    @FindBy(css="tr[class ='zA yO']:first-child")
    private WebElement lastDraftLetter;

    public GMailDraftPage(WebDriver driver) {
        super(driver);
    }

    public void openDraft(){
        this.getAriaSearch().sendKeys("in:draft");
        this.getSearchButton().click();
    }

    public void openLastDraftLetter(){
        lastDraftLetter.click();
    }
}
