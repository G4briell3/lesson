package Utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumber
{
	public static BigDecimal extractPriceBigDecimal(String pret)
	{
		Pattern pattern = Pattern.compile("\\d+\\.\\d+"); 
		Matcher matcher = pattern.matcher(pret);
		String priceString="";
		BigDecimal price = BigDecimal.ZERO;
		  if (matcher.find()) 
		  {
			  priceString=matcher.group();			 
			  price=new BigDecimal(priceString);			  
		  }
		 return price;
	}
	
	public static Double extractPriceDouble(String pret)
	{
		Pattern pattern = Pattern.compile("\\d+\\.\\d+"); 
		Matcher matcher = pattern.matcher(pret);
		String priceString="";
		double price=00.00;
		  if (matcher.find()) 
		  {
			  priceString=matcher.group();			 
			  price=Double.parseDouble(priceString);			  
		  }
		 return price;
	}
	
	public static Double extractPriceMultipleDecimalsDouble(String pret)
	{
		Pattern pattern = Pattern.compile("\\d+\\.\\d+"); 
		Matcher matcher = pattern.matcher(pret);
		String priceString="";
		double price=00.000000000;
		  if (matcher.find()) 
		  {
			  priceString=matcher.group();			 
			  price=Double.parseDouble(priceString);			  
		  }
		 return price;
	}
	

}
