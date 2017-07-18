package gmailpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(name="identifier")
			private WebElement loginInput;
	
	@FindBy(id="identifierNext")
	private WebElement identifierNextButton ;
	
	@FindBy(name="password")
	private WebElement passwordInput;
	
	@FindBy(id="passwordNext")
	
	private WebElement passwordNextButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void typeLoginAndSubmit(String login) {
		loginInput.sendKeys(login);
		identifierNextButton.click();
		
	}	
	public void typePasswordAndSubmit(String password) {
		
		passwordInput.sendKeys(password);
		passwordNextButton.click();
		
	}	

}
