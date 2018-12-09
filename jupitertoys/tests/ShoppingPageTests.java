package tests;

import static org.junit.Assert.*;

import java.util.function.Predicate;

import org.junit.Test;

import fragments.ProductFragment;
import pages.HomePage;
import pages.ShoppingPage;

public class ShoppingPageTests extends BasePageSuit{

	@Test
	public void verifyProductPrice()
	{
		HomePage homePage = new HomePage(driver);		
		homePage.clickShopMenu();
		
		ShoppingPage shoppingPage = new ShoppingPage(driver);	
		ProductFragment productFragment = shoppingPage.getProduct(fragmentQuery());
		
		System.out.println(productFragment.getPrice());
		assertEquals("Product price should be displayed correctly", 14.9, productFragment.getPrice(), 0);	
	}
	
	private Predicate<ProductFragment> fragmentQuery() {
	    return p -> p.getTitle().equals("Smiley Bear");
	}

}
