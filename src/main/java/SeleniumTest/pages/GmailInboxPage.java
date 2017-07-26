package SeleniumTest.pages;

import SeleniumTest.CustomFieldDecorator;
import SeleniumTest.DriverManager;
import SeleniumTest.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GmailInboxPage {
    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#imp']/../../../..")
    private Button importantButton;
    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#inbox']/../../../..")
    private Button allButton;

    private WebElement deleteButton;

    private GmailLetterTable allLetters;

    public GmailLetterTable getImportantLetters() {
        return importantLetters;
    }

    private GmailLetterTable importantLetters;

    public GmailInboxPage (){

        PageFactory.initElements(new CustomFieldDecorator(DriverManager.getInstance()),this);
        allLetters = new GmailLetterTable();

        updateImportantLattersTable();
    }

    public void updateImportantLattersTable(){
        importantButton.click();
        new WebDriverWait(DriverManager.getInstance(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='main']/div[4]/div[1]/div/table[not(@id='"+allLetters.id+"')]")));
        importantLetters = new GmailLetterTable();
        allButton.click();
        new WebDriverWait(DriverManager.getInstance(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='main']/div[4]/div[1]/div/table[@id='"+allLetters.id+"']")));

    }

    public boolean isLetterMarkAsImportant(int index){
        boolean isMarked = false;
        if (allLetters.findLetter(index).findElement(By.xpath(".//td[4]/div[1]")).getAttribute("aria-label").length()>17){
            isMarked=true;
        }
        return isMarked;
    }

    public void markImportant(int index){
             allLetters.findLetter(index).findElement(By.xpath(".//td[4]")).click();
    }


    public void markImportantLetterAsChoosen(int index){
        importantLetters.findLetter(index).findElement(By.xpath(".//td[2]")).click();
    }

    public void chooseImportantFolder(){
        importantButton.click();
    }
    public void deleteChousenButton(){
        deleteButton = DriverManager.getInstance().findElement(By.xpath("//*[@id=':5']/div[2]/div[1]/div[1]/div/div/div[2]/div[3]"));


        deleteButton.click();

    }

    public int allLetterQuantity (){
        return allLetters.findLettersQuantity();
    }


}
