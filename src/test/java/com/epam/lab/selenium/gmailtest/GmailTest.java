package com.epam.lab.selenium.gmailtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.lab.selenium.gmail.bussinessobjects.AccountFunctionsBO;
import com.epam.lab.selenium.gmail.bussinessobjects.MessageFunctionsBO;
import com.epam.lab.selenium.gmail.core.Constants;
import com.epam.lab.selenium.gmail.core.Driver;
import com.epam.lab.selenium.gmail.models.MessageModel;
import com.epam.lab.selenium.gmail.models.UserModel;
import com.epam.lab.selenium.gmail.pages.HomePage;
import com.epam.lab.selenium.gmail.pages.LoginPage;
import com.epam.lab.selenium.gmail.pages.SentFolderPage;

public class GmailTest {
	
	public static LoginPage login;
	public static HomePage homePage;
	public static SentFolderPage sentFolderPage;
	
	public boolean isTestSuccessfull;
				
	@BeforeTest
	public void testSetup() throws Exception {	
		System.setProperty(Constants.CHROME_DRIVER_NAME, Constants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get(Constants.GMAIL_DOMAIN);
		
		login = new LoginPage(Driver.getInstance());
		homePage = new HomePage(Driver.getInstance());
		sentFolderPage = new SentFolderPage(Driver.getInstance());
		
	}
	
	@Test(threadPoolSize = 3, dataProvider="getData")
	public void verifyExistanceOfSendedMessageInSendbox(String username, String password) throws InterruptedException {	
				
		UserModel user = new UserModel(username, password);
		MessageModel message = new MessageModel(Constants.EMAIL, Constants.EMAIL_SHORTENED, Constants.SUBJECT, Constants.MESSAGE);

		AccountFunctionsBO.loginAs(user);
		MessageFunctionsBO.writeMessage(homePage, message);
		isTestSuccessfull = MessageFunctionsBO.compareToLastMessageSent(homePage, sentFolderPage, message);
		MessageFunctionsBO.deleteMessage(sentFolderPage, message);
				
		AccountFunctionsBO.logout();
		AccountFunctionsBO.changeAccount();
				
		Assert.assertTrue(isTestSuccessfull);
	}
	
	@AfterTest
	public void testEnd() {
		Driver.getInstance().close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[5][2];
	
		data[0][0] = Constants.LOGIN1;
		data[0][1] = Constants.PASSWORD1;
	
		data[1][0] = Constants.LOGIN2;
		data[1][1] = Constants.PASSWORD2;
		
		data[2][0] = Constants.LOGIN3;
		data[2][1] = Constants.PASSWORD3;
		
		data[3][0] = Constants.LOGIN4;
		data[3][1] = Constants.PASSWORD4;
		
		data[4][0] = Constants.LOGIN5;
		data[4][1] = Constants.PASSWORD5;
	
		return data;
	}
}
