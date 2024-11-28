package Utils;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebElement;

public class Generate 
{  
  public static List<String> listOfItems (List<WebElement> productElements)
  {
	  List<String> valoriListaProduse =new ArrayList<String>();
	  for (WebElement element:productElements)
	  {		 
		  valoriListaProduse.add(element.getText());		  
	  }
	  return valoriListaProduse;
  }
  
  public static List<Double> listOfItemsPrices (List<WebElement> productElements)
  {
	  List<String> valoriListaProduse =new ArrayList<String>();
	  List<Double> valoriDoublePret=new ArrayList<Double>();
	  Double valoare=00.00;
	  for (WebElement element:productElements)
	  {
		 
		  valoriListaProduse.add(element.getText());		  
	  }
	  for (String produs:valoriListaProduse)
	  {
		  valoriDoublePret.add(valoare=ExtractNumber.extractPriceDouble(produs));
	  }
	  return valoriDoublePret;
  }
  public static boolean isSortedAlphabeticallyAZ(List<String> list) 
  {
	  for (int i = 0; i < list.size() - 1; i++)
	  {
		  if (list.get(i).compareTo(list.get(i + 1))>0) 
		  {
			  return false;
		  }			  
	  }
	  return true;
  }
  
  public static boolean isSortedAlphabeticallyZA(List<String> list) 
  {
	  for (int i = 0; i < list.size() - 1; i++)
	  {
		  if (list.get(i + 1).compareTo(list.get(i))>0) 
		  {
			  return false;
		  }			  
	  }
	  return true;
  }
  public static boolean isSortedAscending(List<Double> itemsOnPageHILO) 
  {
	  for (int i = 0; i < itemsOnPageHILO.size() - 1; i++)
	  {
		  if (itemsOnPageHILO.get(i).compareTo(itemsOnPageHILO.get(i + 1))>0) 
		  {
			  return false;
		  }			  
	  }
	  return true;
  }
  
  public static boolean isSortedDescending(List<Double> itemsOnPageHILO) 
  {
	  for (int i = 0; i < itemsOnPageHILO.size() - 1; i++)
	  {
		  if (itemsOnPageHILO.get(i + 1).compareTo(itemsOnPageHILO.get(i))>0) 
		  {
			  return false;
		  }			  
	  }
	  return true;
  }
  
}


