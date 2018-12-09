package pages.DialogPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginDialog 
{
	private WebElement element;
	
	public LoginDialog(WebElement element) 
	{
		this.element = element;
	}
	
	private By username = By.id("loginUserName");
	private By passWord = By.id("loginPassword");
	private By loginButton = By.className("btn-primary");

	public void login(String userName, String password) 
	{
		element.findElement(username).sendKeys(userName);
		element.findElement(passWord).sendKeys(password);
		element.findElement(loginButton).click();
	}
	   
	public String getLoginErrorMessage()
	{
		return element.findElement(By.id("login-error")).getText();
	}	
}
