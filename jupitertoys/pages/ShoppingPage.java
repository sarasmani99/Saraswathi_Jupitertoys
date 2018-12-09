package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fragments.ProductFragment;
import pages.dtos.ProductInfo;

public class ShoppingPage extends BasePage{
	
	public ShoppingPage(WebDriver driver) {
		super(driver);		
	}
	
	public List<ProductFragment> getProducts(Predicate<ProductFragment> query) {
		return getAllProducts()
				.stream()
				.filter(query)
				.collect(Collectors.toList());
	}
	
	public ProductFragment getProduct(Predicate<ProductFragment> query) {
		
		Optional<ProductFragment> productFragment = getAllProducts()
				.stream()
				.filter(query)
				.findAny();
		
		return productFragment.isPresent() ? productFragment.get():null;
	}
	
	public List<ProductFragment> getAllProducts()
	{
		List<ProductFragment> productFragments = new ArrayList<ProductFragment>();
		List<WebElement> productElements = driver.findElements(By.className("product"));
		System.out.println(productElements.size());
		for(WebElement element : productElements)
		{
			ProductFragment productFragment = new ProductFragment(element);
			productFragment.setTitle();
			productFragment.setPrice();
			System.out.println(productFragment.getTitle());
			System.out.println(productFragment.getPrice());
			productFragments.add(productFragment);
		}
		return productFragments;		
	}
	
	public ProductInfo getProductInfo(String productName,String productPrice)
	{
		ProductInfo productInfo=new ProductInfo();
		List<WebElement> elements=driver.findElements(By.tagName("li"));
		
		for(WebElement ele:elements)
		{
			if(ele.getAttribute("id").contains("product-") && ele.findElement(By.className("product-title")).getText().equals(productName))
			{
				String name=ele.findElement(By.className("product-title")).getText();
				Float price=Float.parseFloat(ele.findElement(By.className("product-price")).getText().replace("$", ""));
				//System.out.println(name+" "+price);
				if(name.equals(productName) && productPrice.contains(price.toString()))
				{
					//System.out.println(name+" "+price);
					productInfo.setName(name);
					productInfo.setPrice(price);
				}
			}
		}
		return productInfo;			
	}
	
	public void addItemToCart(String itemName)
	{
		List<WebElement> elements=driver.findElements(By.tagName("li"));
		for(WebElement ele:elements)
		{
			if(ele.getAttribute("id").contains("product-") && ele.findElement(By.className("product-title")).getText().equals(itemName))
			{
				ele.findElement(By.className("btn-success")).click();
			}
		}
	}

}
