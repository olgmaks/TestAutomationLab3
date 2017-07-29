package com.epam.sel1;

import org.testng.annotations.Test;

import bussinessobj.HomePageBO;
import bussinessobj.LoginBO;
import driver.Driver;
import models.EmailModel;
import models.UserModel;
import testdata.Data;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;

public class testGmailSending {
	

	@DataProvider(parallel = true)
	public Object[] getData(){
		Data usersData = new Data();
		Object[] data = usersData.getUsers().toArray();
		return data;
	}

	@Test(dataProvider = "getData")
	public void test(UserModel user) {
		Data emailData = new Data();
		LoginBO login = new LoginBO();
		login.login(user);
		HomePageBO home = new HomePageBO();
		home.clickCompose();
		home.sendEmail(emailData.getEmails().get(0));
		home.closeErrorAndClearEmailInput();
		home.sendEmail(emailData.getEmails().get(1));
		assertTrue(home.verifyMessageisSent(emailData.getEmails().get(1)));
		
	}
	@AfterMethod
	public void closeBrowser() {
		Driver.close();
	}
}
