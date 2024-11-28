package Tests;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductDetails;
import pages.ProductsPage;
import testData.classes.Checkout;
import testData.classes.CheckoutOverview;
import testData.classes.Users;

public class BaseTest 
{
	static WebDriver driver;
	public static Users standardUser =new Users("standardUser");
	public static Users invalidUser=new Users("invalidDataLogin");
	public static Users lockedOutUser=new Users("lockedOutUser");	
	public static Users visualUser=new Users("visualUser");
	public static Checkout buyerDetails=new Checkout("checkoutData");	
	public static CheckoutOverview produsul2=new CheckoutOverview("produsul2");
	public static CheckoutOverview produsul3=new CheckoutOverview("produsul3");
	public static CheckoutOverview produsul1=new CheckoutOverview("produsul1");
	public static LoginPage loginPage;
	public static ProductsPage productsPage ;	
	public static ProductDetails productDetails;	
	public static CartPage cartPage;
	public static CheckoutPage checkoutPage;
	public static CheckoutOverviewPage checkoutOverviewPage;
	
  
	@BeforeClass
	public static void setup()
	{
		
	}
	
	@AfterClass
	public static void tearDown()
	{
		
	}
  
	
	@Before
	public void before()
	{
		ChromeOptions chromeOption=new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		System.setProperty("webdriver.chrome.driver","src/resource/chromedriver.exe");
		chromeOption.addArguments("disable-infobars"); // Disable infobars
		chromeOption.addArguments("disable-popup-blocking"); // Disable popup blocking
		chromeOption.addArguments("disable-default-apps"); // Disable default apps
		chromeOption.addArguments("no-first-run"); // Skip first run wizards
		chromeOption.addArguments("no-default-browser-check"); // Skip default browser check
		chromeOption.addArguments("--disable-search-engine-choice-screen");//skip search engine options
		chromeOption.addArguments("start-maximized"); // Open browser in maximized mode
		chromeOption.addArguments("disable-notifications"); // Disable notifications
		chromeOption.addArguments("disable-extensions"); // Disable extensions
		
		driver=new ChromeDriver(chromeOption);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
		loginPage=new LoginPage(driver);
		productsPage=new ProductsPage(driver);
		productDetails=new ProductDetails(driver);
		cartPage=new CartPage(driver);
		checkoutPage=new CheckoutPage(driver);
		checkoutOverviewPage=new CheckoutOverviewPage(driver);
	   
	}
	
	@After
	public void after()
	{
		driver.close();
	}	
}
