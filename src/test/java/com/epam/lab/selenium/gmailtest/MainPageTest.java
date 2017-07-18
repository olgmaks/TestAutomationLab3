package com.epam.lab.selenium.gmailtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.lab.selenium.gmail.main.MainPage;

public class MainPageTest {

	@Test(description = "Verifying if we can send message")
	public void writeMessageTest() {
		MainPage mp = new MainPage(TestConfig.driver);
		mp.writeMessage("igor5070101@gmail.com", "Auto Selenium mail", "Testing Gmail.");
		Assert.assertTrue(mp.isMyAccountVisible());
	}
}