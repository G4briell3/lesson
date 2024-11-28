package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import Utils.ExtractNumber;
import Utils.Generate;

public class ProductsPage 
{
  WebDriver driver;
  
  public ProductsPage(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  private By pageIdentifier=By.xpath("//span[@class=\"title\"]");
  private By menuButton=By.xpath("//div[@class=\"primary_header\"]/descendant::button[@id=\"react-burger-menu-btn\"]");
  private By logoutButton=By.xpath("//div[@class=\"bm-menu\"]/nav/a[@id=\"logout_sidebar_link\"]");
  private By cartIcon=By.id("shopping_cart_container");
  private By productLink(String nume) {return By.xpath("//div[@class=\"inventory_item_name \"][contains(.,\""+nume+"\")]");}
  private By filteringButton=By.xpath("//div[@class=\"right_component\"]/descendant::select");
  private By allItemsButton=By.xpath("//div[@class=\"bm-menu\"]/nav/a[@id=\"inventory_sidebar_link\"]");
  private By aboutButton=By.xpath("//div[@class=\"bm-menu\"]/nav/a[@id=\"about_sidebar_link\"]");
  private By resetAppStateButton=By.xpath("//div[@class=\"bm-menu\"]/nav/a[@id=\"reset_sidebar_link\"]");
  //private By firstProduct=By.xpath("//div[@class=\"inventory_item\"][1]");
  //private By firstProductPrice=By.xpath("//div[@class=\"inventory_item\"][1]/descendant::div[@class=\"inventory_item_price\"]");
  private By addToCart(String nume) {return By.xpath("//div[@class=\"inventory_item\"][contains(.,\""+nume+"\")]/descendant::button");}
  //private By inventoryContainer=By.xpath("//div[@class=\"inventory_list\"]");
  private By productsListNames=By.xpath("//div[@class=\"inventory_list\"]/descendant::div[@class=\"inventory_item_name \"]");
  private By productsListPrices=By.xpath("//div[@class=\"inventory_list\"]/descendant::div[@class=\"inventory_item_price\"]");
  
  public String getPageTitle()
  {
	 return driver.findElement(pageIdentifier).getText();
  }
  
  public void selectProduct(String produs)
  {
	  driver.findElement(productLink(produs)).click();		  
  }
  
  public void addProductToCart(String produs)
  {
	  driver.findElement(addToCart(produs)).click();
  } 
  
	public void clickCartIcon()
	{
		driver.findElement(cartIcon).click();
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
	
  
  public void selectFilter(String option) 
  {	 
	  Select classicSelect= new Select(driver.findElement(filteringButton));
	  classicSelect.selectByValue(option);
	  switch(option)
	  {
	  case("az"): 
		  List<WebElement> productsListAscending=driver.findElements(productsListNames);
		  List<String> itemsOnPageAscending=Generate.listOfItems(productsListAscending);		 	
		  Assert.assertTrue(Generate.isSortedAlphabeticallyAZ(itemsOnPageAscending));
	  break;
	  case("za"):	 
		  List<WebElement> productsListDescending=driver.findElements(productsListNames);
		  List<String> itemsOnPageDescending=Generate.listOfItems(productsListDescending);		 
		  Assert.assertTrue(Generate.isSortedAlphabeticallyZA(itemsOnPageDescending));
	  break;
	  case("lohi"):	  
		  List<WebElement> productsListLOHI=driver.findElements(productsListPrices);
		  List<Double> itemsOnPageLOHI=Generate.listOfItemsPrices(productsListLOHI);	 
		  Assert.assertTrue(Generate.isSortedAscending(itemsOnPageLOHI)) ; 
	  break;
	  case("hilo"):	
		  List<WebElement> productsListHILO=driver.findElements(productsListPrices);
		  List<Double> itemsOnPageHILO=Generate.listOfItemsPrices(productsListHILO);		  
		  Assert.assertTrue(Generate.isSortedDescending(itemsOnPageHILO));
	  break;
	  }
  }
  
  public void logout() 
  {
	  driver.findElement(menuButton).click(); 
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  WebElement asteapta=wait.until(ExpectedConditions.visibilityOf(driver.findElement(allItemsButton)));
	  Assert.assertTrue(driver.findElement(allItemsButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(aboutButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(logoutButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(resetAppStateButton).isDisplayed());
	  driver.findElement(logoutButton).click();
	  
  }
  public void checkItemsOnThePage()
  {
	  Assert.assertTrue(driver.findElement(menuButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(filteringButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(cartIcon).isDisplayed());
  }

}
