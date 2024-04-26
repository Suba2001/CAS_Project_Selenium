package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import PageObjects.BasePageTest;

public class BeCognizantPageTest extends BasePageTest
{
	   
	
		public BeCognizantPageTest(WebDriver driver)
		{
			super(driver);
		}
		
		Actions act = new Actions(driver);
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		@FindBy(css=".\\_8ZYZKvxC8bvw1xgQGSkvvA\\=\\=")
	    WebElement userInfo;
	    @FindBy(id="mectrl_currentAccount_primary")
	    WebElement userName;
	    @FindBy(id="mectrl_currentAccount_secondary")
	    WebElement userId;
	    @FindBy(xpath="//div[@title='OneCognizant']")
	    WebElement oneC;
	    
	    public void userInfoclick() throws InterruptedException
	    {
	    	WebElement ab=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".\\_8ZYZKvxC8bvw1xgQGSkvvA\\=\\=")));
	    	ab.click();
	    	Thread.sleep(3000);
	    	ab.click();
	    	
	    }
	    public void getUserInfo() throws InterruptedException
	    {
	       // userName.click();
	    	Thread.sleep(3000);
			System.out.println(userName.getText());
			//userId.click();
			System.out.println(userId.getText());
	    }
	    public void oneCclick()
	    {
	    	oneC.click();
	    }
		
	
}
