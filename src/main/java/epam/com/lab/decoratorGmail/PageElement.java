package epam.com.lab.decoratorGmail;

import org.openqa.selenium.WebElement;

public abstract class PageElement  {

    protected WebElement webElement;

    public PageElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }
}
