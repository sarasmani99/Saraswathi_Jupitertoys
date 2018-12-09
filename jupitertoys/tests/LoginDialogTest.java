package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pages.HomePage;
import pages.DialogPages.LoginDialog;

public class LoginDialogTest extends BasePageSuit{
	
	@Test
	public void verifyInvalidLoginMessage() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);			
		LoginDialog loginDialogue = null;
		
		loginDialogue = homePage.clickLogin();				
		loginDialogue.login("abc","abc");
		
		assertEquals("UserName field should display required error message when invalid username supplied",
				"Your login details are incorrect", loginDialogue.getLoginErrorMessage());		
			
		assertEquals("Password field should display required error message when invalid password supplied",
				"Your login details are incorrect", loginDialogue.getLoginErrorMessage());
	}
	
	@Test
	public void verifySuccessfulLogin()
	{
		HomePage homePage = new HomePage(driver);		
		LoginDialog loginDialogue = null;
		
		loginDialogue = homePage.clickLogin();				
		loginDialogue.login("user1","letmein");	
		
		assertEquals("Login should be successful and should display welcome message",
				"user1", homePage.getLoggedInUserName());		
	}

}
