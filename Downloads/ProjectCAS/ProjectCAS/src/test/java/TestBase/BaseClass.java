package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass
{
	
	
	public static WebDriver driver;
	public static FileInputStream file;
	public static Properties p = new Properties();
	public static int count=0;
	public static Logger logger;
	
	
	@BeforeTest
	  @Parameters({"browser"})
	  public void setup(String br) 
	  {
		
		try
		{
			file = new FileInputStream("C:\\Users\\2318566\\Downloads\\ProjectCAS\\ProjectCAS\\src\\test\\resources\\config.properties");
			p.load(file);
		}
		catch(Exception e)
		{
			System.out.println("File not Found");
		}
		
		  if(br.equals("chrome"))
		  {
			  driver = new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			  logger=LogManager.getLogger(this.getClass());
			  driver.get(p.getProperty("baseUrl"));
			  driver.manage().window().maximize();
		  }
		  else if(br.equals("edge"))
		  {
			  driver = new EdgeDriver();
			 // driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			  logger=LogManager.getLogger(this.getClass());
			  driver.get(p.getProperty("baseUrl"));
			  driver.manage().window().maximize();
		  }
	  }
	
	
	
	@AfterTest
	  public void exit()
	  {
		  driver.quit();
	  }
	public static String Screenshot(String tname) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);		
		sourceFile.renameTo(targetFile);			
		return targetFilePath;
	}
}
