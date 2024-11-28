package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testData.URL;
import testData.classes.Users;
import testData.pages.Cart;
import testData.pages.Products;

public class ProductTestsNegative extends BaseTest
{    
  @Before @Override
  public void before()
  {
	  super.before();
  }
  
  @Test
	public void bookingWithMultipleDecimals()
	{
		driver.get(URL.MAIN);
		Assert.assertTrue(loginPage.isLoginButtonPresent());
		loginPage.authenticate(standardUser);
		loginPage.clickLogin();
		Assert.assertEquals(productsPage.getPageTitle(), Products.PageTitle);
		productsPage.selectProduct(Products.Produsul2);	
		productDetails.checkIfIconsAreDisplayed();
		productDetails.checkDescription(produsul2) ;			
		productDetails.addToCart();			
		productDetails.clickBackToProducts();
		
		productsPage.selectProduct(Products.Produsul1);	
		productDetails.checkIfIconsAreDisplayed();
		productDetails.checkDescription(produsul1) ;		
		productDetails.addToCart();
		productDetails.checkIfCartIconHasProducts();		
		productDetails.clickCartIcon();	
		
		cartPage.checkPresenceOfIconsOnPage();
		cartPage.checkDescription(Products.Produsul2,produsul2); 		
		cartPage.checkDescription(Products.Produsul1,produsul1); 
		cartPage.clickCheckoutButton();
		
		checkoutPage.checkPresenceOfIconsOnPage();
		checkoutPage.completeDetails(buyerDetails);
		checkoutPage.clickContinue();
		
		checkoutOverviewPage.checkPresenceOfIconsOnPage();
		checkoutOverviewPage.checkDetailsOfBookingTwoProductsFailed(produsul1, produsul2);
		checkoutOverviewPage.clickFinishButton();
		checkoutOverviewPage.checkDispatchedOrder();
	}
	
	@Test
	public void bookingWithNoProduct() //better name for this ???
	{
		driver.get(URL.MAIN);
		Assert.assertTrue(loginPage.isLoginButtonPresent());
		loginPage.authenticate(standardUser);
		loginPage.clickLogin();
		Assert.assertEquals(productsPage.getPageTitle(), Products.PageTitle);
		productsPage.checkItemsOnThePage();
		productsPage.selectProduct(Products.Produsul1);		
		productDetails.checkIfIconsAreDisplayed();		
		productDetails.checkDescription(produsul1) ;		
		productDetails.addToCart();	
		productDetails.checkIfCartIconHasProducts();		
		productDetails.clickCartIcon();	
		
		Assert.assertEquals(cartPage.getHeaderTitle(), Cart.HEADER);
		cartPage.checkPresenceOfIconsOnPage(); 
		cartPage.checkDescription(Products.Produsul1,produsul1); 
		cartPage.clickRemoveFromCart();
		cartPage.clickCheckoutButton();
		
		checkoutPage.checkPresenceOfIconsOnPage();
		checkoutPage.completeDetails(buyerDetails); 
		checkoutPage.clickContinue();
		
		checkoutOverviewPage.checkPresenceOfIconsOnPage();
		checkoutOverviewPage.checkProductDetails(produsul1);
		checkoutOverviewPage.clickFinishButton();
		checkoutOverviewPage.checkDispatchedOrder();	
	}
	
	@Test
	public void filteringAZUsingVisualUser() throws InterruptedException 
	{
		driver.get(URL.MAIN);
		Assert.assertTrue(loginPage.isLoginButtonPresent());
		loginPage.authenticate(visualUser);
		loginPage.clickLogin();
		Assert.assertEquals(productsPage.getPageTitle(), Products.PageTitle);
		productsPage.selectFilter("lohi");	
		Thread.sleep(2000);
	}
}
