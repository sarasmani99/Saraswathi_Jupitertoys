package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.DialogPages.LoginDialog;

public class BasePage {	
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void clickShopMenu()
	{
		WebElement parentElement = driver.findElement(By.id("nav-shop"));
		parentElement.findElement(By.tagName("a")).click();
	}
	
	public void clickContactMenu()
	{
		WebElement parentElement = driver.findElement(By.id("nav-contact"));
		parentElement.findElement(By.tagName("a")).click();
	}
	
	public LoginDialog clickLogin()
	{
		WebElement parentElement = driver.findElement(By.id("nav-login"));
		parentElement.findElement(By.tagName("a")).click();
		
		WebElement loginDialogElement = driver.findElement(By.className("popup"));		
		return new LoginDialog(loginDialogElement);
	}	
	
	public void clickCartMenu()
	{
		WebElement parentElement = driver.findElement(By.id("nav-cart"));
		parentElement.findElement(By.tagName("a")).click();		
	}
	
	public int getCartCount()
	{
		WebElement element = driver.findElement(By.id("nav-cart"));
		int count=Integer.parseInt(element.findElement(By.className("cart-count")).getText());
		return count;
	}
	
	public String getLoggedInUserName()
	{
		WebElement element = driver.findElement(By.id("nav-user"));
		String userName = element.findElement(By.tagName("a")).findElement(By.className("user")).getText();
		return userName;
	}	
}
