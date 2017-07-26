package com.epam.lab.pages;

import com.epam.lab.controls.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class GMailDraftPage extends GMailPage {
    @FindBy(css="tr[class ='zA yO']:first-child")
    private TextInput lastDraftLetter;

    public void openDraft(){
        this.getAriaSearch().sendKeys("in:draft");
        this.getSearchButton().click();
    }

    public void openLastDraftLetter(){
        lastDraftLetter.click();
    }
}
