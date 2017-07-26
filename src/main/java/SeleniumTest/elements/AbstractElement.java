package SeleniumTest.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AbstractElement {

    protected WebElement webElement;

    public AbstractElement(WebElement webElement) {
        try{
        this.webElement = webElement;
    }catch (Exception e){
        e.getMessage();
        this.webElement=null;
        }

    }

    public void click(){
        webElement.click();
    }

    public WebElement findElement (By by){
        return webElement.findElement(by);
    }

}
