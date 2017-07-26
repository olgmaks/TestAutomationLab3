package epam.com.lab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ThreadDriverInstance {


    private static ThreadLocal<WebDriver> pool = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {

        if (pool.get() == null) {
            System.setProperty(Constants1.getValue("driver"), Constants1.getValue("resour"));
            WebDriver driver = new ChromeDriver();
            driver.get(Constants1.getValue("SITE"));
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            pool.set(driver);
        }

        return pool.get();
    }

    public static void close()  {
        getDriver().quit();
        pool.remove();
    }
}






