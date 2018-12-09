package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ShoppingPage;

public class CartPageTests extends BasePageSuit{

	@Test
	public void verifyCartCount()
	{
		HomePage homePage = new HomePage(driver);		
		homePage.clickShopMenu();
		
		ShoppingPage shoppingPage = new ShoppingPage(driver);
		CartPage cartPage = new CartPage(driver);		
		
		//verify cart count for 0
		int count = homePage.getCartCount();
		assertEquals("Cart count is not equal to 0", count, 0);
		
		//verify cart count for 1 after adding an item
		shoppingPage.addItemToCart("Funny Cow");
		count = homePage.getCartCount();
		assertEquals("After adding one item, cart count is not equal to 1", count, 1);
			
		//verify cart count after Empty cart click
		homePage.clickCartMenu();
		cartPage.clickEmptyCart();
		cartPage.confirmEmptyCart();
		System.out.println(count);
		count = homePage.getCartCount();
		assertEquals("After doing the cart empty, cart count is not equal to 0", count, 0);
			
	}
}
