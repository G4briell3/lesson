package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testData.classes.Checkout;

public class CheckoutPage 
{
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By firstName=By.id("first-name");
	private By lastName=By.id("last-name");
	private By postalCode=By.id("postal-code");
	private By continueButton=By.id("continue");
	private By cancelButton=By.id("cancel");
	private By menuButton=By.xpath("//div[@class=\"primary_header\"]/descendant::button[@id=\"react-burger-menu-btn\"]");
	private By cartIcon=By.xpath("//div[@id=\"shopping_cart_container\"]");
	
	public void completeDetails(Checkout nume)
	{
		driver.findElement(firstName).sendKeys(nume.getFirstName());
		driver.findElement(lastName).sendKeys(nume.getLastName());
		driver.findElement(postalCode).sendKeys(nume.getZipCode());
	}
	
	public void clickContinue()
	{
		driver.findElement(continueButton).click();
	}
	
	public void checkPresenceOfIconsOnPage()
	{
		driver.findElement(cancelButton).isDisplayed();
		driver.findElement(continueButton).isDisplayed();
		driver.findElement(menuButton).isDisplayed();
		driver.findElement(cartIcon).isDisplayed();
	}
}
