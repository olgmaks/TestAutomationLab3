package SeleniumTest.elements;

import org.openqa.selenium.WebElement;

public class Input extends AbstractElement{
    public Input(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String text) {
        webElement.sendKeys(text);
    }
}
