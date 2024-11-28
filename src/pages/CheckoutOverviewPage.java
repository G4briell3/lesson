package pages;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.ExtractNumber;
import Utils.Generate;
import testData.classes.CheckoutOverview;
import testData.pages.CheckoutOverviewTestData;

public class CheckoutOverviewPage 
{
  WebDriver driver;
 
  public CheckoutOverviewPage(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  private By productName=By.xpath("//div[@class=\"cart_item_label\"]/a/div[@class=\"inventory_item_name\"]");
  private By productDescription=By.xpath("//div[@class=\"inventory_item_desc\"]");
  private By productPrice=By.xpath("//div[@class=\"item_pricebar\"]/div");
  private By paymentInfo=By.xpath("//div[@class=\"summary_info\"]/div[@data-test=\"payment-info-value\"]");
  private By shippingInfo=By.xpath("//div[@class=\"summary_info\"]/div[@data-test=\"shipping-info-value\"]");
  private By itemTotal=By.xpath("//div[@class=\"summary_subtotal_label\"]");
  private By tax=By.xpath("//div[@class=\"summary_tax_label\"]");
  private By total=By.xpath("//div[@class=\"summary_total_label\"]"); 
  private By finishButton=By.xpath("//div[@class=\"cart_footer\"]/button[@id=\"finish\"]");
  private By cancelButton=By.xpath("//div[@class=\"cart_footer\"]/button[@id=\"cancel\"]");
  private By menuButton=By.xpath("//div[@class=\"primary_header\"]/descendant::button[@id=\"react-burger-menu-btn\"]");
  private By cartIcon=By.xpath("//div[@class=\"shopping_cart_container\"]");
  private By orderFinishedMessage=By.xpath("//div[@id=\"checkout_complete_container\"]/h2");
  private By backHomeButton=By.xpath("//div[@id=\"checkout_complete_container\"]/button"); 
  private By multipleProductName(String item) {return By.xpath("//div[@class=\"cart_item_label\"][contains(.,\""+item+"\")]/a/div");}
  private By multipleProductDescription(String item) {return By.xpath("//div[@class=\"cart_item_label\"][contains(.,\""+item+"\")]/div[@class=\"inventory_item_desc\"]");}
  private By multipleProductPrice(String item) {return By.xpath("//div[@class=\"cart_item_label\"][contains(.,\""+item+"\")]/div[@class=\"item_pricebar\"]");}
  private By produsul1Name=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_0_title_link\"]");
  private By produsul1Description=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_0_title_link\"]/following-sibling::div[@class=\"inventory_item_desc\"]");
  private By produsul1Price=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_0_title_link\"]/following-sibling::div[@class=\"item_pricebar\"]");
  private By produsul2Name=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_5_title_link\"]");
  private By produsul2Description=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_5_title_link\"]/following-sibling::div[@class=\"inventory_item_desc\"]");
  private By produsul2Price=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_5_title_link\"]/following-sibling::div[@class=\"item_pricebar\"]");
  private By produsul3Name=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_4_title_link\"]");
  private By produsul3Description=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_4_title_link\"]/following-sibling::div[@class=\"inventory_item_desc\"]");
  private By produsul3Price=By.xpath("//div[@class=\"cart_list\"]/descendant::a[@id=\"item_4_title_link\"]/following-sibling::div[@class=\"item_pricebar\"]");

  
  public void checkProductDetails(CheckoutOverview item) 
  {
	Assert.assertEquals(driver.findElement(productName).getText(),item.getProductName()); 
	Assert.assertEquals(driver.findElement(productDescription).getText(),item.getProductDescription());
	Double pretDouble=Double.parseDouble(item.getPrice());	
	Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(productPrice).getText()),pretDouble );
	Assert.assertEquals(driver.findElement(paymentInfo).getText(),item.getPaymentInfo());
	Assert.assertEquals(driver.findElement(shippingInfo).getText(), item.getShippingInfo());
	Double itemTotalDouble=Double.parseDouble(item.getIntemTotal());
	Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(itemTotal).getText()),itemTotalDouble);
	Double taxDouble=Double.parseDouble(item.getTax());
	Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(tax).getText()),taxDouble);
	Double totalDouble=Double.parseDouble(item.getTotal());
	Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(total).getText()),totalDouble);	
  }  

  public void checkMultipleProductDetails () 
  {
	  List<WebElement> listaProduse =driver.findElements(By.xpath("//div[@class=\"cart_item_label\"]/a/div[@class=\"inventory_item_name\"]"));	  
	  List<WebElement> listaDescriereProduse=driver.findElements(By.xpath("//div[@class=\"cart_item_label\"]/div[@class=\"inventory_item_desc\"]"));	 
	  List<WebElement> listaPreturiProduse=driver.findElements(By.xpath("//div[@class=\"cart_item_label\"]/div[@class=\"item_pricebar\"]"));	  
	  List<String> valoriListaProduse=Generate.listOfItems(listaProduse);	 
	  List<String> valoriListaDescriereProduse=Generate.listOfItems(listaDescriereProduse);	 
	  List<String> valoriListaPreturiProduse=Generate.listOfItems(listaPreturiProduse);
	  Double pretTotal=0.00;  
	  int n=valoriListaProduse.size();
	  for(int i=0;i<n;i++)
	  {		  	 
		  Assert.assertEquals(driver.findElement(multipleProductName(valoriListaProduse.get(i))).getText(), valoriListaProduse.get(i));		 
		  Assert.assertEquals(driver.findElement(multipleProductDescription(valoriListaDescriereProduse.get(i))).getText(), valoriListaDescriereProduse.get(i));		 
		  Assert.assertEquals(driver.findElement(multipleProductPrice(valoriListaPreturiProduse.get(i))).getText(),valoriListaPreturiProduse.get(i));
		  Double pretProdus=ExtractNumber.extractPriceDouble(driver.findElement(multipleProductPrice(valoriListaPreturiProduse.get(i))).getText());		  
		  pretTotal+=pretProdus;		 
	  }
	  Assert.assertEquals(driver.findElement(paymentInfo).getText(),CheckoutOverviewTestData.paymentInformation);
	  Assert.assertEquals(driver.findElement(shippingInfo).getText(),CheckoutOverviewTestData.shippingInformation );
	  Double pretTotalAfisat=ExtractNumber.extractPriceDouble(driver.findElement(itemTotal).getText());
	  Assert.assertEquals(pretTotal,pretTotalAfisat);
	  DecimalFormat df = new DecimalFormat("#.00");
	  String taxCalculated=df.format(pretTotal*0.08008);	  
	  String taxaAfisata=df.format(ExtractNumber.extractPriceDouble(driver.findElement(tax).getText()));	
	  Assert.assertEquals(taxCalculated, taxaAfisata);
	  Double totalCalculat=Double.parseDouble(taxCalculated)+pretTotal;	  	  
	  Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(total).getText()), totalCalculat);
  }
  public void checkDetailsOfBookingTwoProducts(CheckoutOverview produsul1, CheckoutOverview produsul2)
  {
		Assert.assertEquals(driver.findElement(produsul1Name).getText(),produsul1.getProductName());  
		Assert.assertEquals(driver.findElement(produsul1Description).getText(),produsul1.getProductDescription());		
		Double pretul1JsonDouble=Double.parseDouble(produsul1.getPrice());
		Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(produsul1Price).getText()),pretul1JsonDouble );
		Assert.assertEquals(driver.findElement(produsul3Name).getText(),produsul2.getProductName()); 
		Assert.assertEquals(driver.findElement(produsul3Description).getText(),produsul2.getProductDescription());		
		Double pretul2JsonDouble= Double.parseDouble(produsul2.getPrice());
		Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(produsul3Price).getText()),pretul2JsonDouble);
		Assert.assertEquals(driver.findElement(paymentInfo).getText(),produsul1.getPaymentInfo());
		Assert.assertEquals(driver.findElement(shippingInfo).getText(), produsul1.getShippingInfo());
		Double pretTotalAfisat=ExtractNumber.extractPriceDouble(driver.findElement(itemTotal).getText());
		Double pretTotalCalculat=ExtractNumber.extractPriceDouble(produsul1.getPrice())+ExtractNumber.extractPriceDouble(produsul2.getPrice());
		Assert.assertEquals(pretTotalAfisat,pretTotalCalculat);
		DecimalFormat df = new DecimalFormat("#.00");
		String taxCalculated=df.format(pretTotalCalculat*0.08008);
		Double totalCalculat=Double.parseDouble(taxCalculated)+pretTotalCalculat;
		Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(total).getText()), totalCalculat);		
  }  
  
  public void checkDetailsOfBookingTwoProductsFailed(CheckoutOverview produsul1, CheckoutOverview produsul2)
  {
	  	BigDecimal sitePrice1=ExtractNumber.extractPriceBigDecimal(driver.findElement(produsul1Price).getText());
	  	BigDecimal sitePrice2=ExtractNumber.extractPriceBigDecimal(driver.findElement(produsul2Price).getText());
	  	BigDecimal jsonPrice1=new BigDecimal(produsul1.getPrice());
	  	BigDecimal jsonPrice2=new BigDecimal(produsul2.getPrice());
		Assert.assertEquals(driver.findElement(produsul1Name).getText(),produsul1.getProductName());  
		Assert.assertEquals(driver.findElement(produsul1Description).getText(),produsul1.getProductDescription());
		Assert.assertEquals(sitePrice1, jsonPrice1);
		Assert.assertEquals(driver.findElement(produsul2Name).getText(),produsul2.getProductName()); 
		Assert.assertEquals(driver.findElement(produsul2Description).getText(),produsul2.getProductDescription());
		Assert.assertEquals(sitePrice2, jsonPrice2);
		Assert.assertEquals(driver.findElement(paymentInfo).getText(),produsul1.getPaymentInfo());
		Assert.assertEquals(driver.findElement(shippingInfo).getText(), produsul1.getShippingInfo());
		BigDecimal pretTotalAfisat=ExtractNumber.extractPriceBigDecimal(driver.findElement(itemTotal).getText());		
		BigDecimal pretTotalCalculat=jsonPrice1.add(jsonPrice2);	
		Assert.assertEquals(pretTotalAfisat,pretTotalCalculat); 
		Double pretTotalCalculatDouble=pretTotalCalculat.doubleValue();
		DecimalFormat df = new DecimalFormat("#.00");		
		Double taxCalculated=Double.parseDouble(df.format(pretTotalCalculatDouble*0.08008));
		Double totalCalculat=taxCalculated+pretTotalCalculatDouble;
		Assert.assertEquals(ExtractNumber.extractPriceDouble(driver.findElement(total).getText()), totalCalculat);		
  }  
 
  public void clickFinishButton()
  {
	  driver.findElement(finishButton).click();
  }
  
  public void checkDispatchedOrder()
  {
	  Assert.assertEquals(driver.findElement(orderFinishedMessage).getText(), CheckoutOverviewTestData.FINISHED_ORDER_MESSAGE);
	  driver.findElement(backHomeButton).click();
  }
  
  public void checkPresenceOfIconsOnPage()
  {
	  Assert.assertTrue(driver.findElement(finishButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(cartIcon).isDisplayed());
	  Assert.assertTrue(driver.findElement(cancelButton).isDisplayed());
	  Assert.assertTrue(driver.findElement(menuButton).isDisplayed());
	  
  }
}
