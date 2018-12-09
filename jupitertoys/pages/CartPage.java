package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage
{
	public CartPage(WebDriver driver) {
		super(driver);		
	}
	
	public void clickEmptyCart()
	{
		driver.findElement(By.className("btn-danger")).click();
	}	
	
	public void confirmEmptyCart()
	{
		driver.findElement(By.linkText("Yes")).click();
	}
	
	public void cancelEmptyCart()
	{
		driver.findElement(By.linkText("No")).click();
	}

}
