package com.epam.pages;

import com.epam.control.*;
import com.epam.webdriverutils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailPage extends PageObject{

    @FindBy(className="T-Jo-auh")
    private List<Checkbox> messagesCheckboxes;

    @FindBy(xpath="//div[@class='ar9 T-I-J3 J-J5-Ji']")
    private Button deleteDivButton;//+

    @FindBy(xpath="//span[@id='link_undo']")
    private Span cancelDeleteSpan;//+

    @FindBy(xpath = "//div[@class='vh']")
    private WebElement divWhereAreSpans;

    @FindBy(xpath="//span[@class='bofITb']")
    private Span confirmationCancelDeleteSpan;//+

    @FindBy(xpath="//a[contains(@title, '@gmail.com')]")
    private Button verificationPageButton;//+

    @FindBy(css="div[aria-checked='true']")
    private List<Checkbox> selectedMessagesCheckboxes;//+

    @FindBy(xpath="//table[@class='F cf zt']")
    private Table table;//+

    public Span getCancelDeleteSpan() {//+
        return cancelDeleteSpan;
    }

    public Table getTable() {
        return table;
    }//+

    public String verificationThatPageIsOpened(){
        return verificationPageButton.getAttribute("title").trim();
    }//+

    public int getCountOfSelectedMessages(){//+
        return selectedMessagesCheckboxes.size();
    }

    public void deleteSelectedMessages(){//+
        deleteDivButton.click();
    }

    public void cancelDeleteMessages(){//+
        new WebDriverWait(WebDriverUtils.getDriver(), 10).
                until(ExpectedConditions.presenceOfNestedElementLocatedBy(divWhereAreSpans,
                        By.xpath("//*[@id=\"link_undo\"]")));
        cancelDeleteSpan.click();
    }

    public String verificationThatMessagesWereNotDeleted(){//+
        return confirmationCancelDeleteSpan.getText();
    }

}
