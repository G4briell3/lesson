package pages;


import java.math.BigDecimal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

import Utils.ExtractNumber;
import testData.classes.CheckoutOverview;

public class ProductDetails 
{
	 WebDriver driver;
	
	public ProductDetails(WebDriver driver)
	{
		this.driver=driver;
	}	

	private By addToCartButton=By.id("add-to-cart");
	private By removeFromCartButton=By.id("remove");
	private By removeItem=By.id("remove");
	private By cartIcon=By.xpath("//div[@id=\"shopping_cart_container\"]");
	private By productDescription=By.xpath("//div[@class=\"inventory_details_desc large_size\"]");
	private By productName=By.xpath("//div[@class=\"inventory_details_name large_size\"]");
	private By productPrice=By.xpath("//div[@class=\"inventory_details_price\"]");
	private By backToProductsButton=By.xpath("//div[@class=\"left_component\"]/button");
	
	public void addToCart()
	{
		driver.findElement(addToCartButton).click();
		Assert.assertTrue(isRemoveButtonDisplayed());
	}
	
	public void removeFromCart()
	{
		driver.findElement(removeItem).click();
		Assert.assertTrue(isAddButtonDisplayed());
	}
	
	public boolean checkIfCartIconHasProducts()
	{
		if (driver.findElement(cartIcon).getText().isBlank())
				{
					return false;
				}
		else
				{			  
					return true;
				}		
	}	

	public void clickCartIcon()
	{
		driver.findElement(cartIcon).click();
	}
	
	public boolean isAddButtonDisplayed()
	{
		return driver.findElement(addToCartButton).isDisplayed();
	}
	
	public boolean isRemoveButtonDisplayed()
	{
		return driver.findElement(removeFromCartButton).isDisplayed();
	}

	public void checkIfIconsAreDisplayed()
	{
		Assert.assertTrue(driver.findElement(cartIcon).isDisplayed());
		Assert.assertTrue(driver.findElement(backToProductsButton).isDisplayed());
	}
	
	public void checkDescription(CheckoutOverview item) 
	{
		Assert.assertTrue(isAddButtonDisplayed());
		BigDecimal pretAfisat=ExtractNumber.extractPriceBigDecimal(driver.findElement(productPrice).getText());
		BigDecimal pretCalculat=new BigDecimal(item.getPrice());
		Assert.assertEquals(driver.findElement(productName).getText(), item.getProductName());
		Assert.assertEquals(driver.findElement(productDescription).getText(), item.getProductDescription());
		Assert.assertEquals(pretAfisat, pretCalculat);		
	}
	
	public void clickBackToProducts()
	{
		driver.findElement(backToProductsButton).click();
	}	

}
