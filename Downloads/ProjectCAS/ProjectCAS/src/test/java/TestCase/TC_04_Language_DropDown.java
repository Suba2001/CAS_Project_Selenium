package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.GSDPageTest;
import TestBase.BaseClass;

public class TC_04_Language_DropDown extends BaseClass{
	
	 @Test
	  public void listLang()
	  { 

			logger.info("**** Starting TC_4_ValidateLanguageList ****");		
			logger.debug("Application logs started......");
		 GSDPageTest obj3 = new GSDPageTest(driver);
		 try 
		 {
		  
		  //get language list	 
		  obj3.langList();
		  logger.info("Validating Language List");
		  logger.info("Test Passed");
	  }
		 catch(Exception e)
		 {
		  logger.error("Test Failed..");
			logger.debug("Debug logs....");
		  Assert.fail();
	  }
		 logger.debug("Application logs end.......");
			logger.info("**** Finished TC_4_ValidateLanguageList ****");
	  }
}
