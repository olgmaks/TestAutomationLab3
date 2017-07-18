package gmailpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\":ha\"]/div/div")
			private WebElement composeButton;
	
	@FindBy(css = ".oj div textarea")
	private WebElement emailInput;
	
	@FindBy(name="subjectbox")
	private WebElement subjectInput;
	
	@FindBy(css=".Ar.Au div ")
	private WebElement massageInput;
	
    @FindBy(css="div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
    private WebElement sendButton;
    
    @FindBy(css="body > div.Kj-JD > div.Kj-JD-Jl > button")
    private WebElement errorWindowOkButton;
    

    
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SendEmail(String email, String subject, String massage) {
		composeButton.click();
		emailInput.sendKeys(email);
		subjectInput.sendKeys(subject);
		massageInput.sendKeys(massage);
		sendButton.click();
		
		
	}	
	public void errorWindowOkButtonClick() {
		errorWindowOkButton.click();
	}
	
	public void  SendEmailAfterError(String email){
		new WebDriverWait(driver, 40)
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3")));
   	JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("document.getElementsByName('to')[0].setAttribute('value','" + email + "')");
       new WebDriverWait(driver, 40)
       .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3")));
       sendButton.click();   
	}
	
	public void  goToSentEmails(){
		 driver.findElement(By.xpath("//*[@id=\":hm\"]/div/div[2]/span/a")).click();
		
	}
}
