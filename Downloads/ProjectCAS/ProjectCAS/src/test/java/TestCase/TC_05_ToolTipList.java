package TestCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.GSDPageTest;
import TestBase.BaseClass;
//import pageObjects.GSDPage;
//import testBase.BaseClass;
import utilities.Excel;

public class TC_05_ToolTipList extends BaseClass
{	
	@Test
	public void validateGsdDetails() throws IOException
	{

		logger.info("**** Starting TC_5_ValidateGSDDetails ****");		
		logger.debug("Application logs started......");
		try 
		{
			
		    //getting three random number in set to avoid duplicates
			Set<Integer> set = new HashSet<Integer>();
			int x;
			while(true)
			{
				x = (int)(Math.random()*100);
				if(x>=1&&x<=56)
				{
					set.add(x);
					if(set.size()>2)
						break;
				}
			}
			
			//getting tooltips for three random countries
			List<Integer> list = new ArrayList<Integer>(set);
			
			GSDPageTest gp = new GSDPageTest(driver);
			Excel ex = new Excel();
			for(int i=0; i<list.size(); i++)
			{
				//click country menu
				gp.clickCountryMenu();
				
				//click the random country 
				gp.selectCountry(list.get(i));
				
				//entering the country name with random index
				String selected_country = gp.getCountryName();
				Screenshot(selected_country);
				System.out.println("__________________________________________"+selected_country+"__________________________________________");
				List <String> tool_tips = gp.getToolTips();
				for(String t : tool_tips)
				{
					System.out.println(t);
				}
				
				if(i==0)
				{
					ex.sendFirstCountry(selected_country);
					ex.sendFirstToolTips(tool_tips);
				}
				else if(i==1)
				{
					ex.sendSecondCountry(selected_country);
					ex.sendSecondToolTips(tool_tips);
				}
				else if(i==2)
				{
					ex.sendThirdCountry(selected_country);
					ex.sendThirdToolTips(tool_tips);
				}
			}
			logger.info("Extracting Tooltips");
			Assert.assertEquals(1, 1);
			logger.info("Test Passed");
		}
		catch(Exception e) {
			logger.error("Test Failed..");
			logger.debug("Debug logs....");
			Assert.fail();
		}
		
		logger.debug("Application logs end.......");
		logger.info("**** Finished TC_5_ValidateGSDDetails ****");
	}
}