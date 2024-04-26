package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import GSD.BasePageTest;

public class OneCognizantPageTest extends BasePageTest
{

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public OneCognizantPageTest(WebDriver driver) 
	{
		super(driver);
	}
  
	@FindBy(id="oneC_searchAutoComplete")
    WebElement searchBox;
	@FindBy(className = "searchInputIcon")
    WebElement searchIcon;
    @FindBy(xpath="//img[@src=\"https://onecognizantcdn.cognizant.com/OneCCore/AppIcons/AppIcons2.0/app_2425.png\"]")
    WebElement liveSupportGsd;
    
    public void switchWindow()
    {
    	 Set<String> Windows = driver.getWindowHandles();
		    List<String> wins = new ArrayList(Windows);
		    driver.switchTo().window(wins.get(1));
		    System.out.println("Window is switched from Be Cognizant to Live Suppport GSD");
		    System.out.println();
    }
    public void serachClickGsd(String s) throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	if(s.equals("chrome"))
		{
			driver.findElement(By.xpath("//input[@id = 'oneC_searchAutoComplete']")).sendKeys("gsd");
		}
		else if(s.equals("edge"))
		{
			driver.findElement(By.xpath("//ul[@class = 'searchBasedTopBar']/li")).click();
			driver.findElement(By.xpath("//input[@id = 'oneCSearchTop']")).sendKeys("gsd");
		}
		Thread.sleep(2000);// To see the Live Support - GSD
		
    }
    public void liveSupportGsdclick()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src=\"https://onecognizantcdn.cognizant.com/OneCCore/AppIcons/AppIcons2.0/app_2425.png\"]")));
    	liveSupportGsd.click();
		
    }
}
