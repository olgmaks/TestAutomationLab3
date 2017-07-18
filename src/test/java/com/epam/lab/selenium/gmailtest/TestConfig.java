package com.epam.lab.selenium.gmailtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.epam.lab.selenium.gmail.main.Login;
import com.epam.lab.selenium.gmail.main.MainPage;
import com.epam.lab.selenium.gmail.main.SendedFolder;

public class TestConfig {
	
	public static WebDriver driver;
	
	public static Login login;
	public static MainPage mainPage;
	public static SendedFolder sendedFolder;

	@BeforeSuite
	public void setupTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.gmail.com");
				
		login = new Login(driver);
		mainPage = new MainPage(driver);
		sendedFolder = new SendedFolder(driver);
	}
	
	@AfterSuite
	public void testsEnd() {
		driver.close();
	}
}
