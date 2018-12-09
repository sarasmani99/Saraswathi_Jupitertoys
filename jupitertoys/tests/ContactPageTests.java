package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pages.ContactPage;
import pages.HomePage;
import pages.data.ContactPageData;

public class ContactPageTests extends BasePageSuit{

	@Test
	public void verifyMandatoryFieldErrorMessages()
	{			
		HomePage homePage = new HomePage(driver);
		//click the contact menu
		homePage.clickContactMenu();		
		
		ContactPage contactPage = new ContactPage(driver);
		//click the submit button
		contactPage.clickSubmit();		
		
		assertEquals("Forename field should display required error message when value not supplied",
				"Forename is required", contactPage.getForenameErrorMessage());
		assertEquals("Email field should displ	ay required error message when value not supplied",
				"Email is required", contactPage.getEmailErrormessage());
		assertEquals("Message field should display required error message when value not supplied",
				"Message is required", contactPage.getMessageErrorMessage());
		
		ContactPageData contactPageData = new ContactPageData();
		contactPageData.setForeName("Saras");
		contactPageData.setEmail("saras@g.com");
		contactPageData.setMessage("saras");
					
				
		assertEquals("Forename field should not display required error message when value supplied",
				"", contactPage.getForenameErrorMessage());
		assertEquals("Email field should not display required error message when value supplied",
				"", contactPage.getEmailErrormessage());
		assertEquals("Message field should not display required error message when value supplied",
				"", contactPage.getMessageErrorMessage());
		
	}
	
	@Test
	public void verifyInvalidFieldErrorMessages() 
	{
		HomePage homePage=new HomePage(driver);
		homePage.clickContactMenu();		
		ContactPage contactPage = new ContactPage(driver);	
		
		contactPage.setEmail("test").setTelephone("number");
		
		assertEquals("Email field should display required error message when invalid value supplied",
				"Please enter a valid email", contactPage.getEmailErrormessage());
		assertEquals("Telephone field should display required error message when invalid value supplied",
				"Please enter a valid telephone number", contactPage.getTelephoneValidateMessage());				
	}
	
	@Test
	public void verifySuccessfulSubmission() 
	{		
		HomePage homePage=new HomePage(driver);
		homePage.clickContactMenu();
		ContactPage contactPage = new ContactPage(driver);					
		
		homePage.clickContactMenu();		
		contactPage.setForename("Dan").setEmail("dan@jupiter.com").setMessage("Hello");		
		contactPage.clickSubmit();
		
		assertEquals("Feedback should be submitted successfully",
				"Thanks Dan, we appreciate your feedback.", contactPage.getSuccessMessage());				
	}
}
