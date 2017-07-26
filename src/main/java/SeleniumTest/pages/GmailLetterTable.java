package SeleniumTest.pages;

import SeleniumTest.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailLetterTable {
    private List<WebElement> letters;
    public String id;

    public GmailLetterTable() {
        new WebDriverWait(DriverManager.getInstance(), 120).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='main']/div[4]/div[1]/div[1]/table")));
         fillLetters();
    }

    public List<WebElement> fillLetters() {
        letters = DriverManager.getInstance().findElements(By.xpath("//div[@role='main']/div[4]/div[1]/div[1]/table/tbody/tr"));
        id = DriverManager.getInstance().findElement(By.xpath("//div[@role='main']/div[4]/div[1]/div/table")).getAttribute("id");
       return letters;
    }

    public int findLettersQuantity() {
        return letters.size();
    }

    public WebElement findLetter(int index){
        return letters.get(index);
    }

    public int findLetterIndexById(int startIndex, String id) {
        int index=startIndex;
        while ((!this.findLetter(index).getAttribute("id").equals(id))&&(index<this.findLettersQuantity())){
            index++;
        }
        if (index==this.findLettersQuantity())
            index=-1;
        return index;
    }
    public int findSameLetterIndex(int startIndex, WebElement letter) {
        int index = startIndex;

        try {
            index = findLetterIndexById(startIndex, letter.getAttribute("id"));
        }
        catch (StaleElementReferenceException e){
            index = -1;
        }
        finally {
            return index;
        }
    }

    public boolean equalsByLetter(GmailLetterTable newTable, int oldIndex, int newIndex) {
        boolean equal = false;
        try {


        equal = this.findLetter(oldIndex).getAttribute("id").equals(newTable.findLetter(newIndex).getAttribute("id"));
        }
        catch (StaleElementReferenceException e){}
        finally {


        return equal;}
    }
}