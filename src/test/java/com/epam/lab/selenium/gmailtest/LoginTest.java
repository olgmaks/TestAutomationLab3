package com.epam.lab.selenium.gmailtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.lab.selenium.gmail.main.Login;
import com.epam.lab.selenium.gmail.main.MainPage;

public class LoginTest {
	
	@Test(description = "Verifying if we can login correctly")
	public void simpleLoginTest() {
		Login login = new Login(TestConfig.driver);
		login.logInGmail("igor5070103@gmail.com", "igor507090");
		
		MainPage mainPage = new MainPage(TestConfig.driver);
		Assert.assertTrue(mainPage.isMyAccountVisible(), "User is not located on GmailHomePage");
	}
}
