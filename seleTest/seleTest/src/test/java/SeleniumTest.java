
import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.util.List;
import java.util.concurrent.TimeUnit;


public class SeleniumTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public static final String EMAIL = "vova3d3@ukr.net";
    public static final String SUBJECT = "SeleniumTest";
    public static final String WRONG_EMAIL = "vova3d3ukr.net";
    public static final String LOGIN = "pafoskorjon@gmail.com";
    public static final String PASS = "eminem3d3dx2012";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @AfterTest
    public void tearDown() {
       // driver.quit();
        driver = null;

    }

    @Test(priority = 1)
    public void getAndWait() {
        driver.get("https://www.gmail.com");
        wait = new WebDriverWait(driver, 30);
    }

    @Test(priority = 2)
    public void login() {
        driver.findElement(By.cssSelector("input.whsOnd.zHQkBf")).sendKeys(LOGIN);
        driver.findElement(By.id("identifierNext")).click();


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("password")));
        driver.findElement(By.name("password")).sendKeys(PASS);
        driver.findElement(By.id("passwordNext")).click();
    }


    @Test(priority = 3)
    public void composeTest() throws Exception {
        wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By
                        .xpath("//div[@class='T-I J-J5-Ji T-I-KE L3'] ")));
        driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3'] ")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Send')]")));
        driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(WRONG_EMAIL);
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(SUBJECT);
        WebElement Send = driver.findElement(By.xpath("//div[contains(text(),'Send')]"));
        Send.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Kj-JD")));
        driver.findElement(By.cssSelector("button.J-at1-auR")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName('to')[0].setAttribute('value','" + EMAIL + "')");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3")));
       // Send = driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3"));
        WebElement element = driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3")); //T-I J-J5-Ji aoO T-I-atl L3
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        element.click();


    }

    @Test(priority = 4)
    public void checkSent() {
         boolean isChecked = false;
        driver.findElement(By.id(":j0")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ae4.UI")));
        List<WebElement> webElementList = driver.findElements(By.cssSelector("tr.zA.yO"));

        for (WebElement wb : webElementList) {


            if (wb.findElement(By.cssSelector("span.yP")).getAttribute("email").equals(EMAIL)
                    && wb.findElement(By.cssSelector("span.bog")).getText().equals(SUBJECT)) {
                System.out.println("email was sent");
                wb.findElement(By.cssSelector("td.oZ-x3.xY")).click();
                isChecked = true;
            }

        }
        Assert.assertTrue(isChecked);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]")));
        driver.findElement(By.xpath("//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.Kj-JD")));
        driver.findElement(By.cssSelector("button.J-at1-auR.J-at1-atl")).click();
    }

}
