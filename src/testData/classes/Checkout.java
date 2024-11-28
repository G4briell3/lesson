package testData.classes;

import Utils.RandomGenerator;
import Utils.Reader;

public class Checkout 
{
  private String firstName;
  private String lastName;
  private String zipCode;
  
  public Checkout(String data)
  {
	  this.firstName=Reader.json(data).get("first name").toString();
	  this.lastName=Reader.json(data).get("last name").toString();
	  this.zipCode=RandomGenerator.numbers(6);
  }
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
  
  
}
