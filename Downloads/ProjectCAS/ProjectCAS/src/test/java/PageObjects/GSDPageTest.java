package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestBase.BaseClass;

public class GSDPageTest extends BasePageTest 
{
	JavascriptExecutor js;
	
	public GSDPageTest(WebDriver driver) 
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//p[@class='Welcome-automated-text']")
    WebElement act_text1;  
    @FindBy(xpath="/html/body/nav[1]/div/form/div[2]/a/span")
    WebElement defCountry;
    @FindBy(xpath="(//span[normalize-space()='English'])[1]")
    WebElement defLang;
    @FindBy(xpath="//*[@id=\"menu1\"]/span")
    WebElement defLangDd;
    @FindBy(xpath="//a[@role='menuitem']")
    List<WebElement> LangList;
    @FindBy(xpath="//div[@class='col-md-12 application-tiles']")
    List<WebElement> toolTipList;
    @FindBy(xpath="//span[@class='optionCountrySelected']")
    WebElement countryDd;
    @FindBy(xpath="//ul[@class='dropdown-menu countryList pt-0 show']//a")
    List<WebElement> CountryList;
    @FindBy(xpath="//nav[@class='navbar navbar-light app-headers navbar-expand-lg py-0']//span[@class='optionCountrySelected']")
	WebElement selected_country;
    
	
	
	public void frameSwitch() throws InterruptedException
    {
		Thread.sleep(3000);
	    driver.switchTo().frame("appFrame");
		System.out.println("Driver instance is switched to Iframe");
		System.out.println();
    }
    public boolean wtextvalidate() throws InterruptedException
    {
    	Thread.sleep(3000);
    	String exp_wtext1="Welcome to the all-in-one Live Support!";
		//String exp_wtext2="Browse queries. Chat with an agent. Submit and track tickets.";
		String act_wtext1=act_text1.getText();
		//String act_wtext2=act_text2.getText();
		if(exp_wtext1.equals(act_wtext1))
		{
			System.out.println("Welcome text is validated");
			System.out.println("The Welcome text is : " +act_wtext1);
			return true;
		}
		else
		{
			System.out.println("Welcome text is incorrect");
			System.out.println("The Welcome text is : " +act_wtext1);
			return false;
		}
		
		
    }
    public boolean defCountry()
    {
    	String act_country=defCountry.getText();
    	String exp_country = "India";
    	if(exp_country.equals(act_country))
    	{
    		System.out.println("Default country is validated");
    		return true;
    	}else {
    		return false;
    	}
		
    }
    public boolean defLang()
    {
    	
		String act_lang=defLang.getText();
		act_lang.trim();
		String exp_lang="English";
		if(exp_lang.equals(act_lang))
		{
			System.out.println("Default Language is validated");
			return true;
		}else {
			System.out.println("Default Language is not validated");
			return false;
		}
		
		
    }
    public void langList()
    {
    	defLangDd.click();
	    System.out.println("The languages  are "+ LangList.get(0).getText()+" , "+LangList.get(1).getText());
    }
    
    public void clickCountryMenu()
	{
		countryDd.click();
	}
	
	public void selectCountry(int i)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement c = CountryList.get(i);
		js.executeScript("arguments[0].click();", c);
	}
	
	public String getCountryName()
	{
		String country_name = selected_country.getText();
		return country_name;
	}
	
	public List<String> getToolTips()
	{
		List <String> tool_tips_list = new ArrayList<String>();
		for(WebElement t : toolTipList)
		{
			Actions act = new Actions(driver);
			act.moveToElement(t);
			tool_tips_list.add(t.getText()+" - "+t.getAttribute("data-bs-original-title"));
		}
		return tool_tips_list;
	}
   
	
	
   
   
    
    
}
