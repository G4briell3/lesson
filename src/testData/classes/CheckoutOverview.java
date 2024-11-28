package testData.classes;

import Utils.Reader;

public class CheckoutOverview
{
  private String productName;
  private String productDescription;
  private String price;
  private String paymentInfo;
  private String shippingInfo;
  private String intemTotal;
  private String tax;
  private String total;
  
  public CheckoutOverview(String details)
  {
		 this.productName=Reader.json(details).get("product name").toString();
		 this.productDescription=Reader.json(details).get("description").toString();
		 this.price=Reader.json(details).get("price").toString();
		 this.paymentInfo=Reader.json(details).get("Payment Information:").toString();
		 this.shippingInfo=Reader.json(details).get("Shipping Information:").toString();
		 this.intemTotal=Reader.json(details).get("Item total").toString();
		 this.tax=Reader.json(details).get("Tax").toString();
		 this.total=Reader.json(details).get("Total").toString(); 
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
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getPaymentInfo() {
	return paymentInfo;
}
public void setPaymentInfo(String paymentInfo) {
	this.paymentInfo = paymentInfo;
}
public String getShippingInfo() {
	return shippingInfo;
}
public void setShippingInfo(String shippingInfo) {
	this.shippingInfo = shippingInfo;
}
public String getIntemTotal() {
	return intemTotal;
}
public void setIntemTotal(String intemTotal) {
	this.intemTotal = intemTotal;
}
public String getTax() {
	return tax;
}
public void setTax(String tax) {
	this.tax = tax;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
  
  
}
