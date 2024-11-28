package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.ExtractNumber;
import testData.classes.CheckoutOverview;

public class CartPage 
{
  WebDriver driver;
  
  public CartPage(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  private By description(String item){return By.xpath("//div[@class=\"cart_list\"]/descendant::div[@class=\"cart_item_label\"][contains(.,\""+item+"\")]/div[@class=\"inventory_item_desc\"]");} //de corectat
  private By productName(String item) {return By.xpath("//div[@class=\"cart_list\"]/descendant::div[@class=\"inventory_item_name\"][contains(.,\""+item+"\")]");}
  private By productPrice(String item) {return By.xpath("//div[@class=\"cart_item_label\"][contains(.,\""+item+"\")]/descendant::div[@class=\"inventory_item_price\"]");}
  private By checkoutButton=By.id("checkout");  
  private By removeButton=By.xpath("//div[@class=\"item_pricebar\"]/button");
  private By continueShoppingButton=By.id("continue-shopping");
  private By pageId=By.xpath("//div[@class=\"header_secondary_container\"]/span");
  private By cartIcon=By.xpath("//div[@class=\"shopping_cart_container\"]");

  
  public void checkDescription(String actual, CheckoutOverview expected)
  {		
	Double pretCalculat=Double.parseDouble(expected.getPrice());
	Assert.assertEquals(driver.findElement(description(actual)).getText(), expected.getProductDescription()); 
	Assert.assertEquals(driver.findElement(productName(actual)).getText(), expected.getProductName());
	Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(productPrice(actual)).getText()), pretCalculat);	
  }

  public void clickCheckout()
  {
	  driver.findElement(checkoutButton).click();
  }
  
  public void clickRemoveFromCart()
  {
	  driver.findElement(removeButton).click();	  
  }

  public String getHeaderTitle()
  {
	  return driver.findElement(pageId).getText();
  }
  
  public void clickCheckoutButton()
  {
	  driver.findElement(checkoutButton).click();
  }
  public void checkPresenceOfIconsOnPage()
  {
	  Assert.assertTrue(driver.findElement(removeButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(cartIcon).isDisplayed());
	  Assert.assertTrue(driver.findElement(checkoutButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(continueShoppingButton).isDisplayed());
	  
  }
  public void clickContinueShopping()
  {
	  driver.findElement(continueShoppingButton).click();
  }
}
