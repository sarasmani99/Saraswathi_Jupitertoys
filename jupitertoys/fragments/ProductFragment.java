package fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductFragment {
	private String title;
	private double price;
	private WebElement element;
	
	public ProductFragment(WebElement element) {
		this.element = element;
	}
	
	public void setTitle()
	{
		this.title = element.findElement(By.className("product-title")).getText();
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setPrice()
	{
		this.price = Double.parseDouble(element.findElement(By.className("product-price")).getText().replace("$", ""));
	}
	
	public double getPrice()
	{
		return price;
	}
	
}
