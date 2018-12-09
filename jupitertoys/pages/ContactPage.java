package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.data.ContactPageData;


public class ContactPage extends BasePage{
	
		public ContactPage(WebDriver driver) {
			super(driver);		
		}
	
	public ContactPage(WebDriver driver,ContactPageData contactPageData) {
		super(driver);	
	}
	
	public ContactPage setForename(String foreName) 
	{
		driver.findElement(By.name("forename")).sendKeys(foreName);
		return this;
	}
	
	public ContactPage setSurname(String surName)
	{
		driver.findElement(By.name("surname")).sendKeys(surName);
		return this;
	}
	
	public ContactPage setEmail(String email) 
	{
		driver.findElement(By.name("email")).sendKeys(email);
		return this;
	}
	
	public ContactPage setMessage(String message) 
	{
		driver.findElement(By.name("message")).sendKeys(message);
		return this;
	}
	
	public ContactPage setTelephone(String telePhone) 
	{
		driver.findElement(By.name("telephone")).sendKeys(telePhone);
		return this;
	}	
	
	private String getErrorMessageText(By locator)
	{
		List<WebElement> elements=driver.findElements(locator);
		return elements.size() == 0 ? "":elements.get(0).getText();
	}
	
	public String getForenameErrorMessage() {
		
		return getErrorMessageText(By.id("forename-err"));
	}
	
	public String getEmailErrormessage() {
		return getErrorMessageText(By.id("email-err"));
	}
	
	public String getMessageErrorMessage() {
	
		return getErrorMessageText(By.id("message-err"));
	}
	
	public String getTelephoneValidateMessage() {
	
		return getErrorMessageText(By.id("telephone-err"));
	}	
	
	public String getSuccessMessage() {		
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success"))); 
		if(element == null) {
			return "";
		}else {
			//System.out.println(element.getText());
			return element.getText();
		}
		
	}
	
	public void clickSubmit() {
		driver.findElement(By.linkText("Submit")).click();
	}

}
