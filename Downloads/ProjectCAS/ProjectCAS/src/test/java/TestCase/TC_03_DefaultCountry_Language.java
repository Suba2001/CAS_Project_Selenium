package TestCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.GSDPageTest;
import TestBase.BaseClass;

public class TC_03_DefaultCountry_Language extends BaseClass {

	 @Test
	  public void countryDef()
	  { 
		 logger.info("**** Starting TC_3_ValidateLanguageAndCountry ****");		
			logger.debug("Application logs started......");
	
			GSDPageTest obj3 = new GSDPageTest(driver);
	try 
	{ 
		  //validating default country
		  obj3.defCountry();
		 
		  logger.info("Validating Default Country");
			 
		 
	     //File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 Screenshot("defaultPage");
	     //validating default language
	     obj3.defLang();
		 logger.info("Validating Default Language");
			 logger.info("Test Passed");
			 Assert.assertTrue(true);
	  }
	      catch(Exception e) 
	     {
	    	  logger.error("Test Failed..");
				logger.debug("Debug logs....");
		  Assert.fail();
	     }
	logger.debug("Application logs end.......");
	logger.info("**** Finished TC_2_ValidateLanguageAndCountry ****");
	  }
	 
	  
}
