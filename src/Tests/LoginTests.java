package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testData.URL;
import testData.pages.Login;
import testData.pages.Products;

public class LoginTests extends BaseTest
{
  @Before @Override
  public void before()
  {
	  super.before();
	  driver.get(URL.MAIN);
	  Assert.assertTrue(loginPage.isLoginButtonPresent());
  }
  
  @Test
  public void loginWithValidData() throws InterruptedException
  {
	  loginPage.authenticate(standardUser);
	  loginPage.clickLogin();	
	  Assert.assertEquals(Products.PageTitle, productsPage.getPageTitle());
  }
  
  @Test
  public void loginWithInvalidData()
  {
	  loginPage.authenticate(invalidUser);
	  loginPage.clickLogin();
	  Assert.assertEquals(Login.WrongUsernameOrPassword, loginPage.getError());
  }
  
  @Test
  public void loginWithLockedOutUser()
  {
	  loginPage.authenticate(lockedOutUser);
	  loginPage.clickLogin();
	  Assert.assertEquals(Login.LockedOutError, loginPage.getError());
  }
  
  @Test 
  public void logout() 
  {
	  loginPage.authenticate(standardUser);
	  loginPage.clickLogin();
	  productsPage.logout();
	  Assert.assertTrue(loginPage.isLoginButtonPresent());
  }
}
