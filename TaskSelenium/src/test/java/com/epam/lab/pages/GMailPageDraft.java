package com.epam.lab.pages;

import com.epam.lab.pages.GMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GMailPageDraft extends GMailPage {
    @FindBy(css="tr[class ='zA yO']:first-child")
    private WebElement lastDraftLetter;

    public GMailPageDraft(WebDriver driver) {
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
