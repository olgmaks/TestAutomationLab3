package com.epam.lab;

import org.testng.annotations.Test;

import com.epam.lab.projectBOs.LoginBO;
import com.epam.lab.projectBOs.MailBO;
import com.epam.lab.util.Driver;
import com.epam.lab.util.PropertiesLoader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.util.Properties;
import org.testng.annotations.AfterMethod;

public class TestNGPageObject {

	@BeforeMethod
	public void beforeMethod(){
	}

	@Test(threadPoolSize = 5, dataProvider = "getUsersData")
	public void testSend(String propName) throws Exception{
		Properties mailProp = new PropertiesLoader().getProperties(propName + ".properties");
		LoginBO login = new LoginBO(mailProp);
		login.loginInEmail();
		MailBO mailBO = new MailBO(mailProp);
		mailBO.createAndSendLetter();
		mailBO.deleteFromSent();		
	}
	
	@DataProvider(name = "getUsersData", parallel = true)
    public Object[][] setGmailProperties() {
      return new Object[][] {      
       {"gmail1"},
       {"gmail2"},
       {"gmail3"}       
      };
    }

	@AfterMethod
	public void afterMethod() {
		Driver.quitDriver();
				
	}

}
