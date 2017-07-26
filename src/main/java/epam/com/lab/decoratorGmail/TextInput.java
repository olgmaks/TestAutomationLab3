package epam.com.lab.decoratorGmail;

import org.openqa.selenium.WebElement;

public class TextInput extends PageElement{

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    public void clear() {
        webElement.clear();
    }

}