package com.epam.lab.selenium.gmail.bussinessobjects;

import org.openqa.selenium.NoAlertPresentException;

import com.epam.lab.selenium.gmail.core.Driver;
import com.epam.lab.selenium.gmail.models.UserModel;
import com.epam.lab.selenium.gmail.pages.HomePage;
import com.epam.lab.selenium.gmail.pages.LoginPage;

public class AccountFunctionsBO {
	
	public static void loginAs(UserModel user) throws InterruptedException {
		LoginPage login = new LoginPage(Driver.getInstance());
		login.enterLogin(user.getLogin());
		login.enterPassword(user.getPassword());
	}
	
	public static void logout() throws InterruptedException {
		HomePage mp = new HomePage(Driver.getInstance());
		Thread.sleep(1000);
		mp.clickOnAccountIcon();
		mp.clickOnLogoutButton();
		if(isAlertPresent())
		Driver.getInstance().switchTo().alert().accept();
	}
	
	public static void changeAccount() throws InterruptedException {
		LoginPage login = new LoginPage(Driver.getInstance());
		
		if(login.isChangeAccountOptionDisplayed()) {
			login.clickChangeAccountOption();
		} else {
			login.clickForgotPasswordLink();
			login.clickUseAnotherAccount();
			login.clickChangeAccountOption();
		}
	}
	
	public static boolean isAlertPresent() 
	{ 
	    try 
	    { 
	    	Driver.getInstance().switchTo().alert(); 
	        return true; 
	    }
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }
	}
}
