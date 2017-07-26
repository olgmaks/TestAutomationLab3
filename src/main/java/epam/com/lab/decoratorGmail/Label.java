package epam.com.lab.decoratorGmail;

import org.openqa.selenium.WebElement;

public class Label extends PageElement{

    public Label(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        return webElement.getText();
    }

}