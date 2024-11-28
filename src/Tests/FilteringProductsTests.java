package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testData.URL;
import testData.pages.Products;

public class FilteringProductsTests extends BaseTest
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
	public void filteringAtoZ() 
	{
		productsPage.selectFilter("az");		
	}
	
	@Test
	public void filteringZtoA()  
	{
		productsPage.selectFilter("za");			
	}
	
	@Test
	public void filteringLowHigh() 
	{
		productsPage.selectFilter("lohi");			
	}
	
	@Test
	public void filteringHighLow() 
	{
		productsPage.selectFilter("hilo");			
	}
}
