package testData.classes;

import Utils.Reader;

public class CheckProduct 
{
  private String productName;
  private String productDescription;
  private String productPrice;
  
  public CheckProduct(String details)
  {
	  this.productName=Reader.json(details).get("product name").toString();
	  this.productDescription=Reader.json(details).get("description").toString();
	  this.productPrice=Reader.json(details).get("price").toString();
  }
  
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public String getProductPrice() {
	return productPrice;
}
public void setProductPrice(String productPrice) {
	this.productPrice = productPrice;
}
  
  
}
