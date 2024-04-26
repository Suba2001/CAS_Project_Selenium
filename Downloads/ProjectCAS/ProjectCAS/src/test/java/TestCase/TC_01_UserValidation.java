package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BeCognizantPageTest;
import TestBase.BaseClass;
public class TC_01_UserValidation extends BaseClass{

	
		
			
	     @Test
		  public void userInfo() throws InterruptedException 
		  {		 
	    	 logger.info("**** Starting TC_1_ValidateUser ****");		
	 		logger.debug("Application logs started......");
	    	 BeCognizantPageTest obj1 = new BeCognizantPageTest(driver);
			try 
			{
				
			//clicking user info button	
			 obj1.userInfoclick();
			 logger.info("Clicked on User Information");
		     
			 //getting user name and mail id
			 obj1.getUserInfo();
		     logger.info("Getting User Information");
		     
		     //click one cognizant
		     obj1.oneCclick();
		     logger.info("Clicked on One Cognizant");
		     logger.info("Test Passed");
		  }
			
			catch(Exception e) {
				logger.error("Test Failed..");
				logger.debug("Debug logs....");
			  Assert.fail();
		  }
		  
	 	logger.debug("Application logs end.......");
		logger.info("**** Finished TC_1_ValidateUser ****");	
		  }
		  
}
