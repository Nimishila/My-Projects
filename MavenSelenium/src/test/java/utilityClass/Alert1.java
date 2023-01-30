package utilityClass;

import org.testng.annotations.Test;
import utility.DriverManager;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Alert1 extends DriverManager{
	WebDriver driver;
	
	@Test(priority=1,enabled = true)
	public void simplealert() throws InterruptedException 
	{
		////////////////////Simple alert////////////////////////
		WebElement alertandModels = driver.findElement(By.xpath("//*[@id=\"alert-modal\"]"));
		alertandModels.click();
		Thread.sleep(4000);
		///////java script alert
		WebElement javascriptalert = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[5]/a"));
		javascriptalert.click();
		Thread.sleep(4000);
		///////button of 1st box
		WebElement button=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div[2]/button"));
		button.click();
		Thread.sleep(4000);
		/*Alert objalert = driver.switchTo().alert();
		String alert1=objalert.getText();//////get alert text (I am a Java script alert box!)
		System.out.println(alert1);
		Thread.sleep(4000);
		objalert.accept();//////to accept alert*/
		String alert2=alertgettext();
		System.out.println(alert2);
		Thread.sleep(4000);
		alertaccept();	
		Thread.sleep(4000);
		
	}
	
	@Test(priority=2,enabled=true)
	public void confirmalert() throws InterruptedException 
	{
		//////////////////Confirmation alert////////////////////
		//alert();
		////////button for 2nd box
		WebElement button=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/p[4]/button"));
		button.click();
		//Alert objalert = driver.switchTo().alert();
		String alert3=alertgettext();///////get alert text (Press a button!)
		System.out.println(alert3);
		alertaccept();//////to accept alert(OK)
		Thread.sleep(4000);
		WebElement msg=driver.findElement(By.id("confirm-demo"));
		String message=msg.getText();
		System.out.println(message);//////you pressed OK				
	}	
	
	@Test(priority=3,enabled=true)
	public void promptbox() throws InterruptedException 
	{
		///////////////prompt box dismiss///////////////////
		//alert();
		////////button for 3rd box
		WebElement button=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div/div[2]/button"));
		scrolltoelement2(button);
		Thread.sleep(4000);
		button.click();
		//Alert objalert = driver.switchTo().alert();
		String alert3=alertgettext();
		System.out.println(alert3);
		alertsendkeys("Nimishila bhai.N");////for enter name
		Thread.sleep(4000);
		alertaccept();
		Thread.sleep(4000);
		WebElement txt=driver.findElement(By.id("prompt-demo"));
		String text=txt.getText();////display message (You have entered 'Nimishila Bhai.N' !)
		System.out.println(text);
		if(text.contains("Nimishila bhai.N"))
		{
			Assert.assertTrue(true);
			System.out.println("Entered text same");
		}else 
		{
			Assert.assertTrue(false,"Not same");
		}
		
		/*if (text==null||text.isEmpty()) 
		{ //compare the value
			Assert.assertTrue(true,"null");
		}else 
		{
			Assert.assertTrue(false,"not empty");
		}*/
		
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==2)
		{
			screenshot();
		}
	}
  @BeforeTest

  public void beforeTest() throws InterruptedException 
  {
  String url = "https://selenium.obsqurazone.com/index.php";
  String browser="Chrome";
  launchBrowser(url,browser);
  this.driver=super.driver;
  }

  @AfterTest

  public void afterTest() 
  {
	  closeBrowser();
  }

  
}
