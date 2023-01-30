package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DriverManager 
{
	public static WebDriver driver;
	Alert objalert;
	Select objdrop;
	
	public void launchBrowser(String url,String browser ) throws InterruptedException 
	{
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();//constructor
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
		}
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();//constructor
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
		}
		if(browser.equals("Edge"))
		{
			System.setProperty("webdriver.msedge.driver", "C:\\Users\\dell\\Downloads\\msedgedriver.exe");
			driver=new EdgeDriver();//constructor
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(4000);
		}
	}
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void scrolltoelement(WebElement element)
	{
	///////////////Scroll to end///////////////////
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);/////to scroll
	}
	public void scrolltoelement2(WebElement element) throws InterruptedException
	{
	///////////////Scroll to ///////////////////
		JavascriptExecutor jse = (JavascriptExecutor)driver;  
		jse.executeScript("scrollBy(0, 500)");  
		Thread.sleep(5000); 
	}
	
	//////////////////Alert manager/////////////////////
	public void alertaccept() throws InterruptedException 
	{
		objalert=driver.switchTo().alert();
		objalert.accept();
		
	}
	public void alertdismiss() throws InterruptedException 
	{
		objalert=driver.switchTo().alert();
		objalert.dismiss();
		
	}
	public String alertgettext() throws InterruptedException 
	{
		objalert=driver.switchTo().alert();
		return objalert.getText();
		
	}
	public void alertsendkeys(String value) throws InterruptedException 
	{
		objalert=driver.switchTo().alert();
		objalert.sendKeys(value);
		
	}
	/////////////////Drop down manager///////////////////
	
	public void dropvalue(WebElement drop,String dvalue) 
	{ 
		Select objdrop = new Select(drop);
		objdrop.selectByValue(dvalue);
		
	}
	////////////////Screenshot//////////////////////
	public void screenshot() throws IOException 
	{
		/////////for save different name in screenshot////////
		/////////https://www.javatpoint.com/java-get-current-date//////////
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		TakesScreenshot scrShot =(TakesScreenshot)driver;
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File("C:\\Users\\dell\\eclipse-workspace\\MavenSelenium\\src\\main\\resources\\Screenshots\\test2"+dtf.format(now)+".png");
	    //Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

}

