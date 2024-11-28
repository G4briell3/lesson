package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import testData.URL;

import testData.pages.Cart;
//import testData.pages.Login;
import testData.pages.Products;
//import testData.pages.ProductsDescription;

public class ProductsTests extends BaseTest
{
	@Before @Override
	public void before()
	{
		super.before();
		driver.get(URL.MAIN);
		Assert.assertTrue(loginPage.isLoginButtonPresent());
		loginPage.authenticate(standardUser);
		loginPage.clickLogin();
		Assert.assertEquals(productsPage.getPageTitle(), Products.PageTitle);
	}
	
	@Test
	public void addRemoveFromCart() 
	{
		productsPage.addProductToCart(Products.Produsul1);		
		Assert.assertTrue(productsPage.checkIfCartIconHasProducts()); 
		productsPage.clickCartIcon();
		cartPage.checkDescription(Products.Produsul1,produsul1);
		cartPage.clickRemoveFromCart();		
		Assert.assertFalse(productDetails.checkIfCartIconHasProducts());	
	}
	
	@Test
	public void createBooking() 
	{
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
	public void createMultipleBooking() throws InterruptedException
	{
		productsPage.selectProduct(Products.Produsul1);	
		productDetails.checkIfIconsAreDisplayed();	
		productDetails.checkDescription(produsul1) ;			
		productDetails.addToCart();			
		productDetails.clickBackToProducts();
		
		productsPage.selectProduct(Products.Produsul2);	
		productDetails.checkIfIconsAreDisplayed();	
		productDetails.checkDescription(produsul2) ;		
		productDetails.addToCart();
		productDetails.clickBackToProducts();
		
		productsPage.selectProduct(Products.Produsul3);
		productDetails.checkIfIconsAreDisplayed();	
		productDetails.checkDescription(produsul3);
		productDetails.addToCart();
		productDetails.checkIfCartIconHasProducts();		
		productDetails.clickCartIcon();	
		
		cartPage.checkPresenceOfIconsOnPage();
		cartPage.checkDescription(Products.Produsul1,produsul1); 		
		cartPage.checkDescription(Products.Produsul2,produsul2); 
		cartPage.checkDescription(Products.Produsul3,produsul3);
		cartPage.clickCheckoutButton();
		
		checkoutPage.checkPresenceOfIconsOnPage();
		checkoutPage.completeDetails(buyerDetails);
		checkoutPage.clickContinue();
		
		checkoutOverviewPage.checkPresenceOfIconsOnPage();
		checkoutOverviewPage.checkMultipleProductDetails(); 
		checkoutOverviewPage.clickFinishButton();
		checkoutOverviewPage.checkDispatchedOrder();
	}
	@Test
	public void createBookingWithTwoProducts()
	{
		productsPage.selectProduct(Products.Produsul3);	
		productDetails.checkIfIconsAreDisplayed();	
		productDetails.checkDescription(produsul3) ;			
		productDetails.addToCart();			
		productDetails.clickBackToProducts();
		
		productsPage.selectProduct(Products.Produsul1);
		productDetails.checkIfIconsAreDisplayed();	
		productDetails.checkDescription(produsul1) ;		
		productDetails.addToCart();
		productDetails.checkIfCartIconHasProducts();		
		productDetails.clickCartIcon();	
		
		cartPage.checkPresenceOfIconsOnPage();
		cartPage.checkDescription(Products.Produsul3,produsul3); 		
		cartPage.checkDescription(Products.Produsul1,produsul1); 
		cartPage.clickCheckoutButton();
		
		checkoutPage.checkPresenceOfIconsOnPage();
		checkoutPage.completeDetails(buyerDetails);
		checkoutPage.clickContinue();
		
		checkoutOverviewPage.checkPresenceOfIconsOnPage();
		checkoutOverviewPage.checkDetailsOfBookingTwoProducts(produsul1, produsul3);
		checkoutOverviewPage.clickFinishButton();
		checkoutOverviewPage.checkDispatchedOrder();
	}
}
