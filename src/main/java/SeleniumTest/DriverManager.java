package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final ThreadLocal<WebDriver> pool = new ThreadLocal<WebDriver>(){
        protected WebDriver initialValue(){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts()
                    .implicitlyWait(20, TimeUnit.SECONDS);
            return driver;
        }
    };
    public static WebDriver getInstance() {
        return pool.get();

    }

    public static void startConnection(String URL){
        getInstance().navigate().to(URL);
    }

    public static void closeDriver(){
        getInstance().quit();
        pool.remove();
      }
}