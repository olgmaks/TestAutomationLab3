package com.epam.lab.pages;


import com.epam.lab.controls.CustomFieldDecorator;
import com.epam.lab.controls.elements.Button;
import com.epam.lab.controls.elements.TextInput;
import com.epam.lab.util.DriverConnectionUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class GMailPage {
    private WebDriver driver;
    @FindBy(css=".J-J5-Ji.T-I-KE.L3")
    private Button composeButton;
    @FindBy(id="gbqfq")
    private TextInput ariaSearch;
    @FindBy(id="gbqfb")
    private Button searchButton;

    public void checkCompose(){
        getComposeButton().click();
    }

    public GMailPage(){
        PageFactory.initElements(
                new CustomFieldDecorator(DriverConnectionUtil.getWebDriver()),
                this);
    }

    public GMailComposeMenu createComposeMenu(){

        return new  GMailComposeMenu();
    }

    public WebElement getComposeButton()
    {
        return composeButton;
    }

    public WebElement getAriaSearch() {
        return ariaSearch;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
