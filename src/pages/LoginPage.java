package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testData.classes.Users;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}	
	
	private By loginButton=By.id("login-button");
	private By userName=By.id("user-name");
	private By password=By.id("password");
	private By errorMessage=By.xpath("//div[@class=\"error-message-container error\"]");
	
	public void authenticate(Users user)
	{
		driver.findElement(userName).sendKeys(user.getUserName());
		driver.findElement(password).sendKeys(user.getPassword());
	}
	
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}
	
	public String getError()
	{
		return driver.findElement(errorMessage).getText();
	}
	
	public boolean isLoginButtonPresent()
	{
		return driver.findElement(loginButton).isDisplayed();
	}
}
