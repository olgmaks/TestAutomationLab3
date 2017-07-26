package epam.com.lab.decoratorGmail;

import org.openqa.selenium.WebElement;


public class Button extends PageElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click(){
webElement.click();
    }


    public void submit() {
        webElement.submit();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }


}
