package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SentMailPage {



    @FindBy(xpath="//div[@class='ae4 UI']")
    private WebElement sentMailLists;

    @FindBy(xpath="//div[@class='BltHke nH oy8Mbf']//tr[@class='zA yO']")
    private List<WebElement> webElements;

    @FindBy(xpath="//span[@class='yP']")
    private WebElement mailTo;

    @FindBy(xpath="//span[@class='bog']")
    private WebElement subject;




    public SentMailPage(WebDriver driver) {

        PageFactory.initElements(driver, this);


    }

    public boolean checkSent(String email,String subject)
    {
       boolean isChecked = false;
        for (WebElement wb : webElements) {


            if (wb.findElement(By.cssSelector("span.yP")).getAttribute("email").equals(email)
                    && wb.findElement(By.cssSelector("span.bog")).getText().equals(subject)) {
                System.out.println("email was sent");
                wb.findElement(By.cssSelector("td.oZ-x3.xY")).click();

               isChecked = true;
            }


        }


       return isChecked;
    }


}
